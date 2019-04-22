package top.sicso.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sicso.blog.repository.ProjectRepository;
import top.sicso.blog.service.ProjectsService;

@Service
public class ProjectServiceImpl implements ProjectsService {

    @Autowired
    private ProjectRepository projectRepository;


    

}
