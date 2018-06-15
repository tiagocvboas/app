package pt.tiago.mapper.service;

import org.springframework.stereotype.Service;
import pt.tiago.mapper.dto.CompanyDto;
import pt.tiago.mapper.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@Service
public class CompanyService implements CrudService<CompanyDto,Long> {
    @Override
    public CompanyDto read(Long id) {
        throw  new NotFoundException();
        //return null;
    }

    @Override
    public Collection<CompanyDto> list() {
        return null;
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
