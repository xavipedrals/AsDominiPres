package com.company.Utility;

/* InfoPartida es una classe que recull dos booleans i una llista de caselles.
*  Serveix per actualitzar una partida ja creada i permet l'acces fàcil a les dades
*  a la capa de presentació
* */
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
