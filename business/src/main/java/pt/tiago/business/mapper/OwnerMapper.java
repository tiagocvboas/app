package pt.tiago.business.mapper;

import org.springframework.stereotype.Component;
import pt.tiago.business.dto.OwnerDto;
import pt.tiago.data.entity.Owner;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
@Component
public class OwnerMapper implements Mapper<Owner,OwnerDto> {
    public OwnerDto map(Owner in) {
        return in==null?null: (OwnerDto) new OwnerDto()
                .setName(in.getName())
                .setTitle(in.getTitle())
                .setId(in.getId())
                ;
    }
}
