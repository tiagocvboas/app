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
        return in==null?null: new Owner()
                .setName(in.getName())
                .setTitle(in.getTitle())
                .setId(in.getId())
                ;
    }
}
