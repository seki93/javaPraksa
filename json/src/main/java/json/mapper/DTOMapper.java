package json.mapper;

import json.entities.Country;
import json.entities.NonWorkingDay;
import json.tempmodel.BaseCountry;
import json.tempmodel.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    DTOMapper mapper = Mappers.getMapper(DTOMapper.class);

    @Mapping(source = "division", target = "name")
    Country baseCountryToCountry(BaseCountry baseCountry);

    NonWorkingDay eventToNonWorkingDay(Event event);

    default NonWorkingDay mapEventTONonWorkingDay(Event event){

        if(event == null){
            return null;
        }

        final NonWorkingDay nonWorkingDay = eventToNonWorkingDay(event);
        //nonWorkingDay.setNonWorkDate(event.getDate());
        nonWorkingDay.setDescription(event.getTitle());

        return nonWorkingDay;
    }

}
