package com.example.vika.searchmovieactor.Contract;

import com.example.vika.searchmovieactor.Model.Movie;

import java.util.List;

/**
 * Created by Vika on 30.10.2017.
 */

public interface Contract {
    interface View{
        void inputErrorMessage();
        String setInputString();
        void showProgress();
        void initView();
        void setViewData(List<Movie> movies);
    }

    interface Model{

    }

    interface Presenter{
        void onClick(android.view.View view);
    }
}
