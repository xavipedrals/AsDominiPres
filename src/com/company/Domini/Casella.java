package com.company.Domini;

import javax.persistence.*;

/**
 * Created by xavivaio on 11/06/2015.
 */

//@Entity
//@IdClass(CasellaPK.class)
public class Casella {
    private int idPartida;
    private int numFila;
    private int numColumna;
    private int valor;

    /** Clau Forana **/
    private Partida p;


    public Casella(int numFila, int numColumna, int valor, Partida p){
        this.numFila = numFila;
        this.numColumna = numColumna;
        this.valor = valor;
        this.p = p;
    }

    public Casella() {
    }

//    @Id
//    @Column(name = "idpartida")
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

//    @Id
//    @Column(name = "numerofila", nullable = false)
    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }

//
//    @Id
//    @Column(name = "numerocolumna", nullable = false)
    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

//    @Basic
//    @Column(name = "valor")
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idpartida", insertable = false, updatable = false)
    public Partida getP() {
        return p;
    }

    public void setP(Partida p) {
        this.p = p;
    }

    public void dobleValor() {
        valor *= 2;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Casella casella = (Casella) o;
//
//        if (idpartida != casella.idpartida) return false;
//        if (numerofila != casella.numerofila) return false;
//        if (numerocolumna != casella.numerocolumna) return false;
//        if (numero != null ? !numero.equals(casella.numero) : casella.numero != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idpartida;
//        result = 31 * result + numerofila;
//        result = 31 * result + numerocolumna;
//        result = 31 * result + (numero != null ? numero.hashCode() : 0);
//        return result;
//    }
}
