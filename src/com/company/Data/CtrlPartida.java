package com.company.Data;

import com.company.DataInterface.ICtrlPartida;
import com.company.Domini.Partida;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlPartida implements ICtrlPartida {


    private static CtrlPartida instance;
    public static CtrlPartida getInstance(){
        if (instance == null){
            instance = new CtrlPartida();
        }
        return instance;
    }

    public  CtrlPartida(){

    }

    @Override
    public Partida getPartida(int idPartida) {
        return null;
    }


}
