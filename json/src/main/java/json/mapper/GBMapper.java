package json.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.entities.Country;
import json.entities.NonWorkingCalendar;
import json.entities.NonWorkingDay;
import json.tempmodel.BaseCountry;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GBMapper extends NonWorkingCalendarMapper {

    private static OkHttpClient client = new OkHttpClient();
    private static ObjectMapper jacksonMapper = new ObjectMapper();

//    public static void main(String[] args) {
//        List<NonWorkingCalendar> calendars = getAllNonWorkingCalendars();
//        System.out.println(calendars);
//    }

    public static List<NonWorkingCalendar> getAllNonWorkingCalendars(){
        List<NonWorkingCalendar> listOfallCountries = null;
        try {
            String json = getJSON(GB_NON_WORKING_DAYS_URL);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
            LocalDateTime now = LocalDateTime.now();
            String currentYear = dtf.format(now);

            listOfallCountries = new ArrayList<>();

            Json2CountriesMapper json2CountriesMapper = jacksonMapper.readValue(json, Json2CountriesMapper.class);

            listOfallCountries.add(getCountryEvents(json2CountriesMapper.getEnglandAndWales(), currentYear));
            listOfallCountries.add(getCountryEvents(json2CountriesMapper.getScotland(), currentYear));
            listOfallCountries.add(getCountryEvents(json2CountriesMapper.getNorthernIreland(), currentYear));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfallCountries;
    }

    public static NonWorkingCalendar getCountryEvents(BaseCountry baseCountry, String currentYear){
        NonWorkingCalendar nonWorkingCalendar = new NonWorkingCalendar();
        List<NonWorkingDay> nonWorkingDays = new ArrayList<>();

        for(int i = 0; i < baseCountry.getEvents().size(); i++){
            NonWorkingDay nonWorkingDay = DTOMapper.mapper.mapEventTONonWorkingDay(baseCountry.getEvents().get(i));

            if(compareDates(nonWorkingDay.getNonWorkDate(), currentYear)) nonWorkingDays.add(nonWorkingDay);
        }

        Country country = DTOMapper.mapper.baseCountryToCountry(baseCountry);

        nonWorkingCalendar.setNonWorkingDays(nonWorkingDays);
        nonWorkingCalendar.setCountry(country);

        return nonWorkingCalendar;
    }


    public static String getJSON(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return  response.body().string();
    }

    public static  boolean compareDates(Date date1, String d2){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date2 = sdf.parse(d2);

            if(date1.after(date2)) return true;
            else if(date1.before(date2)) return false;
            else return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
