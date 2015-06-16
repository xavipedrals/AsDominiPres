package com.company.Data;

import com.company.DataInterface.ICtrlPartida;
import com.company.Domini.Partida;
import com.company.Utility.HibernateHelper;

/**
 * Created by marcos on 13/06/2015.
 */
//Controlador de la classe Partida
public class CtrlPartida implements ICtrlPartida {

    private static CtrlPartida instance;
    public static CtrlPartida getInstance(){
        if (instance == null){
            instance = new CtrlPartida();
        }
        return instance;
    }

    public CtrlPartida(){}

    //Retorna la partida amb el corresponent idPartida
    //Si no existeix retorna null
    @Override
    public Partida getPartida(int idPartida) {
        return HibernateHelper.getPartida(idPartida);
    }

    //guarda una instància de partida a la BD
    @Override
    public void savePartida(Partida partida) {
        HibernateHelper.save(partida);
    }

    //Actualitza una instància de Partida a la BD
    @Override
    public void updatePartida(Partida partida) {
        HibernateHelper.update(partida);
    }


}
