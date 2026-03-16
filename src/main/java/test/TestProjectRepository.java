package test;

import database.ProjectRepository;
import models.Project;

import java.util.Arrays;

public class TestProjectRepository {

    public static void main(String[] args) {

        ProjectRepository repo = new ProjectRepository();

        Project project = new Project(
                "P101",
                "SolarPump",
                Arrays.asList("Aakash", "Ravi", "Meena")
        );

        repo.createProject(project);

        System.out.println("Project inserted successfully");

    }
}