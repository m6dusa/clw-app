package helper;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import java.util.HashMap;
import java.util.Map;

public class DBHelper {
    private MongoClientURI address = new MongoClientURI("mongodb://54.88.178.46:27020");
    public Map<String, String> getQA(String email) {
            MongoClient mc = new MongoClient(address);
            MongoDatabase db = mc.getDatabase("classwallet");
            MongoCollection<Document> collection = db.getCollection("users");
            Document document = collection
                    .find(new BasicDBObject("profile.email", email))
                    .projection(Projections.fields(Projections.include("security"), Projections.excludeId())).first();
            Document security = (Document) document.get("security");
            String question = security.getString("question");
            String answer = security.getString("answer");
            System.out.println("User " +email + "\n" + "question is " + question + "\n" + "answer is "+ answer);
            mc.close();
            HashMap<String, String> map = new HashMap<>();
            map.put("question", question);
            map.put("answer", answer);

            return map;
        }
    }
