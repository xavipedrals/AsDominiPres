package com.company.Domini.DataInterface;

import com.company.Domini.Jugador;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlJugador {
    public ArrayList<Jugador> tots();

    public Jugador getJugador(String name);

    public Jugador setJugador(String name);

}
