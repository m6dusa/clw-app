package helper;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class dateBaseGrabber {
    MongoClientURI address = new MongoClientURI("mongodb://54.88.178.46:27020");
//    public String getSecretAnswerFor(String email) throws Exception {
//        try {
//            MongoClient mc = new MongoClient(address);
//            MongoDatabase db = mc.getDatabase("classwallet");
//            MongoCollection<Document> collection = db.getCollection("users");
//            DBObject query = new BasicDBObject(new Document"profile.email", email);
//            FindIterable<Document> cursor = collection.find((Bson) query);
//        }catch(Exception ex) {
//            throw new Exception();
//        }finally{}
//    }
}
