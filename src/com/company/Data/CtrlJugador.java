package com.company.Data;

import com.company.DataInterface.ICtrlJugador;
import com.company.Domini.Jugador;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlJugador implements ICtrlJugador{

    private static CtrlJugador instance;
    public static CtrlJugador getInstance(){
        if (instance == null){
            instance = new CtrlJugador();
        }
        return instance;
    }


    public CtrlJugador(){
    }

    @Override
    public ArrayList<Jugador> tots() {
        return (ArrayList<Jugador>) HibernateHelper.getAllJugadors();
    }

    @Override
    public Jugador getJugador(String username) {
        return HibernateHelper.getJugador(username);
    }

    @Override
    public void saveJugador(Jugador jugador) {
        HibernateHelper.save(jugador);
    }


//    @Override
//    public void createJugador(String username, String email, int millorPuntuacio) {
//
//    }



}
