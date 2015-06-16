package com.company.DataInterface;

import com.company.Domini.Casella;

import java.util.ArrayList;


public interface ICtrlCasella {
    public ArrayList<Casella> getCaselles(int idPartida);

    public Casella getCasella(int idPartida, int numFila, int numCol);

    public Casella createCasella(int id, int fila, int col, int valor);

    public void updateCasella(Casella casella);

}
