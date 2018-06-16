package pt.tiago.business.mapper;

import org.springframework.stereotype.Component;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.data.entity.Owner;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * OwnerDto to Owner mapper
 */
@Component
public class OwnerDtoMapper implements Mapper<OwnerDto,Owner> {
    public Owner map(OwnerDto in) {
        return map(null,in);
    }

    @Override
    public Owner map(Owner out, OwnerDto in) {
        Owner owner =out==null? new Owner():out;
        return in==null?null: owner
                .setName(in.getName())
                .setTitle(in.getTitle())
                .setId(in.getId())
                ;
    }
}
