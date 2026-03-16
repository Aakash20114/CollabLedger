package models;

public class Contribution {
    private String contributor;
    private String task;
    private String timestamp;

    public Contribution() {}

    public Contribution(String contributor, String task, String timestamp) {
        this.contributor = contributor;
        this.task = task;
        this.timestamp = timestamp;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
