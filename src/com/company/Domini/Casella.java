package com.company.Domini;

import javax.persistence.*;

/**
 * Created by marcos on 15/06/2015.
 */
@Entity
@IdClass(CasellaPK.class)
public class Casella {
    private int idpartida;
    private int numerofila;
    private int numerocolumna;
    private Integer numero;

    private Partida partidaByIdpartida;

    @Id
    @Column(name = "idpartida", nullable = false, insertable = true, updatable = true)
    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    @Id
    @Column(name = "numerofila", nullable = false, insertable = true, updatable = true)
    public int getNumerofila() {
        return numerofila;
    }

    public void setNumerofila(int numerofila) {
        this.numerofila = numerofila;
    }

    @Id
    @Column(name = "numerocolumna", nullable = false, insertable = true, updatable = true)
    public int getNumerocolumna() {
        return numerocolumna;
    }

    public void setNumerocolumna(int numerocolumna) {
        this.numerocolumna = numerocolumna;
    }

    @Basic
    @Column(name = "numero", nullable = true, insertable = true, updatable = true)
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void dobleValor() {
        this.numero *= 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casella that = (Casella) o;

        if (idpartida != that.idpartida) return false;
        if (numerofila != that.numerofila) return false;
        if (numerocolumna != that.numerocolumna) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpartida;
        result = 31 * result + numerofila;
        result = 31 * result + numerocolumna;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idpartida", referencedColumnName = "idpartida", nullable = false)
    public Partida getPartidaByIdpartida() {
        return partidaByIdpartida;
    }

    public void setPartidaByIdpartida(Partida partidaByIdpartida) {
        this.partidaByIdpartida = partidaByIdpartida;
    }


}
