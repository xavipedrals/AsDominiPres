package com.company.Data;

import com.company.DataInterface.ICtrlJugador;
import com.company.Domini.Jugador;

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
        return null;
    }

    @Override
    public Jugador getJugador(String name) {
        //TODO SI NO EXISTE, LO CREO
        //Jugador jugadorDB = (Jugador) session.get(Jugador.CLASS,name) ejemplo llamada a DB ????
        return new Jugador();
    }
}