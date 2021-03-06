package pt.tiago.business.mapper;

import org.springframework.stereotype.Component;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.data.entity.Company;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * CompanyDto to Company mapper
 */
@Component
public class CompanyDtoMapper implements Mapper<CompanyDto,Company> {
    @Override
    public Company map(CompanyDto in) {
        return map(null,in);
    }

    @Override
    public Company map(Company out, CompanyDto in) {
        Company company = out==null?new Company():out;
        return in==null?null: company
                .setName(in.getName())
                .setAddress(in.getAddress())
                .setCity(in.getCity())
                .setCountry(in.getCountry())
                .setEmail(in.getEmail())
                .setPhoneNumber(in.getPhoneNumber())
                .setId(in.getId())
                ;
    }
}
