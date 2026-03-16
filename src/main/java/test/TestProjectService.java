package test;

import services.ProjectService;

public class TestProjectService {

    public static void main(String[] args) {

        ProjectService service = new ProjectService();

        service.createProject("P201", "SmartFarm");

        service.addMember("P201", "Aakash");
        service.addMember("P201", "Ravi");

        service.listProjects();
    }
}