package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.Contribution;
import org.bson.Document;

public class ContributionRepository {


private MongoCollection<Document> collection;

public ContributionRepository() {

    MongoDatabase db = MongoDBConnection.getDatabase();
    collection = db.getCollection("contributions");
}

public void saveContribution(Contribution contribution) {

    Document doc = new Document("contributor", contribution.getContributor())
            .append("task", contribution.getTask())
            .append("timestamp", contribution.getTimestamp());

    collection.insertOne(doc);

    System.out.println("Contribution stored in database");
}


}
