package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Joc2048 {
    static private int idProximaPartida = 0;
    static private Partida partidaActual;
    static private Jugador jugadorActual;


    private static void increment(){
        ++idProximaPartida;
    }

    public static Partida getPartidaActual(){
        return  partidaActual;
    }

    public static void assignaJugador(Jugador j){
        jugadorActual = j;
    }

    public static Jugador getJugadorActual() {
        return jugadorActual;
    }


    public static void setIdProximaPartida(int id) {
        idProximaPartida = id;
    }

    public static int setPartidaActual(Partida p) {
        partidaActual = p;
        int idPartidaActual = idProximaPartida;
            increment();
        return idPartidaActual;
    }
}
