package com.padeoe.service.impl;

import com.padeoe.dao.IProjectDao;
import com.padeoe.pojo.Project;
import com.padeoe.service.IProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.padeoe.service.impl
 *
 * @author troy_diao on 2016/11/17
 */
@Service("projectService")
public class ProjectServiceImpl implements IProjectService {

    @Resource
    private IProjectDao projectDao;

    @Override
    public void saveProject(Project project) {
        if(project.getName()==null) throw new RuntimeException("name 不能为空");
        if(projectDao.selectByPrimaryKey(project.getName())!=null) throw new RuntimeException("name 已经存在");
        projectDao.insert(project);
    }

    @Override
    public Project getProjectByName(String name) {
        return projectDao.selectByPrimaryKey(name);
    }

    @Override
    public void deleteProject(String name) {
        projectDao.deleteByPrimaryKey(name);
    }

    @Override
    public List<Project> getProjects() {
        return projectDao.selectAll();
    }
}
