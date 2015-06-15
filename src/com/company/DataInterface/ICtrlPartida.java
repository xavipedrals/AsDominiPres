package com.company.DataInterface;

import com.company.Domini.Partida;

/**
 * Created by marcos on 13/06/2015.
 */
public interface ICtrlPartida {
    public Partida getPartida(int idPartida);

    public Partida createPartida(int idPartida, boolean estaAcabada, boolean estaGuanyada, int puntuacio, String username);

    public void savePartida(Partida partida);
}
