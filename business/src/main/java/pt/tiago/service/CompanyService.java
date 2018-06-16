package pt.tiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;
import pt.tiago.mapper.LongMapper;
import pt.tiago.mapper.Mapper;
import pt.tiago.mapper.CompanyDtoMapper;
import pt.tiago.mapper.CompanyMapper;
import pt.tiago.repository.CompanyRepository;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;
import pt.tiago.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

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
