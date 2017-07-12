package com.example.kiragu.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by kiragu on 5/31/17.
 */

public class WeatherService {
    public static void findWeatherInfo(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.MY_WEATHER_API);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weathers = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject openWeatherJSON = new JSONObject(jsonData);

                JSONObject coordinates = openWeatherJSON.getJSONObject("sys");
                JSONObject place = openWeatherJSON.getJSONObject("coord");
                double longitude = coordinates.getDouble("lon");
                double latitude = coordinates.getDouble("lat");
                String name = place.getString("name");

                ArrayList<String> description = new ArrayList<>();
                JSONArray descriptionJSON = openWeatherJSON.getJSONArray("weather");
                for (int y = 0; y < descriptionJSON.length(); y++) {
                    description.add(descriptionJSON.getJSONObject(y).getString("description").toString());
                }
                Weather weather = new Weather(name, longitude, latitude, description);
                weathers.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}