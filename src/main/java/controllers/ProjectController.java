package controllers;

import services.ProjectService;

public class ProjectController {


private ProjectService projectService;

public ProjectController() {
    projectService = new ProjectService();
}

// Create project
public void createProject(String projectId, String projectName) {

    projectService.createProject(projectId, projectName);
}

// Add member
public void addMember(String projectId, String username) {

    projectService.addMember(projectId, username);
}

// Show all projects
public void listProjects() {

    projectService.listProjects();
}


}
