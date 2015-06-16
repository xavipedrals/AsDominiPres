package com.company.DataInterface;

import com.company.Domini.Casella;

import java.util.ArrayList;


public interface ICtrlCasella {
    public ArrayList<Casella> getCaselles(int idPartida);

    public Casella getCasella(int idPartida, int numFila, int numCol);

    public void saveCasella(Casella casella);

    public void updateCasella(Casella casella);

}
