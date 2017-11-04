package com.example.vika.searchmovieactor.contract;

import com.example.vika.searchmovieactor.model.Movie;

import java.util.List;

/**
 * Created by Vika on 30.10.2017.
 */

public interface Contract {
    interface View{
        void inputErrorMessage();
        String setInputString();
        void showProgressBar();
        void hideProgressBar();
        void initView();
        void setViewData(List<Movie> movies);
    }

    interface Model{

    }

    interface Presenter{
        void onClick(android.view.View view);
    }
}
