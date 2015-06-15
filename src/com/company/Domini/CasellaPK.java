package com.company.Domini;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marcos on 15/06/2015.
 */
public class CasellaPK implements Serializable {
    private int idPartida;
    private int numFila;
    private int numColumna;
    private int valor;

    /** Clau Forana **/
    private Partida p;

    @Id
    @Column(name = "idPartida")   public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Id
    @Column(name = "numFila", nullable = false)
    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }


    @Id
    @Column(name = "numColumna", nullable = false)
    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    @Basic
    @Column(name = "valor")
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPartida", insertable = false, updatable = false)
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