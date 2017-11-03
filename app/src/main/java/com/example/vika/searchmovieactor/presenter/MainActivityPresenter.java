package com.example.vika.searchmovieactor.presenter;

import android.util.Log;
import android.view.View;

import com.example.vika.searchmovieactor.contract.Contract;
import com.example.vika.searchmovieactor.model.Movie;
import com.example.vika.searchmovieactor.model.MovieResult;
import com.example.vika.searchmovieactor.network.RestClient;
import com.example.vika.searchmovieactor.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vika on 30.10.2017.
 */

public class MainActivityPresenter implements Contract.Presenter {
    private static final String LOG = "MainActivityPresenter";

    private final Contract.View mView;
    private  Contract.Model mModel;

    public MainActivityPresenter(Contract.View view) {
       Log.d(LOG, "MainActivityPresenter constructor ");
        this.mView = view;
        initPresenter();

    }

    private void initPresenter() {
        // mModel = new ResultMovieModel();
        mView.initView();
    }



    private void loadMovieData() {
        String queryMovie = mView.setInputString();
        if(queryMovie.isEmpty() || queryMovie == null){
            mView.inputErrorMessage();
        } else {
            Call<MovieResult> call = RestClient.getMovieApiClient().getTopRatedMovies(Constants.HTTP.API_KEY, queryMovie);
                call.enqueue(new Callback<MovieResult>() {
                    @Override
                    public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                        Log.d(LOG, "onResponse " + response.isSuccessful());
                        List<Movie> listMovie = response.body().getResults();
                        mView.setViewData(listMovie);
                    }

                    @Override
                    public void onFailure(Call<MovieResult> call, Throwable t) {
                        Log.d(LOG, "onFailure " + t.getMessage());
                    }
                });
        }
    }


    @Override
    public void onClick(View view) {
        loadMovieData();
    }
}
