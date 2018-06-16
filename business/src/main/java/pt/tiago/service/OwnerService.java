package pt.tiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pt.tiago.dto.OwnerDto;
import pt.tiago.entity.Owner;
import pt.tiago.mapper.LongMapper;
import pt.tiago.mapper.Mapper;
import pt.tiago.mapper.OwnerDtoMapper;
import pt.tiago.mapper.OwnerMapper;
import pt.tiago.repository.CompanyRepository;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;
import pt.tiago.repository.OwnerRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
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
