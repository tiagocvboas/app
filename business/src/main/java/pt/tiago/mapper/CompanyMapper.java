package pt.tiago.mapper;

import org.springframework.stereotype.Component;
import pt.tiago.dto.CompanyDto;
import pt.tiago.entity.Company;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
@Component
public class CompanyMapper implements Mapper<Company,CompanyDto> {
    public CompanyDto map(Company in) {
        return in==null?null: (CompanyDto) new CompanyDto()
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
