package com.company.DataInterface;

import com.company.Domini.Jugador;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlJugador {
    public ArrayList<Jugador> getAll();

    public Jugador getJugador(String name);

    public void saveJugador(Jugador jugador);
}
