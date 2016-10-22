package com.example.marsh.googlemap.retrofit;

import com.example.marsh.googlemap.Places;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by marsh on 10/22/16.
 */

public interface PlaceService {

    @GET("places")
    Call<Places> getPlaces();
}
