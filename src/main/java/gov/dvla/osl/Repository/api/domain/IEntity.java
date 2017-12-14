package gov.dvla.osl.Repository.api.domain;

import org.bson.types.ObjectId;

import java.util.UUID;

public interface IEntity {

    ObjectId get_id();

    void set_id(ObjectId _id);
}
