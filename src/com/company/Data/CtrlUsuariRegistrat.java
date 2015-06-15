package com.company.Data;

import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.UsuariRegistrat;

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
    public UsuariRegistrat getUsuariRegistrat(String usern) {
        return null;
    }
}
