
package json.mapper;


import com.fasterxml.jackson.annotation.JsonGetter;
import json.tempmodel.EnglandAndWales;
import json.tempmodel.NorthernIreland;
import json.tempmodel.Scotland;

public class Json2CountriesMapper {

    private EnglandAndWales englandAndWales;
    private Scotland scotland;
    private NorthernIreland northernIreland;

    @JsonGetter("england-and-wales")
    public EnglandAndWales getEnglandAndWales() {
        return englandAndWales;
    }

    public void setEnglandAndWales(EnglandAndWales englandAndWales) {
        this.englandAndWales = englandAndWales;
    }

    public Scotland getScotland() {
        return scotland;
    }

    public void setScotland(Scotland scotland) {
        this.scotland = scotland;
    }

    @JsonGetter("northern-ireland")
    public NorthernIreland getNorthernIreland() {
        return northernIreland;
    }

    public void setNorthernIreland(NorthernIreland northernIreland) {
        this.northernIreland = northernIreland;
    }

    @Override
    public String toString() {
        return "Json2CountriesMapper{" +
                "englandAndWales=" + englandAndWales +
                ", scotland=" + scotland +
                ", northernIreland=" + northernIreland +
                '}';
    }
}
