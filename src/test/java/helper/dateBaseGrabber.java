package helper;

import com.mongodb.*;

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

public class dateBaseGrabber {

    MongoClientURI address = new MongoClientURI("mongodb://54.88.178.46:27020");
    public String getSecretAnswerFor(String email) throws Exception {
        try(MongoClient mc = new MongoClient(address)) {

         MongoDatabase db = mc.getDatabase("classwallet");
           MongoCollection<Document> collection = db.getCollection("users");
            Document document = collection
                    .find(new BasicDBObject("profile.email", "email"))
                    .projection(Projections.fields(Projections.include("security.answer"), Projections.excludeId())).first();
            return document.get("anwser").toString();
           //DBObject query = new BasicDBObject(new Document("profile.email", email));
           //MongoCursor<Document> cursor = collection.find().iterator();
       }catch(Exception ex) {
            ex.printStackTrace();
       }finally{mc.close();}
}
}
