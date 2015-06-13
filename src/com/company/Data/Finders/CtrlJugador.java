package com.company.Data.Finders;

import com.company.Domini.DataInterface.ICtrlJugador;
import com.company.Domini.Jugador;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlJugador implements ICtrlJugador{

    //TODO COGER LA SESSION Y TRABAJAR AQUÍ. ESTO ES UN FINDER!
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

    @Override
    public Jugador setJugador(String name) {
        return null;
    }
}
