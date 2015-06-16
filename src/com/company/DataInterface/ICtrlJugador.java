package com.company.DataInterface;

import com.company.Domini.Jugador;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlJugador {
    public ArrayList<Jugador> tots();

    public Jugador getJugador(String name);

//    public void createJugador(String username, String email, int millorPuntuacio);

    public void saveJugador(Jugador jugador);
}
