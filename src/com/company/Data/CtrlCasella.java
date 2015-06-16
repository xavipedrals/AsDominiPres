package com.company.Data;

import com.company.Domini.Casella;
import com.company.DataInterface.ICtrlCasella;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
//Controlador de la classe Casella
public class CtrlCasella implements ICtrlCasella{

    private static CtrlCasella instance;
    public static CtrlCasella getInstance(){
        if (instance == null){
            instance = new CtrlCasella();
        }
        return instance;
    }

    public CtrlCasella(){}

    //Retorna totes les caselles amb el corresponent idPartida,
    //Si no existeixen retorna una llista buida
    @Override
    public ArrayList<Casella> getCaselles(int idPartida) {
        return (ArrayList<Casella>) HibernateHelper.getCasellesPartida(idPartida);
    }

    //Retorna la casella amb idPartida, numFila i numColumna corresponent,
    //Si no existeix retorna null
    @Override
    public Casella getCasella(int idPartida, int numFila, int numColumna) {
        return HibernateHelper.getCasella(idPartida, numFila, numColumna);
    }

    //Crea una casella i la guarda a la BD
    @Override
    public Casella createCasella(int id, int fila, int col, int valor) {
        //TODO: Implementa aixo
        return null;
    }

    //Actualitza una instancia de Casella a la BD
    @Override
    public void updateCasella(Casella casella) {
        HibernateHelper.update(casella);
    }

}
