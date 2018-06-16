package pt.tiago.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.data.entity.Owner;
import pt.tiago.business.mapper.LongMapper;
import pt.tiago.business.mapper.Mapper;
import pt.tiago.business.mapper.OwnerDtoMapper;
import pt.tiago.business.mapper.OwnerMapper;
import pt.tiago.data.repository.OwnerRepository;

import javax.transaction.Transactional;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 *
 *  Implementation of the Owner Service
 */
@Service
@Transactional
public class OwnerService extends AbstractService<OwnerDto,Long,Owner,Long> implements CrudService<OwnerDto,Long> {

    @Autowired
    private OwnerRepository ownerRepository;


    @Autowired
    private OwnerMapper ownerMapper;


    @Autowired
    private OwnerDtoMapper ownerDtoMapper;

    @Autowired
    private LongMapper pkMapper;


    @Override
    JpaRepository<Owner, Long> getRepository() {
        return ownerRepository;
    }

    @Override
    Mapper<Owner, OwnerDto> getEntityToDtoMapper() {
        return ownerMapper;
    }

    @Override
    Mapper<OwnerDto, Owner> getDtoToEntityMapper() {
        return ownerDtoMapper;
    }

    @Override
    Mapper<Long, Long> getPkToEntityPkMapper() {
        return pkMapper;
    }

    @Override
    Mapper<Long, Long> getEntityPkToPkMapper() {
        return pkMapper;
    }
}
