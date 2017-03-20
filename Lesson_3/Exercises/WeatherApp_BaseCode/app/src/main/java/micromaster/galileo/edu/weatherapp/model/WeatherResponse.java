package micromaster.galileo.edu.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Byron on 3/18/2017.
 */

public class WeatherResponse {

    @SerializedName("current_observation")
    private WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

}
