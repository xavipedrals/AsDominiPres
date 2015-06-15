package com.company.Domini;

import com.company.Domini.EstrategiaRanking.IEstrategiaRanking;
//import com.company.Utility.DbSession;

import java.util.ArrayList;
import java.util.Collection;
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

    private Casella casellaList[][];


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

    public Casella[][] getCasellaList() {
        return casellaList;
    }

    public void setCasellaList(Casella casellaList[][]) {
        this.casellaList = casellaList;
    }

    public IEstrategiaRanking getEstrategiaRanking() {
        return estrategiaRanking;
    }



    public void setEstrategiaRanking(IEstrategiaRanking estrategiaRanking) {
        this.estrategiaRanking = estrategiaRanking;
    }

    public ArrayList<Integer> getCasellesAmbNumero() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[i][j].getValor() != 0) {
                    result.add(casellaList[i][j].getNumFila());
                    result.add(casellaList[i][j].getNumColumna());
                    result.add(casellaList[i][j].getValor());
                }
            }
        }
        return result;
    }

    public void mouEsquerra() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[i][j].getValor() == 0) {
                    k = j+1;
                    while (k < 4) {
                        if (casellaList[i][k].getValor() != 0) {
                            casellaList[i][j].setValor(casellaList[i][k].getValor());
                            casellaList[i][k].setValor(0);
                            k = 4;
                        }
                        else k++;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (casellaList[i][j].getValor() == casellaList[i][j+1].getValor()) {
                    casellaList[i][j].dobleValor();
                    k = j+1;
                    while (k < 3) {
                        casellaList[i][k].setValor(casellaList[i][k+1].getValor());
                        k++;
                    }
                    casellaList[i][k].setValor(0);
                }
            }
        }
    }

    public void mouDreta() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (casellaList[i][j].getValor() == 0) {
                    k = j-1;
                    while (k > -1) {
                        if (casellaList[i][k].getValor() != 0) {
                            casellaList[i][j].setValor(casellaList[i][k].getValor());
                            casellaList[i][k].setValor(0);
                            k = -1;
                        }
                        else k--;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (casellaList[i][j].getValor() == casellaList[i][j-1].getValor()) {
                    casellaList[i][j].dobleValor();
                    k = j-1;
                    while (k > 0) {
                        casellaList[i][k].setValor(casellaList[i][k-1].getValor());
                        k--;
                    }
                    casellaList[i][k].setValor(0);
                }
            }
        }
    }

    public void mouAmunt() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[j][i].getValor() == 0) {
                    k = j+1;
                    while (k < 4) {
                        if (casellaList[k][i].getValor() != 0) {
                            casellaList[j][i].setValor(casellaList[k][i].getValor());
                            casellaList[k][i].setValor(0);
                            k = 4;
                        }
                        else k++;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (casellaList[j][i].getValor() == casellaList[j+1][i].getValor()) {
                    casellaList[j][i].dobleValor();
                    k = j+1;
                    while (k < 3) {
                        casellaList[k][i].setValor(casellaList[k+1][i].getValor());
                        k++;
                    }
                    casellaList[k][i].setValor(0);
                }
            }
        }
    }

    public void mouAvall() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (casellaList[j][i].getValor() == 0) {
                    k = j-1;
                    while (k > -1) {
                        if (casellaList[k][i].getValor() != 0) {
                            casellaList[j][i].setValor(casellaList[k][i].getValor());
                            casellaList[k][i].setValor(0);
                            k = -1;
                        }
                        else k--;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (casellaList[j][i].getValor() == casellaList[j-1][i].getValor()) {
                    casellaList[j][i].dobleValor();
                    k = j-1;
                    while (k > 0) {
                        casellaList[k][i].setValor(casellaList[k-1][i].getValor());
                        k--;
                    }
                    casellaList[k][i].setValor(0);
                }
            }
        }
    }

    public ArrayList<Integer> actualitza(Jugador jugadorActual) {
        return null;
    }
}
