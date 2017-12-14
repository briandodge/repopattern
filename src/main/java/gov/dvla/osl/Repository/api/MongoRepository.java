package gov.dvla.osl.Repository.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Updates;
import gov.dvla.osl.Repository.api.domain.IEntity;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public abstract class MongoRepository <TEntity extends IEntity, TKey> extends AbstractRepository<TEntity, TKey> {

    private Class<TEntity> clazz;

    private static final String LOCALHOST = "localhost";

    private static final int DEFAULT_PORT = 27017;

    private MongoClient client = null;
    private MongoCredential credentials = null;

    private MongoDatabase database = null;
    private MongoCollection<Document> collection = null;


    public MongoRepository(){
        this(new MongoClient(LOCALHOST, DEFAULT_PORT));    // Default Instance with no credentials
    }

    private MongoRepository(MongoClient client) {
        this.client = client;
    }

    public MongoRepository(MongoClient client, MongoCredential credentials, String database, String collection, Class<TEntity> clazz){
        this(client);
        this.credentials = credentials;
        this.database = this.client.getDatabase(database);
        this.collection = getCollection(collection);
        this.clazz = clazz;
    }

    private final MongoCollection getCollection(String collection){
        if(!collectionExists(collection)){
            this.database.createCollection(collection);
        }
        return this.database.getCollection(collection);
    }

    private final boolean collectionExists(String collectionName){
        MongoIterable<String> collectionNames = this.database.listCollectionNames();
        for (final String name : collectionNames){
            if (name.equalsIgnoreCase(collectionName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<IEntity> update(IEntity entity) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(entity);

        IEntity ref = entity;

        Document document = Document.parse(json);
        Bson updateOperation = new Document("$set", document);
        String test = entity.get_id().toString();
        Bson searchCriteria = new BasicDBObject("_id", entity.get_id());

        collection.updateOne(searchCriteria, updateOperation);


        return getCollectionAsList();
    }

    @Override
    public List<IEntity> add(IEntity entity) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(entity);

        Document document = Document.parse(json);
        collection.insertOne(document);
        return getCollectionAsList();
    }


    @Override
    public List<IEntity> findAll() {
        return getCollectionAsList();
    }

    private List<IEntity> getCollectionAsList() {
        ObjectMapper mapper = new  ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MongoCursor<Document> iterator = collection.find().iterator();

        List<IEntity> entityList = new ArrayList<>();

        while (iterator.hasNext()){
            Document document = iterator.next();
            Gson gson = new GsonBuilder().create();

            String json = document.toJson();


            TEntity entity = gson.fromJson(json, clazz);
            entityList.add(entity);
        }
        return entityList;
    }



}
