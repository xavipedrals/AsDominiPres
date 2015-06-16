package com.company.Data;

import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.Usuariregistrat;
import com.company.Utility.HibernateHelper;

/**
 * Created by marcos on 13/06/2015.
 */

public class CtrlUsuariRegistrat implements ICtrlUsuariRegistrat {
    private static CtrlUsuariRegistrat instance;
    public static CtrlUsuariRegistrat getInstance(){
        if (instance == null){
            instance = new CtrlUsuariRegistrat();
        }
        return instance;
    }

    public CtrlUsuariRegistrat(){

    }


    @Override
    public Usuariregistrat getUsuariRegistrat(String username) {
        return HibernateHelper.getUsuariRegistrat(username);
    }

    @Override
    public void createUsuariRegistrat(String nom, String cognom, String username, String password) {
        //TODO SOBRA�?
    }

    @Override
    public void saveUsuariRegistrat(Usuariregistrat usuariregistrat) {

    }
}
