package com.example.vika.searchmovieactor.network;

import com.example.vika.searchmovieactor.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vika on 31.10.2017.
 */

public class RestClient {
    private static Retrofit getRetrofitInstance(){
        Retrofit retrofit = null;
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static MovieService getMovieApiClient(){
        MovieService movieApi= getRetrofitInstance().create(MovieService.class);
        return movieApi;
    }
}
