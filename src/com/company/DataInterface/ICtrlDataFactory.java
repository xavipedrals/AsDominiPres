package com.company.DataInterface;

import com.company.Data.CtrlCasella;
import com.company.Data.CtrlJugador;
import com.company.Data.CtrlPartida;
import com.company.Data.CtrlUsuariRegistrat;

//Factoria de controladors
public class ICtrlDataFactory {

    private static ICtrlDataFactory instance;
    private static ICtrlCasella casella;
    private static ICtrlJugador jugador;
    private static ICtrlPartida partida;
    private static ICtrlUsuariRegistrat ureg;


    public static ICtrlDataFactory getInstance() {
        if(instance == null){
            instance = new ICtrlDataFactory(){};
        }
        return instance;
    }

    public static ICtrlCasella getCtrlCasella() {
        if (casella == null){
            casella = CtrlCasella.getInstance();
        }
        return casella;
    }

    public static ICtrlUsuariRegistrat getCtrlUsuariRegistrat() {
        if (ureg == null){
            ureg = CtrlUsuariRegistrat.getInstance();
        }
        return ureg;
    }

    public static ICtrlPartida getCtrlPartida() {
        if (partida == null) {
            partida = CtrlPartida.getInstance();
        }
        return partida;
    }

    public static ICtrlJugador getCtrlJugador() {
        if (jugador == null) {
            jugador = CtrlJugador.getInstance();
        }
        return jugador;
    }

}
