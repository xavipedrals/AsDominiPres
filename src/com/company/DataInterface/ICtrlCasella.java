package com.company.DataInterface;

import com.company.Domini.Casella;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlCasella {
    public ArrayList<Casella> getCaselles(int idPartida);

    public Casella getCasella(int idPartida, int numFila, int numCol);

    public Casella createCasella(int id, int fila, int col, int valor);

    public void updateCasella(Casella casella);

}
