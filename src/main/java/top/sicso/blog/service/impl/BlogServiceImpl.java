package top.sicso.blog.service.impl;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.repository.BlogRepository;
import top.sicso.blog.repository.TagRepository;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.utils.SortUtil;
import top.sicso.blog.vo.ArchiveVO;
import top.sicso.blog.vo.BlogCondition;
import top.sicso.blog.vo.BlogVO;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public BlogVO getBlogByBlogId(Integer blogId) {
        Blog blog = blogRepository.getOne(blogId);
        BlogVO blogVO = blogWrap(blog);
        Blog prevBlog = blogRepository.findPrevBlog(blogId);
        Blog nextBlog = blogRepository.findNextBlog(blogId);
        blogVO.setPrevBlog(prevBlog);
        blogVO.setNextBlog(nextBlog);
        return blogVO;
    }

    @Override
    public PageInfo<ArchiveVO> getArchivesOrderByMonth(int pageIndex) {
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        // 获取按年月分组后的日期
        List<String> yearAndMonthDate = blogRepository.findGroupByDate(--pageIndex);
        List<ArchiveVO> archiveVOList = new ArrayList<>();
        // 遍历日期，按日期查询文章
        yearAndMonthDate.forEach(item -> {
            ArchiveVO archiveVO = new ArchiveVO();
            archiveVO.setList(blogRepository.findBlogByDate(item));
            archiveVO.setYear(item.substring(0, item.lastIndexOf("-")));
            archiveVO.setMonth(item.substring(item.lastIndexOf("-")));
            archiveVOList.add(archiveVO);
        });
        return new PageInfo<>(archiveVOList);
    }

    @Override
    public PageInfo<BlogVO> getBlogByTagName(String tagName) {
        List<Blog> blogList = blogRepository.findBlogByTagsContains(tagName);
        List<BlogVO> blogVOList = new ArrayList<>();
        blogList.forEach(item -> {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(item, blogVO);
            blogVOList.add(blogVO);
            System.out.println(item);
        });

        return new PageInfo<>(blogVOList);
    }

    @Override
    public Page<BlogVO> getBlogByCondition(BlogCondition blogCondition) {

        Sort sort = SortUtil.createSort(blogCondition);

        PageRequest pageRequest = PageRequest.of(blogCondition.getPageIndex(), blogCondition.getPageSize(), sort);
        // 动态SQL
        Specification<Blog> specification = (Specification<Blog>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(blogCondition.getTitle())) {
                Predicate likeTitle = criteriaBuilder.like(root.get("title").as(String.class), "%" + blogCondition.getTitle() + "%");
                predicates.add(likeTitle);
            }
            if (StringUtils.isNotBlank(blogCondition.getTags())) {
                Predicate likeTags = criteriaBuilder.like(root.get("tags").as(String.class), "%" + blogCondition.getTags() + "%");
                predicates.add(likeTags);
            }
            if (blogCondition.getId() != null) {
                Predicate id = criteriaBuilder.equal(root.get("id").as(Integer.class), blogCondition.getId());
                predicates.add(id);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<BlogVO> blogVOList = new ArrayList<>();
        Page<Blog> page = blogRepository.findAll(specification, pageRequest);

        List<Blog> blogs = page.getContent();
        blogs.forEach(p -> {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(p, blogVO);
            blogVOList.add(blogVO);
        });

        return new PageImpl<>(blogVOList,pageRequest,page.getTotalElements());
    }

    @Override
    public Blog addBlog(Blog blog) {
        Blog b = blogRepository.saveAndFlush(blog);
        List<String> tags = Arrays.asList(blog.getTags().split(","));
        tags.forEach(t -> {
            Tag tag = new Tag();
            tag.setTagName(t);
            tag.setBlogId(b.getId());
            tagRepository.save(tag);
        });
        return b;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.saveAndFlush(blog);
    }

    @Override
    public void deleteBlog(Integer blogId) {
        blogRepository.deleteById(blogId);
    }

    @Override
    public Tag getTagByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }


    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> getTagsByBlogId(Integer blogId) {
        return tagRepository.findByBlogId(blogId);
    }


    private long getBlogsCount(){
        return blogRepository.count();
    }

    private BlogVO blogWrap(Blog blog) {
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blog, blogVO);
        return blogVO;
    }

}
