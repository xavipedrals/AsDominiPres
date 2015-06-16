package com.company.DataInterface;

import com.company.Domini.Partida;


public interface ICtrlPartida {
    public Partida getPartida(int idPartida);

    public void savePartida(Partida partida);

    public void updatePartida(Partida partida);
}
