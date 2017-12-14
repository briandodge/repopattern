package gov.dvla.osl.Repository.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.bson.types.ObjectId;


import java.lang.reflect.Type;

public class ObjectIDSerializer implements JsonSerializer<ObjectId> {


    @Override
    public JsonElement serialize(ObjectId objectId, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jo = new JsonObject();
        jo.addProperty("$oid", objectId.toStringMongod());
        return jo;
    }
}
