package com.company.Utility;

/**
 * Created by marcos on 16/06/2015.
 */
public class InfoPartidaNova {
    private int millorPuntuacio;
    private Integer puntuacio;

    CasellaList caselles;

    public int getMillorPuntuacio() {
        return millorPuntuacio;
    }

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    public Integer getPuntuacio() {
        return puntuacio;
    }

    public InfoPartidaNova(){
        millorPuntuacio = 0;
        puntuacio = 0;
        caselles = new CasellaList();

    }

    public void addCasella(CasellaScheme c){
        caselles.add(c);
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
