package com.example.vika.searchmovieactor.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vika.searchmovieactor.contract.Contract;
import com.example.vika.searchmovieactor.model.Movie;
import com.example.vika.searchmovieactor.R;
import com.example.vika.searchmovieactor.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private EditText input_et;
    private Button search_btn;
    private Contract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainActivityPresenter(this);
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
        search_btn = (Button)findViewById(R.id.searchButton);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(view);
            }
        });


    }

    @Override
    public void setViewData(List<Movie> movies) {

    }
}
