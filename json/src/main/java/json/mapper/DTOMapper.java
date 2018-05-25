package json.mapper;

import json.entities.Country;
import json.entities.NonWorkingDay;
import json.tempmodel.BaseCountry;
import json.tempmodel.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Mapper(componentModel = "spring")
@Component
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

        String string = event.getDate();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        nonWorkingDay.setNonWorkDate(date);
        nonWorkingDay.setDescription(event.getTitle());

        return nonWorkingDay;
    }

}
