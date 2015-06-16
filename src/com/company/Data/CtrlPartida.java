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

    //Crea una partida i la guarda a la BD
    @Override
    public Partida createPartida(int idPartida, boolean estaAcabada, boolean estaGuanyada, int puntuacio, String username) {
        Partida p = new Partida();
        p.setIdpartida(idPartida);
        p.setEstaacabada(estaAcabada);
        p.setEstaguanyada(estaGuanyada);
        p.setPuntuacio(puntuacio);
        //p.setJugadorByUsername(null);
        //p.setCasellaList(null);
        return null;
    }

    //Actualitza una instància de Partida a la BD
    @Override
    public void updatePartida(Partida partida) {
        HibernateHelper.update(partida);
    }


}
