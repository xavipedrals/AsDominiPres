package com.company.Data;

import com.company.Domini.Casella;
import com.company.DataInterface.ICtrlCasella;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlCasella implements ICtrlCasella{

    private static CtrlCasella instance;
    public static CtrlCasella getInstance(){
        if (instance == null){
            instance = new CtrlCasella();
        }
        return instance;
    }

    public CtrlCasella(){

    }


    @Override
    public ArrayList<Casella> getCaselles(int idPartida) {
        return (ArrayList<Casella>) HibernateHelper.getCasellesPartida(idPartida);
    }

    @Override
    public Casella getCasella(int idPartida, int numFila, int numColumna) {
        return HibernateHelper.getCasella(idPartida, numFila, numColumna);
    }

}
