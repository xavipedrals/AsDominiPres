package com.company.Utility;

import com.company.Domini.Casella;

import java.util.ArrayList;

/**
 * Created by marcos on 16/06/2015.
 */
public class InfoPartida {
    boolean guanyada;
    boolean acabada;
    CasellaList caselles;
    private Integer puntuacio;

    public Integer getPuntuacio() {
        return puntuacio;
    }

    public InfoPartida(){
        guanyada = false;
        acabada =false;
        caselles = new CasellaList();
    }

    public void addCasella(CasellaScheme c){
        caselles.add(c);
    }

    public boolean isGuanyada() {
        return guanyada;
    }

    public void setGuanyada(boolean guanyada) {
        this.guanyada = guanyada;
    }

    public boolean isAcabada() {
        return acabada;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }

    public CasellaList getCaselles() {
        return caselles;
    }

    public void setCaselles(CasellaList caselles) {
        this.caselles = caselles;
    }

    public void setPuntuacio(Integer puntuacio) {
        this.puntuacio = puntuacio;
    }
}
