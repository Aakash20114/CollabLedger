package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.Project;
import org.bson.Document;

// import java.util.ArrayList;
// import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ProjectRepository {

private MongoCollection<Document> collection;

public ProjectRepository() {

    MongoDatabase db = MongoDBConnection.getDatabase();
    collection = db.getCollection("projects");
}

public void createProject(Project project) {

    Document doc = new Document("projectId", project.getProjectId())
            .append("projectName", project.getProjectName())
            .append("members", project.getMembers());

    collection.insertOne(doc);

    System.out.println("Project stored in database");
}

public Document findProjectById(String projectId) {

    return collection.find(eq("projectId", projectId)).first();
}


}
