package gov.dvla.osl.Repository.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.dvla.osl.Repository.api.domain.IEntity;

import java.io.IOException;
import java.util.List;

public interface IRepository <TEntity, TKey> {

    /**
     * Update the Actual System of Record (Database, file etc)
     */
    void save();

    /**
     * Update the entity in memory.
     * @param entity
     * @return entity
     */
    List<IEntity> update(IEntity entity) throws IOException;

    /**
     * Add and entity to an exisiting list
     * @param entity
     * @return collection of entities
     */
    List<IEntity> add(IEntity entity) throws IOException;

    List<TEntity> delete(TEntity entity);

    List<TEntity> find(TKey key);

    List<IEntity> findAll() throws IOException;



}
