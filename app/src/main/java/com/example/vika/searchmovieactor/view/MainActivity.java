package com.example.vika.searchmovieactor.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vika.searchmovieactor.adapter.MovieAdapter;
import com.example.vika.searchmovieactor.contract.Contract;
import com.example.vika.searchmovieactor.model.Movie;
import com.example.vika.searchmovieactor.R;
import com.example.vika.searchmovieactor.presenter.MainActivityPresenter;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private EditText input_et;
    private FloatingActionButton search_btn;
    private Contract.Presenter mPresenter;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainActivityPresenter(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycleView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        
        if(mPresenter == null) {
            mPresenter = new MainActivityPresenter(this);
        }
    }

    @Override
    public void inputErrorMessage() {
        Toast.makeText(getApplicationContext(),R.string.error_message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String setInputString() {
        return input_et.getText().toString();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void initView() {
        input_et = (EditText)findViewById(R.id.inputEditText);
        search_btn = (FloatingActionButton) findViewById(R.id.searchButton);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(view);
            }
        });


    }

    @Override
    public void setViewData(List<Movie> movies) {
        movieAdapter = new MovieAdapter(getApplicationContext(), movies,R.layout.item_movie);
        recyclerView.setAdapter(movieAdapter);
    }

}
