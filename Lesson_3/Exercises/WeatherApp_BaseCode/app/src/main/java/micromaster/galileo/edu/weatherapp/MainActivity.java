package micromaster.galileo.edu.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import micromaster.galileo.edu.weatherapp.API.WeatherInterface;
import micromaster.galileo.edu.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final static String BASE_URL = "http://api.wunderground.com/api/";
    private final static String API_KEY = "PASTE HERE YOUR API KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*************** TODO: MOVE THIS BLOCK OF CODE TO AN ASYNC_TASK**********
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
        Call<WeatherResponse> call = weatherInterface.getWeatherFromSanFrancisco(API_KEY);
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //*************************************************************************
    }

}
