package com.example.vika.searchmovieactor.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vika.searchmovieactor.Contract.Contract;
import com.example.vika.searchmovieactor.Model.Movie;
import com.example.vika.searchmovieactor.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void inputErrorMessage() {

    }

    @Override
    public String setInputString() {
        return null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void setViewData(List<Movie> movies) {

    }
}
