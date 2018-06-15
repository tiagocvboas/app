package pt.tiago.service;

import org.springframework.stereotype.Service;
import pt.tiago.dto.CompanyDto;
import pt.tiago.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@Service
public class CompanyService implements CrudService<CompanyDto,Long> {


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
        return companyDtos;
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
