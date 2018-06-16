package pt.tiago.business.mapper;

import org.springframework.stereotype.Component;
import pt.tiago.business.dto.CompanyDto;
import pt.tiago.data.entity.Company;


/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * Company to CompanyDto mapper
 */
@Component
public class CompanyMapper implements Mapper<Company,CompanyDto> {
    public CompanyDto map(Company in) {

        return map(null,in);
    }

    @Override
    public CompanyDto map(CompanyDto out, Company in) {
        CompanyDto companyDto = out ==null?new CompanyDto():out;
        return in==null?null: (CompanyDto) companyDto
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
