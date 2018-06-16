package pt.tiago.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.tiago.dto.AbstractBaseId;
import pt.tiago.dto.OwnerDto;
import pt.tiago.entity.Company;
import pt.tiago.mapper.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
abstract class AbstractService<DTO extends AbstractBaseId<DTOPK>, DTOPK,ENTITY,ENTITYPK> implements CrudService<DTO,DTOPK> {

    abstract JpaRepository<ENTITY, ENTITYPK> getRepository();


    abstract Mapper<ENTITY, DTO>  getEntityToDtoMapper();



    abstract Mapper<DTO,ENTITY >  getDtoToEntityMapper();


    abstract Mapper<DTOPK, ENTITYPK>   getPkToEntityPkMapper();


    abstract Mapper<ENTITYPK, DTOPK>   getEntityPkToPkMapper();


    @Override
    public Optional<DTO> read(DTOPK id) {

        ENTITYPK map = getPkToEntityPkMapper().map(id);

        Optional<ENTITY> byId = getRepository().findById(map);

        return byId.map(entity -> getEntityToDtoMapper().map(entity));
    }

    @Override
    public Collection<DTO> list() {

        return getRepository().findAll().stream().map(entity -> getEntityToDtoMapper().map(entity)).collect(Collectors.toList());
    }

    @Override
    public DTO create(DTO dto) {

        ENTITY entity = getDtoToEntityMapper().map(dto);

        ENTITY saved = getRepository().save(entity);

        return getEntityToDtoMapper().map(saved);
    }

    @Override
    public void update(DTOPK id, DTO dto) {
        dto.setId(id);
        this.create(dto);
    }

    @Override
    public void delete(DTOPK id) {
        Optional<DTO> entity = this.read(id);
        entity.ifPresent(t->getRepository().delete(getDtoToEntityMapper().map(entity.get())));
    }
}
