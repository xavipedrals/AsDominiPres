package com.company.Data;

import com.company.DataInterface.ICtrlCasella;
import com.company.DataInterface.ICtrlJugador;
import com.company.DataInterface.ICtrlPartida;
import com.company.DataInterface.ICtrlUsuariRegistrat;

/**
 * Created by marcos on 13/06/2015.
 */
public class CtrlDataFactory {
    private static CtrlDataFactory ctrl = new CtrlDataFactory();

    public static CtrlDataFactory getInstance() {
        return ctrl;
    }

    public static ICtrlJugador getCtrlJugador() {
        return new CtrlJugador();
    }

    public static ICtrlUsuariRegistrat getCtrlUsuariRegistrat() {
        return new CtrlUsuariRegistrat();
    }

    public static ICtrlPartida getCtrlPartida() {
        return new CtrlPartida();
    }

    public static ICtrlCasella getCtrlCasella() {
        return new CtrlCasella();
    }

    public static CtrlJoc2048 getCtrlJoc2048() {
        return new CtrlJoc2048();
    }
}
