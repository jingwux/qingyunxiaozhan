package top.sicso.blog.service.impl;

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
import top.sicso.blog.pojo.Project;
import top.sicso.blog.repository.ProjectRepository;
import top.sicso.blog.service.ProjectService;
import top.sicso.blog.utils.SortUtil;
import top.sicso.blog.vo.BlogVO;
import top.sicso.blog.vo.ProjectCondition;
import top.sicso.blog.vo.ProjectVO;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(ProjectVO projectVO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectVO, project);
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(ProjectVO projectVO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectVO, project);
        projectRepository.saveAndFlush(project);
    }

    @Override
    public Page<ProjectVO> getProject(ProjectCondition projectCondition) {
        Sort sort = SortUtil.createSort(projectCondition);

        PageRequest pageRequest = PageRequest.of(projectCondition.getPageIndex(), projectCondition.getPageSize(), sort);
        // 动态SQL
        Specification<Project> specification = (Specification<Project>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (projectCondition.getId() != null) {
                Predicate id = criteriaBuilder.equal(root.get("id").as(Integer.class), projectCondition.getId());
                predicates.add(id);
            }
            if (StringUtils.isNotBlank(projectCondition.getName())) {
                Predicate likeName = criteriaBuilder.like(root.get("name").as(String.class), "%" + projectCondition.getName() + "%");
                predicates.add(likeName);
            }
            if (StringUtils.isNotBlank(projectCondition.getTech())) {
                Predicate likeTags = criteriaBuilder.like(root.get("tech").as(String.class), "%" + projectCondition.getTech() + "%");
                predicates.add(likeTags);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Project> page = projectRepository.findAll(specification, pageRequest);

        List<Project> projects = page.getContent();
        return new PageImpl<>(getProjectVO(projects), pageRequest, page.getTotalElements());
    }

    @Override
    public List<ProjectVO> getProject() {
        return getProjectVO(projectRepository.findAll());
    }


    private List<ProjectVO> getProjectVO(List<Project> projects) {
        List<ProjectVO> projectVOList = new ArrayList<>();
        projects.forEach(project -> {
            ProjectVO projectVO = new ProjectVO();
            BeanUtils.copyProperties(project, projectVO);
            projectVOList.add(projectVO);
        });
        return projectVOList;
    }


}
