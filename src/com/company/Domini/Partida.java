package com.company.Domini;

import com.company.Domini.EstrategiaRanking.IEstrategiaRanking;
import com.company.Utility.DbSession;

import java.util.List;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Partida {
    private int idPartida;
    private boolean estaAcabada;
    private boolean estaGuanyada;
    private int puntuacio;

    private IEstrategiaRanking estrategiaRanking;

    private List<Casella> casellaList;


    public Partida(){
    
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public boolean isEstaAcabada() {
        return estaAcabada;
    }

    public void setEstaAcabada(boolean estaAcabada) {
        this.estaAcabada = estaAcabada;
    }

    public boolean isEstaGuanyada() {
        return estaGuanyada;
    }

    public void setEstaGuanyada(boolean estaGuanyada) {
        this.estaGuanyada = estaGuanyada;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public List<Casella> getCasellaList() {
        return casellaList;
    }

    public void setCasellaList(List<Casella> casellaList) {
        this.casellaList = casellaList;
    }

    public IEstrategiaRanking getEstrategiaRanking() {
        return estrategiaRanking;
    }
    
    public void setEstrategiaRanking(IEstrategiaRanking estrategiaRanking) {
        this.estrategiaRanking = estrategiaRanking;
    }

    public void update(){

    }
    public void insert(){

    }

    public void remove(){

    }
}
