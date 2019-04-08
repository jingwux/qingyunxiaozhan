package top.sicso.non.service;//package me.sicso.non.service;
//
//import lombok.extern.slf4j.Slf4j;
//import ArchiveVO;
//import Blog;
//import me.sicso.non.mapping.BlogMapper;
//import BlogSer;
//import TimeTools;
//import Tools;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.Caching;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Slf4j
//public class BlogSerImpl implements BlogSer {
//
//    private BlogMapper blogMapper;
//
//    @Autowired
//    public BlogSerImpl(BlogMapper blogMapper) {
//        this.blogMapper = blogMapper;
//    }
//
//    @Override
//    public Blog adminGetBlog(int vid){
//        return blogMapper.selectAdmin(vid);
//    }
//
//    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "archives",key = "1"),
//            @CacheEvict(value = "tagList",key = "1"),
//            @CacheEvict(value = "archivePageNum",key = "1")
//    })
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public void addBlog(Blog blogView){
//        blogView.setDate(new Date(System.currentTimeMillis()));
//        blogMapper.insertBlog(blogView);
//        addViewTag(blogView.getTags(),blogView.getVid());
//    }
//    @Override
//    public List<Blog> getBlogPage(int id){
//            int start=(id-1)*10;
//        return blogMapper.selectTenBlogs(start);
//    }
//    @Override
//    public int adminGetPageNum(){
//        int num=blogMapper.selectBlogNum();
//    return num%10==0?num/10:num/10+1;
//    }
//
//    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "archives",key = "1"),
//            @CacheEvict(value = "tagList",key = "1")
//    })
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public void updateBlog(Blog blogView){
//        blogMapper.updateBlogView(blogView);
//        updateViewTag(blogView.getTags(),blogView.getVid());
//    }
//
//    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "archives",key = "1"),
//            @CacheEvict(value = "tagList",key = "1"),
//            @CacheEvict(value = "archivePageNum",key = "1")
//    })
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public void deleteBlogById(int vid) {
//        blogMapper.deleteBlogView(vid);
//    }
//
//    @Override
//    @Cacheable(value = "tagList",key = "1")
//    public List<String> getTagList(){
//        return blogMapper.selectTags();
//    }
//
//    @Override
//    @Cacheable(value = "archives",condition = "#page==1",key = "1")
//    public List<ArchiveVO> getArchive(int page){
//        int start=(page-1)*12;
//        return bv2Ar(blogMapper.selectArc(start));
//    }
//
//    @Override
//    @Cacheable(value = "archivePageNum",key = "1")
//    public int getArchiveNum(){
//        int blogNum=blogMapper.selectBlogNum();
//        return blogNum%12==0?blogNum/12:blogNum/12+1;
//    }
//
//    @Override
//    public Blog getBlog(int vid){
//        return blogMapper.selectView(vid);
//    }
//
//    @Override
//    public Blog getPrevBlog(int vid){
//        return blogMapper.selectPreView(vid);
//    }
//
//    @Override
//    public Blog getNextBlog(int vid) {
//        Blog blogView=null;
//        try {
//            blogView=blogMapper.selectNextView(vid);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        return blogView;
//    }
//
//    @Override
//    public List<Blog> getBlogByTag(String tagName){
//        List<Blog> views=new ArrayList<>();
//            List<Integer> vids=blogMapper.selectVidBytag(tagName);
//            for (int vid:vids){
//                Blog view=blogMapper.selectTagView(vid);
//                if (view!=null){
//                    view.setVid(vid);
//                    String monthDay=TimeTools.getEdate(view.getDate());
//                    view.setMonthDay(monthDay);
//                    views.add(view);
//                }
//            }
//        return views;
//    }
//
//    private List<ArchiveVO> bv2Ar(List<Blog> views){
//        List<ArchiveVO> archives=new ArrayList<>();
//        Map<Integer,ArchiveVO> years2Ar=new HashMap<>();
//        for (Blog view:views){
//            Date date=view.getDate();
//            view.setMonthDay(TimeTools.getEdate(date));
//            int year=TimeTools.getYear(date);
//            if (years2Ar.containsKey(year)){
//                years2Ar.get(year).getList().add(view);
//            }else {
//                ArchiveVO archive=new ArchiveVO(year,new ArrayList<Blog>());
//                years2Ar.put(year,archive);
//                archive.getList().add(view);
//                archives.add(archive);
//            }
//        }
//        return archives;
//    }
//    private void addViewTag(String tagStr,int vid){
//        List<String> tagList=Tools.getTagList(tagStr);
//        for (String tag:tagList){
//            blogMapper.insertViewTag(tag,vid);
//        }
//
//    }
//    private void updateViewTag(String tagStr,int vid){
//        blogMapper.deleteViewTag(vid);
//        List<String> tagList=Tools.getTagList(tagStr);
//        for (String tag:tagList){
//            blogMapper.insertViewTag(tag,vid);
//        }
//
//    }
//
//}
