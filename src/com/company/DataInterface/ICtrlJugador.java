package com.company.DataInterface;

import com.company.Domini.Jugador;

import java.util.ArrayList;


public interface ICtrlJugador {
    public ArrayList<Jugador> tots();

    public Jugador getJugador(String name);

    public void updateJugador(Jugador jugador);
}
