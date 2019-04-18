package top.sicso.blog.service.impl;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.sicso.blog.pojo.Blog;
import top.sicso.blog.pojo.Tag;
import top.sicso.blog.repository.BlogRepository;
import top.sicso.blog.repository.TagRepository;
import top.sicso.blog.service.BlogService;
import top.sicso.blog.vo.ArchiveVO;
import top.sicso.blog.vo.BlogCondtion;
import top.sicso.blog.vo.BlogVO;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public PageInfo<BlogVO> getBlogByCondition(BlogCondtion blogCondtion) {
        Sort sort = null;
        if (StringUtils.isNotBlank(blogCondtion.getSort()) && StringUtils.isNotBlank(blogCondtion.getOrder())) {
            sort = new Sort(Sort.Direction.valueOf(blogCondtion.getSort()), blogCondtion.getOrder());
        }

        // Todo
        //  sort不能为null
        PageRequest pageRequest = PageRequest.of(blogCondtion.getPageIndex(), blogCondtion.getPageSize(), sort);

        // 动态SQL
        Specification<Blog> specification = (Specification<Blog>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(blogCondtion.getTitle())) {
                Predicate likeTitle = criteriaBuilder.like(root.get("title").as(String.class), "%" + blogCondtion.getTitle() + "%");
                predicates.add(likeTitle);
            }
            if (StringUtils.isNotBlank(blogCondtion.getTags())) {
                Predicate likeTags = criteriaBuilder.like(root.get("tags").as(String.class), "%" + blogCondtion.getTags() + "%");
                predicates.add(likeTags);
            }
            if (blogCondtion.getId() != null) {
                Predicate id = criteriaBuilder.equal(root.get("id").as(Integer.class), blogCondtion.getId());
                predicates.add(id);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<BlogVO> blogVOList = new ArrayList<>();
        List<Blog> blogs = blogRepository.findAll(specification, pageRequest).getContent();
        blogs.forEach(p -> {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(p, blogCondtion);
            blogVOList.add(blogVO);
        });
        return new PageInfo<>(blogVOList);
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
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


    private BlogVO blogWrap(Blog blog) {
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blog, blogVO);
        return blogVO;
    }

}
