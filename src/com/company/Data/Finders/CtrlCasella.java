package com.company.Data.Finders;

import com.company.Domini.Casella;
import com.company.Domini.DataInterface.ICtrlCasella;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlCasella implements ICtrlCasella{

    //TODO ESTO ES EL FINDER DE CASELLA

    public CtrlCasella(){

    }

    @Override
    public ArrayList<Casella> getCaselles(int idPartida) {
        return null;
    }

    @Override
    public Casella getCasella(int idPartida, int numFila, int numCol) {
        return null;
    }

    @Override
    public Casella setCasella(int idPartida, int numFila, int numCol) {
        return null;
    }
}
