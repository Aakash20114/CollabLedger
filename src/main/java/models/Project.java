package models;
import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private List<String> members;

    public Project() {}

    public Project(String projectId, String projectName, List<String> members) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.members = members;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
