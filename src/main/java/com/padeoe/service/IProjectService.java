package com.padeoe.service;

import com.padeoe.pojo.Project;

/**
 * com.padeoe.service.impl
 *
 * @author troy_diao on 2016/11/17
 */
public interface IProjectService {
    public void saveProject(Project project);

    public Project getProjectByName(String name);

}
