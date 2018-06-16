package pt.tiago.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.data.entity.Company;
import pt.tiago.business.mapper.LongMapper;
import pt.tiago.business.mapper.Mapper;
import pt.tiago.business.mapper.CompanyDtoMapper;
import pt.tiago.business.mapper.CompanyMapper;
import pt.tiago.data.repository.CompanyRepository;

import javax.transaction.Transactional;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@Service
@Transactional
public class CompanyService extends AbstractService<CompanyDto,Long,Company,Long> implements CrudService<CompanyDto,Long> {

    @Autowired
    private CompanyRepository CompanyRepository;


    @Autowired
    private CompanyMapper CompanyMapper;


    @Autowired
    private CompanyDtoMapper CompanyDtoMapper;

    @Autowired
    private LongMapper pkMapper;


    @Override
    JpaRepository<Company, Long> getRepository() {
        return CompanyRepository;
    }

    @Override
    Mapper<Company, CompanyDto> getEntityToDtoMapper() {
        return CompanyMapper;
    }

    @Override
    Mapper<CompanyDto, Company> getDtoToEntityMapper() {
        return CompanyDtoMapper;
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
