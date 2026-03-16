package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.User;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class UserRepository {


private MongoCollection<Document> collection;

public UserRepository() {

    MongoDatabase db = MongoDBConnection.getDatabase();
    collection = db.getCollection("users");
}

// Insert user
public void createUser(User user) {

    Document doc = new Document("username", user.getUsername())
            .append("passwordHash", user.getPasswordHash())
            .append("role", user.getRole());

    collection.insertOne(doc);

    System.out.println("User inserted successfully");
}

// Find user by username
public Document findUserByUsername(String username) {

    return collection.find(eq("username", username)).first();
}


}
