package top.sicso.blog.service;

import org.springframework.data.domain.Page;
import top.sicso.blog.common.service.BaseService;
import top.sicso.blog.pojo.Project;
import top.sicso.blog.vo.ProjectCondition;
import top.sicso.blog.vo.ProjectVO;

import java.util.List;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public interface ProjectService {

    Project addProject(ProjectVO projectVO);

    void deleteProject(Integer id);

    void updateProject(ProjectVO projectVO);

    ProjectVO getProjectById(Integer id);

    Page<ProjectVO> getProject(ProjectCondition projectCondition);

    List<ProjectVO> getProject();

}
