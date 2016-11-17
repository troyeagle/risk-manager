package com.padeoe.service;

import com.padeoe.pojo.Project;

import java.util.List;

/**
 * com.padeoe.service.impl
 *
 * @author troy_diao on 2016/11/17
 */
public interface IProjectService {
    public void saveProject(Project project);

    public Project getProjectByName(String name);

    public void deleteProject(String name);

    public List<Project> getProjects();
}
