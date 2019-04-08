package top.sicso.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import top.sicso.blog.common.service.impl.BaseServiceImpl;
import top.sicso.blog.pojo.Project;
import top.sicso.blog.repository.ProjectRepository;
import top.sicso.blog.service.ProjectsService;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project,Integer> implements ProjectsService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    protected JpaRepository<Project, Integer> getRepository() {
        return projectRepository;
    }
}
