package com.example.vika.searchmovieactor.network;

import com.example.vika.searchmovieactor.model.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vika on 31.10.2017.
 */

public interface MovieService {
    @GET("3/search/movie")
    Call<MovieResult> getTopRatedMovies(@Query("api_key") String api_key, @Query("query") String queryMovie);

}
