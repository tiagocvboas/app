package pt.tiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tiago.dao.CompanyRepository;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@Service
@Transactional
public class CompanyService implements CrudService<CompanyDto,Long> {


    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Optional<CompanyDto> read(Long id) {
        Optional<Company> byId = companyRepository.findById(id);
        return byId.map(company -> (CompanyDto) new CompanyDto().setId(company.getId()));
    }

    @Override
    public Collection<CompanyDto> list() {
        return companyRepository.findAll().stream().map(t -> (CompanyDto)new CompanyDto().setId(t.getId())).collect(Collectors.toList());
    }

    @Override
    public CompanyDto create(CompanyDto dto) {
        return null;
    }

    @Override
    public CompanyDto update(Long id, CompanyDto dto) {
        return null;
    }

    @Override
    public CompanyDto delete(Long id) {
        return null;
    }
}
