package gov.dvla.osl.Repository.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import gov.dvla.osl.Repository.api.domain.Driver;
import gov.dvla.osl.Repository.api.domain.IEntity;

import java.util.List;

public class MyRepo extends MongoRepository<Driver, String> {


    public MyRepo(){
        super(new MongoClient(), null, "hohum", "TestCollection", Driver.class);
    }


    @Override
    public void save() {

    }

    @Override
    public List<IEntity> update(IEntity driver) throws JsonProcessingException {
        return super.update(driver);
    }

    @Override
    public List<IEntity> add(IEntity driver) throws JsonProcessingException {
        return super.add(driver);
    }

    @Override
    public List<Driver> delete(Driver driver) {
        return null;
    }

    @Override
    public List<Driver> find(String s) {
        return null;
    }

    @Override
    public List<IEntity> findAll() {
        return super.findAll();
    }
}
