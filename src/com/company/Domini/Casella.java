package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Casella {
    private int idPartida;

    private int numFila;
    private int numColumna;
    private int valor;

    private Partida p;


    public Casella(int numFila, int numColumna, int valor, Partida p){
        this.numFila = numFila;
        this.numColumna = numColumna;
        this.valor = valor;
        this.p = p;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }

    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Partida getP() {
        return p;
    }

    public void setP(Partida p) {
        this.p = p;
    }

    public void dobleValor() {
        valor *= 2;
    }
}
