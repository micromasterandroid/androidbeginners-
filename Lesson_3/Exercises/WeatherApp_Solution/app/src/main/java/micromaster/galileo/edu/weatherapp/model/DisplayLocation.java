package micromaster.galileo.edu.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Byron on 3/19/2017.
 */

public class DisplayLocation {
    @SerializedName("city")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
