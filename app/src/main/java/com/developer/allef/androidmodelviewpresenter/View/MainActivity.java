package com.developer.allef.androidmodelviewpresenter.View;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.allef.androidmodelviewpresenter.Interfaces.Login;
import com.developer.allef.androidmodelviewpresenter.Model.Usuario;
import com.developer.allef.androidmodelviewpresenter.Presenter.PresenterLogin;
import com.developer.allef.androidmodelviewpresenter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements Login.View{

    //region ButterKnif Inicialize Methods
    @BindView(R.id.txtlogin)
    EditText login;
    @BindView(R.id.txtsenha)
    EditText senha;
    @BindView(R.id.btnlogar)
    Button logar;
    private PresenterLogin pre;
    @BindView(R.id.labellogin)
    TextInputLayout logininput;
    @BindView(R.id.labesenha)
    TextInputLayout senhainput;
    //endregion







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pre = new PresenterLogin(this);



    }
    // Evento de click com ButterKnife
    @OnClick(R.id.btnlogar)
    void loginclicado(View view){
        Usuario usuario = new Usuario();
        usuario.setUsuario(login.getText().toString());
        usuario.setSenha(senha.getText().toString());
        pre.validarLogin(usuario);


    }

    public void errousuarioemBranco() {
        logininput.setErrorEnabled(true);
        logininput.setError("Usuario em Branco !!");
        senhainput.setErrorEnabled(true);
        senhainput.setError("Senha Em Branco");
    }

    public void loginRealizadoComSucesso() {
        startActivity(new Intent(MainActivity.this,FirstActivity.class));
        finish();
    }

    public void erroaologar() {
        Toast.makeText(MainActivity.this,"Erro Inesperado ao logar usuario",Toast.LENGTH_LONG).show();
    }
}
