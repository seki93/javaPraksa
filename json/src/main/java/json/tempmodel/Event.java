
package json.tempmodel;

public class Event {

    private String title;
    private String date;
    private String notes;
    private Boolean bunting;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getBunting() {
        return bunting;
    }

    public void setBunting(Boolean bunting) {
        this.bunting = bunting;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", notes='" + notes + '\'' +
                ", bunting=" + bunting +
                '}';
    }
}
