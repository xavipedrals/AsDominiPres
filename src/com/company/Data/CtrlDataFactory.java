package com.company.Data;

import com.company.Data.Finders.CtrlCasella;
import com.company.Data.Finders.CtrlJugador;
import com.company.Data.Finders.CtrlPartida;
import com.company.Data.Finders.CtrlUsuariRegistrat;
import com.company.Domini.DataInterface.ICtrlCasella;
import com.company.Domini.DataInterface.ICtrlJugador;
import com.company.Domini.DataInterface.ICtrlPartida;
import com.company.Domini.DataInterface.ICtrlUsuariRegistrat;

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

}
