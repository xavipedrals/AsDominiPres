package com.company.DataInterface;

import com.company.Data.*;
import com.company.Domini.DataInterface.ICtrlJoc2048;

//Factoria de controladors
public class ICtrlDataFactory {

    private static ICtrlDataFactory instance;
    private static ICtrlCasella casella;
    private static ICtrlJugador jugador;
    private static ICtrlPartida partida;
    private static ICtrlUsuariRegistrat ureg;
    private static ICtrlJoc2048 joc2048;


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

    public static ICtrlJoc2048 getCtrlJoc2048() {
        if (joc2048 == null) {
            joc2048 = CtrlJoc2048.getInstance();
        }
        return joc2048;
    }

}
