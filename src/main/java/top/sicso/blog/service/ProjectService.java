package top.sicso.blog.service;

import org.springframework.data.domain.Page;
import top.sicso.blog.common.service.BaseService;
import top.sicso.blog.pojo.Project;
import top.sicso.blog.vo.ProjectCondition;
import top.sicso.blog.vo.ProjectVO;

import java.util.List;

public interface ProjectService {

    Project addProject(ProjectVO projectVO);

    void deleteProject(Integer id);

    void updateProject(ProjectVO projectVO);

    Page<ProjectVO> getProject(ProjectCondition projectCondition);

    List<ProjectVO> getProject();

}
