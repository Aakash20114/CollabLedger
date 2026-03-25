package services;

import database.ProjectRepository;
import models.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    private List<Project> projects;
    private ProjectRepository repository;

    public ProjectService() {
        projects = new ArrayList<>();
        repository = new ProjectRepository();
    }

    // Create a new project
    public void createProject(String projectId, String projectName) {

        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName(projectName);
        project.setMembers(new ArrayList<>());

        // Save in memory
        projects.add(project);

        // Save in MongoDB
        repository.createProject(project);

        System.out.println("Project created: " + projectName);
    }

    // Add member to project
    public void addMember(String projectId, String username) {

        for (Project project : projects) {

            if (project.getProjectId().equals(projectId)) {

                project.getMembers().add(username);

                System.out.println("Member added to project: " + username);
                return;
            }
        }

        System.out.println("Project not found.");
    }

    // List all projects
    public void listProjects() {

        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }

        for (Project project : projects) {

            System.out.println("Project ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Members: " + project.getMembers());

            System.out.println("----------------------");
        }
    }
}