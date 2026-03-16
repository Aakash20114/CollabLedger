package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {


private static MongoClient mongoClient;
private static MongoDatabase database;

private static final String CONNECTION_STRING = "mongodb://localhost:27017";
private static final String DATABASE_NAME = "collabledger";

public static MongoDatabase getDatabase() {

    if (database == null) {

        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);

        System.out.println("Connected to MongoDB database: " + DATABASE_NAME);
    }

    return database;
}


}
