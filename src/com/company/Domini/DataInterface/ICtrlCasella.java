package com.company.Domini.DataInterface;

import com.company.Domini.Casella;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlCasella {
    public ArrayList<Casella> getCaselles(int idPartida);

    public Casella getCasella(int idPartida, int numFila, int numCol);

    public Casella setCasella(int idPartida, int numFila, int numCol);

}
