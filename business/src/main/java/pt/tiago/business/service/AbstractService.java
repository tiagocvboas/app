package pt.tiago.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.tiago.business.dto.AbstractBaseId;
import pt.tiago.business.mapper.Mapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 *
 * Generic implementation of a CRUD service, it takes four parameters explained below
 *  It requires some methods to be implemented which will have the responsibility to feed with the mappers to transform
 *  from DTO to Entity and vice-versa and from PK to DTOPK
 *
 * @param <DTO> The dto we receive from the webservice layer that we ant to persist to the database
 * @param <DTOPK> The key of the dto we want to persist (this allows for services with String or even complex keys)
 * @param <ENTITY> The jpa Entity to persist to the database
 * @param <ENTITYPK> The key of the database table for the same reasons, it allows for embedded jpa keys, String, UUIds
 */
abstract class AbstractService<DTO extends AbstractBaseId<DTOPK>, DTOPK,ENTITY,ENTITYPK> implements CrudService<DTO,DTOPK> {

    /**
     * Method that the implementation must implement, and it returns a JpaRepository of type  Entity, EntityPK
     * It will allow us to generalize the implementation
     *
     * @return returns an implementation of JpaRepository
     */
    abstract JpaRepository<ENTITY, ENTITYPK> getRepository();

    /**
     * Mapper to convert an entity to a dto with the Type ENTITY and DTO
     * @return returns the mapper
     */
    abstract Mapper<ENTITY, DTO>  getEntityToDtoMapper();


    /**
     * Mapper to convert an dto to a entity  with the Type DTO and ENTITY
     * @return returns the mapper
     */
    abstract Mapper<DTO,ENTITY >  getDtoToEntityMapper();

    /**
     * Mapper to convert a pk to a entity pk with the Type DTOPK and ENTITYPK
     * @return returns the mapper
     */
    abstract Mapper<DTOPK, ENTITYPK>  getPkToEntityPkMapper();

    /**
     * Mapper to convert a entity pk to a dtopk  with the Type ENTITYPK and DTOPK
     * @return returns the mapper
     */
    abstract Mapper<ENTITYPK, DTOPK>   getEntityPkToPkMapper();


    @Override
    public Optional<DTO> read(DTOPK id) {

        //maps the DTOPK to an ENTITY pk we can then pass to the repository
        ENTITYPK map = getPkToEntityPkMapper().map(id);

        // find the record we want
        Optional<ENTITY> byId = getRepository().findById(map);

        // transform it from an ENTITY to a DTO
        return byId.map(entity -> getEntityToDtoMapper().map(entity));
    }

    @Override
    public Collection<DTO> list() {

        // lists all the ENTITY objects in the database and transforms them to DTO's
        return getRepository().findAll().stream().map(entity -> getEntityToDtoMapper().map(entity)).collect(Collectors.toList());
    }

    @Override
    public DTO create(DTO dto) {

        // maps the DTO to ENTITY
        ENTITY entity = getDtoToEntityMapper().map(dto);

        // persists it
        ENTITY saved = getRepository().saveAndFlush(entity);

        // returns the transformed entity inserted back to a dto to be returned
        return getEntityToDtoMapper().map(saved);
    }

    @Override
    public void update(DTOPK id, DTO dto) {
        //sets the id to override the id in the body, as I believe that the path parameter
        // should persist of the id in the body
        dto.setId(id);
        // maps the DTO to ENTITY
        ENTITY entity = getDtoToEntityMapper().map(dto);

        // persists it
        getRepository().saveAndFlush(entity);
    }

    @Override
    public void delete(DTOPK id) {
        //finds the Entity to persist
        Optional<DTO> entity = this.read(id);
        //deletes it
        entity.ifPresent(t->getRepository().delete(getDtoToEntityMapper().map(entity.get())));
    }
}
