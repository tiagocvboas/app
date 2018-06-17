package pt.tiago.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.business.exception.NotFoundException;
import pt.tiago.business.mapper.OwnerDtoMapper;
import pt.tiago.business.mapper.OwnerMapper;
import pt.tiago.data.entity.Company;
import pt.tiago.business.mapper.LongMapper;
import pt.tiago.business.mapper.Mapper;
import pt.tiago.business.mapper.CompanyDtoMapper;
import pt.tiago.business.mapper.CompanyMapper;
import pt.tiago.data.entity.Owner;
import pt.tiago.data.repository.CompanyRepository;
import pt.tiago.data.repository.OwnerRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 *
 *  Implementation of the Company Service
 */
@Service
@Transactional
public class CompanyService extends AbstractService<CompanyDto,Long,Company,Long> implements CrudService<CompanyDto,Long> {

    @Autowired
    private CompanyRepository companyRepository;


    @Autowired
    private CompanyMapper companyMapper;


    @Autowired
    private CompanyDtoMapper companyDtoMapper;

    @Autowired
    private LongMapper pkMapper;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private OwnerDtoMapper ownerDtoMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerService ownerService;

    @Override
    JpaRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    @Override
    Mapper<Company, CompanyDto> getEntityToDtoMapper() {
        return companyMapper;
    }

    @Override
    Mapper<CompanyDto, Company> getDtoToEntityMapper() {
        return companyDtoMapper;
    }

    @Override
    Mapper<Long, Long> getPkToEntityPkMapper() {
        return pkMapper;
    }

    @Override
    Mapper<Long, Long> getEntityPkToPkMapper() {
        return pkMapper;
    }

    public Collection<OwnerDto> owners(long id) {
        Company byId = companyRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Owner> owners = byId.getOwners();
        return owners.stream().map(t->ownerMapper.map(t)).collect(Collectors.toList());
    }

    public void addOwner(Long companyId,Long ownerId){

        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        Owner ownerById = ownerRepository.findById(ownerId).orElseThrow(NotFoundException::new);

        byId.getOwners().add(ownerById);

        this.companyRepository.save(byId);

    }

    public void removeOwner(Long companyId, Long ownerId) {
        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        Owner ownerById = ownerRepository.findById(ownerId).orElseThrow(NotFoundException::new);

        byId.getOwners().remove(ownerById);

        this.companyRepository.save(byId);
    }

    public OwnerDto addNewOwner(Long companyId,OwnerDto ownerDto) {

        Owner createdOwner = ownerRepository.save(ownerDtoMapper.map(ownerDto));
        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        byId.getOwners().add(createdOwner);
        this.companyRepository.save(byId);
        return ownerMapper.map(createdOwner);
    }
}
