import database.MongoDBConnection;
import com.mongodb.client.MongoDatabase;

public class TestDB {

    public static void main(String[] args) {

        MongoDatabase db = MongoDBConnection.getDatabase();
        System.out.println("Connected to DB: " + db.getName());

    }
}