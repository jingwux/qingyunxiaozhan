package top.sicso.non.service;//package me.sicso.non.service;
//
//import Project;
//import me.sicso.non.mapping.ProjectMapper;
//import ProjectSer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.Caching;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Transactional;
//import java.sql.Timestamp;
//import java.util.List;
//
//@Service
//public class ProjectSerImpl implements ProjectSer {
//
//    private ProjectMapper projectMapper;
//
//    @Autowired
//    public ProjectSerImpl(ProjectMapper projectMapper) {
//        this.projectMapper = projectMapper;
//    }
//
//    @Override
//    @Cacheable(value = "projects",condition = "#page==1",key = "1")
//    public List<Project> getPros(int page){
//        int start = (page - 1) * 5;
//        return projectMapper.select(start);
//    }
//
//    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "projects",key = "1"),
//            @CacheEvict(value = "projectPageNum",key = "1")
//    })
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    public void addPro(Project project){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        project.setDate(timestamp);
//        projectMapper.insert(project);
//    }
//
//    @Override
//    public List<Project> adminGetPros(int page){
//        int start = (page - 1) * 10;
//        return projectMapper.adminSelect(start);
//    }
//
//    @Override
//    public int adminGetPageNum(){
//        int count = projectMapper.count();
//        return count % 10 == 0 ? count / 10 : count / 10 + 1;
//    }
//
//    @Override
//    @Caching(evict = {
//            @CacheEvict(value = "projects",key = "1"),
//            @CacheEvict(value = "projectPageNum",key = "1")
//    })
//    public void deletePro(int id){
//            projectMapper.delete(id);
//    }
//
//    @Override
//    public Project getProById(String idStr){
//        int id = Integer.parseInt(idStr);
//        return  projectMapper.selectById(id);
//    }
//
//    @Override
//    @CacheEvict(value = "projects",key = "1")
//    public void updatePro(Project project) {
//            projectMapper.update(project);
//    }
//
//    @Override
//    @Cacheable(value = "projectPageNum",key = "1")
//    public int getPageNum(){
//        int count = projectMapper.count();
//        return count % 5 == 0 ? count / 5 : count / 5 + 1;
//    }
//}
