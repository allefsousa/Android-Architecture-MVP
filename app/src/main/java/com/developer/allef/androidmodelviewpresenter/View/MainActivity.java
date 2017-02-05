package com.developer.allef.androidmodelviewpresenter.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.developer.allef.androidmodelviewpresenter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtlogin)
    EditText login;
    @BindView(R.id.txtsenha)
    EditText senha;
    @BindView(R.id.btnlogar)
    Button logar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
    // Evento de click com ButterKnife
    @OnClick(R.id.btnlogar)
    void loginclicado(View view){

    }
}
