package json.mapper;

import javax.annotation.Generated;
import json.entities.Country;
import json.entities.NonWorkingDay;
import json.tempmodel.BaseCountry;
import json.tempmodel.Event;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-05-24T13:39:10+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class DTOMapperImpl implements DTOMapper {

    @Override
    public Country baseCountryToCountry(BaseCountry baseCountry) {
        if ( baseCountry == null ) {
            return null;
        }

        Country country = new Country();

        country.setName( baseCountry.getDivision() );

        return country;
    }

    @Override
    public NonWorkingDay eventToNonWorkingDay(Event event) {
        if ( event == null ) {
            return null;
        }

        NonWorkingDay nonWorkingDay = new NonWorkingDay();

        return nonWorkingDay;
    }
}
