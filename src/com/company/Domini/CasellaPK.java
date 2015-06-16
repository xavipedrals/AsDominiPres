package com.company.Domini;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by marcos on 15/06/2015.
 */
//Classe autogenerada per Hibernate, serveix per buscar caselles per clau primària a la BD
public class CasellaPK implements Serializable {
    private int idpartida;
    private int numerofila;
    private int numerocolumna;

    @Column(name = "idpartida", nullable = false, insertable = true, updatable = true)
    @Id
    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    @Column(name = "numerofila", nullable = false, insertable = true, updatable = true)
    @Id
    public int getNumerofila() {
        return numerofila;
    }

    public void setNumerofila(int numerofila) {
        this.numerofila = numerofila;
    }

    @Column(name = "numerocolumna", nullable = false, insertable = true, updatable = true)
    @Id
    public int getNumerocolumna() {
        return numerocolumna;
    }

    public void setNumerocolumna(int numerocolumna) {
        this.numerocolumna = numerocolumna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasellaPK that = (CasellaPK) o;

        if (idpartida != that.idpartida) return false;
        if (numerofila != that.numerofila) return false;
        if (numerocolumna != that.numerocolumna) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpartida;
        result = 31 * result + numerofila;
        result = 31 * result + numerocolumna;
        return result;
    }
}
