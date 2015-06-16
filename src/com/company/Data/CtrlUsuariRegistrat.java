package com.company.Data;

import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.Usuariregistrat;
import com.company.Utility.HibernateHelper;

/**
 * Created by marcos on 13/06/2015.
 */
//Controlador de la classe UsuariRegistrat
//No tenim funcions de crear i guardar usuariRegistrat perquè el cas d'ús Jugar Partida no les inclou
public class CtrlUsuariRegistrat implements ICtrlUsuariRegistrat {
    private static CtrlUsuariRegistrat instance;
    public static CtrlUsuariRegistrat getInstance(){
        if (instance == null){
            instance = new CtrlUsuariRegistrat();
        }
        return instance;
    }

    public CtrlUsuariRegistrat(){}

    //Retorna l'usuari Registrat amb l'username corresponent
    //Si no existeix retorna null
    @Override
    public Usuariregistrat getUsuariRegistrat(String username) {
        return HibernateHelper.getUsuariRegistrat(username);
    }


    @Override
    public void updateUsuariRegistrat(Usuariregistrat usuariregistrat) {

    }
}
