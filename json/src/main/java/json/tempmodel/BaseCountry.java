package json.tempmodel;

import java.util.List;

public class BaseCountry {

    private String division;
    private List<Event> events = null;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "division='" + division + '\'' +
                ", events=" + events +
                '}';
    }
}
