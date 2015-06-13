package com.company.Domini.Transactions;

import com.company.Data.Finders.CtrlPartida;
import com.company.Domini.DataInterface.ICtrlPartida;
import com.company.Domini.EstrategiaRanking.MillorPuntuacio;
import com.company.Domini.Joc2048;
import com.company.Domini.Jugador;
import com.company.Domini.Partida;
import com.company.Utility.DbSession;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class TxCrearPartida extends Transaction {
    final int INIT_PUNT = 0;

    @Override
    public void executar() throws Exception {
        Jugador x = Joc2048.getJugadorActual();

        /*
            Al crear una partida hacemos:
            1 - Cogemos el jugador actual
            2 -
            3 -
            4 -
            5 -
            6 -
            7 -

         */

        DbSession.session.beginTransaction();
        Partida p = new Partida();
                p.setIdPartida(Joc2048.setPartidaActual(p));
                p.setPuntuacio(INIT_PUNT);
                p.setEstaAcabada(false);
                p.setEstaGuanyada(false);
                p.setEstrategiaRanking(new MillorPuntuacio());
                p.setCasellaList(new ArrayList<>());
        DbSession.session.save();
        DbSession.session.endTransaction();

        //Ya hemos creado la partida,




    }
}
