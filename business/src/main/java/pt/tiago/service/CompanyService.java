package pt.tiago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.tiago.dao.CompanyRepository;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;
import pt.tiago.exception.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
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
    public CompanyDto read(Long id) {
        return (CompanyDto) new CompanyDto().setName("primeiro").setId(1L);
    }

    @Override
    public Collection<CompanyDto> list() {
        ArrayList<CompanyDto> companyDtos = new ArrayList<>();
        companyDtos.add((CompanyDto) new CompanyDto().setName("primeiro").setId(1L));
        companyDtos.add((CompanyDto) new CompanyDto().setName("segundo").setId(2L));
        companyDtos.add((CompanyDto) new CompanyDto().setName("terceiro").setId(3L));
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
