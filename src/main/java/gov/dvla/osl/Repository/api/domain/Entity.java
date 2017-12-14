package gov.dvla.osl.Repository.api.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;

import java.util.UUID;

public abstract class Entity implements IEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
//    private UUID id;
//
    public Entity() {    }

    public Entity(ObjectId _id) {
        this._id = _id;
    }

    @Override
    public ObjectId get_id() {
        return _id;
    }

    @Override
    public void set_id(ObjectId _id){
        this._id = _id;
    }

}
