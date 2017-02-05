package com.developer.allef.androidmodelviewpresenter.Interfaces;

import com.developer.allef.androidmodelviewpresenter.Model.Usuario;

/**
 * Created by Allef on 05/02/2017.
 * Interface para ser implementado os metodos no presentar
 * sem ter conehcimento se é um fragment ou uma activity
 *
 *
 *
 */

public interface Login {
    interface View{
        void errousuarioemBranco();
        void loginRealizadoComSucesso();
        void erroaologar();

    }
    interface Presenter{
        void validarLogin(Usuario user);
    }
}
