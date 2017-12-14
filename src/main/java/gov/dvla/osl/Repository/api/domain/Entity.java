package gov.dvla.osl.Repository.api.domain;


import org.bson.types.ObjectId;

public abstract class Entity implements IEntity {


    private ObjectId _id;

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
