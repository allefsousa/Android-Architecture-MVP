package com.developer.allef.androidmodelviewpresenter.Presenter;

import android.widget.Toast;

import com.developer.allef.androidmodelviewpresenter.Interfaces.Login;
import com.developer.allef.androidmodelviewpresenter.Model.Usuario;
import com.developer.allef.androidmodelviewpresenter.View.MainActivity;

/**
 * Created by Allef on 05/02/2017.
 */

public class PresenterLogin implements Login.Presenter{
    // objeto de View
    private  Login.View view;

    /**
     * Passando a activity no construtor
     * @param vi
     */
    public PresenterLogin(Login.View vi) {
        this.view = vi;
    }

    public void validarLogin(Usuario user){
        if(user.getSenha().isEmpty() || user.getUsuario().isEmpty()){
           // tratando erro em Branco Na View
            view.errousuarioemBranco();
        }else if(user.getUsuario().equals("Allef") && user.getSenha().equals("Allef")){
            view.loginRealizadoComSucesso();
        }else{
            view.erroaologar();
        }

    }



}
