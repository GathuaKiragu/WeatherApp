package com.example.kiragu.weatherapp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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

//    public ArrayList<Restaurant> processResults(Response response) {
//        ArrayList<Restaurant> restaurants = new ArrayList<>();
//
//        try {
//            String jsonData = response.body().string();
//            if (response.isSuccessful()) {
//                JSONObject yelpJSON = new JSONObject(jsonData);
//                JSONArray businessesJSON = yelpJSON.getJSONArray("businesses");
//                for (int i = 0; i < businessesJSON.length(); i++) {
//                    JSONObject restaurantJSON = businessesJSON.getJSONObject(i);
//                    String name = restaurantJSON.getString("name");
//                    String phone = restaurantJSON.optString("display_phone", "Phone not available");
//                    String website = restaurantJSON.getString("url");
//                    double rating = restaurantJSON.getDouble("rating");
//                    String imageUrl = restaurantJSON.getString("image_url");
//                    double latitude = restaurantJSON.getJSONObject("location")
//                            .getJSONObject("coordinate").getDouble("latitude");
//                    double longitude = restaurantJSON.getJSONObject("location")
//                            .getJSONObject("coordinate").getDouble("longitude");
//                    ArrayList<String> address = new ArrayList<>();
//                    JSONArray addressJSON = restaurantJSON.getJSONObject("location")
//                            .getJSONArray("display_address");
//                    for (int y = 0; y < addressJSON.length(); y++) {
//                        address.add(addressJSON.get(y).toString());
//                    }
//
//                    ArrayList<String> categories = new ArrayList<>();
//                    JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");
//
//                    for (int y = 0; y < categoriesJSON.length(); y++) {
//                        categories.add(categoriesJSON.getJSONArray(y).get(0).toString());
//                    }
//                    Restaurant restaurant = new Restaurant(name, phone, website, rating,
//                            imageUrl, address, latitude, longitude, categories);
//                    restaurants.add(restaurant);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return restaurants;
//    }
}