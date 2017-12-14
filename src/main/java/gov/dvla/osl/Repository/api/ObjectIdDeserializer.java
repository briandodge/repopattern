package gov.dvla.osl.Repository.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdDeserializer { //implements JsonDeserializer<ObjectId>{
    @Override
    public ObjectId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

//
//        jsonParser.
//
//
//        try {return new ObjectId(jsonParser.getAsJsonObject()
//                .get("$oid").getAsString()); }
//        catch (Exception e) { return null; }
    }
}
