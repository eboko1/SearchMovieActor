package com.example.vika.searchmovieactor.presenter;

import android.util.Log;
import android.view.View;

import com.example.vika.searchmovieactor.contract.Contract;

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
    }


    @Override
    public void onClick(View view) {
        loadMovieData();
    }
}
