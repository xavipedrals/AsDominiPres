package com.company.Domini;

import com.company.Domini.EstrategiaRanking.IEstrategiaRanking;
import com.company.Utility.CasellaList;
import com.company.Utility.CasellaScheme;
import com.company.Utility.InfoPartida;

import javax.persistence.*;
import java.util.*;

/**
 * Created by marcos on 15/06/2015.
 */
//Classe autogenerada per Hibernate a partir de la taula Partida de la BD
//Hem afegit funcions i estructures per fer els moviments de caselles de la partida
@Entity
public class Partida {
    private int idpartida;
    private Boolean estaacabada;
    private Boolean estaguanyada;
    private Integer puntuacio;
    private Collection<Casella> casellasByIdpartida;
    private Jugador jugadorByUsername;

    public Casella[][] getCasellaList() {
        return casellaList;
    }

    private Casella casellaList[][];

    private IEstrategiaRanking estrategiaRanking;

    private int rand(int min, int max){
        return (int) (min + (Math.random()*max));
    }

    public void setCasellaList(Casella casellaList[][]) {
        this.casellaList = casellaList;
    }

    @Id
    @Column(name = "idpartida", nullable = false, insertable = true, updatable = true)
    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    @Basic
    @Column(name = "estaacabada", nullable = true, insertable = true, updatable = true)
    public Boolean getEstaacabada() {
        return estaacabada;
    }

    public void setEstaacabada(Boolean estaacabada) {
        this.estaacabada = estaacabada;
    }

    @Basic
    @Column(name = "estaguanyada", nullable = true, insertable = true, updatable = true)
    public Boolean getEstaguanyada() {
        return estaguanyada;
    }

    public void setEstaguanyada(Boolean estaguanyada) {
        this.estaguanyada = estaguanyada;
    }

    @Basic
    @Column(name = "puntuacio", nullable = true, insertable = true, updatable = true)
    public Integer getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(Integer puntuacio) {
        this.puntuacio = puntuacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partida that = (Partida) o;

        if (idpartida != that.idpartida) return false;
        if (estaacabada != null ? !estaacabada.equals(that.estaacabada) : that.estaacabada != null) return false;
        if (estaguanyada != null ? !estaguanyada.equals(that.estaguanyada) : that.estaguanyada != null) return false;
        if (puntuacio != null ? !puntuacio.equals(that.puntuacio) : that.puntuacio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpartida;
        result = 31 * result + (estaacabada != null ? estaacabada.hashCode() : 0);
        result = 31 * result + (estaguanyada != null ? estaguanyada.hashCode() : 0);
        result = 31 * result + (puntuacio != null ? puntuacio.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "partidaByIdpartida")
    public Collection<Casella> getCasellasByIdpartida() {
        return casellasByIdpartida;
    }

    public void setCasellasByIdpartida(Collection<Casella> casellasByIdpartida) {
        this.casellasByIdpartida = casellasByIdpartida;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    public Jugador getJugadorByUsername() {
        return jugadorByUsername;
    }

    public void setJugadorByUsername(Jugador jugadorByUsername) {
        this.jugadorByUsername = jugadorByUsername;
    }

    public IEstrategiaRanking obteEstrategiaRanking() {
        return estrategiaRanking;
    }

    public void setEstrategiaRanking(IEstrategiaRanking estrategiaRanking) {
        this.estrategiaRanking = estrategiaRanking;
    }

    //retorna un set amb la info de les caselles amb numero
    public CasellaList obteCasellesAmbNumero() {
        CasellaList result = new CasellaList();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[i][j].getNumero() != 0) {
                    result.add(new CasellaScheme(
                            casellaList[i][j].getNumerofila(),
                            casellaList[i][j].getNumerocolumna(),
                            casellaList[i][j].getNumero()
                    ));
                }
            }
        }
        return result;
    }

    //tots els mou son semblants
    //primer agafem els valors i els tirem tots cap a la direcci� indicada (sense unir encara)
    public void mouEsquerra() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[i][j].getNumero() == 0) {
                    k = j+1;
                    while (k < 4) {
                        if (casellaList[i][k].getNumero() != 0) {
                            casellaList[i][j].setNumero(casellaList[i][k].getNumero());
                            casellaList[i][k].setNumero(0);
                            k = 4;
                        }
                        else k++;
                    }
                }
            }
        }
        //un cop acabat unim les caselles amb numeros iguals i desplacem la resta en la mateixa direccio
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (casellaList[i][j].getNumero() == casellaList[i][j+1].getNumero()) {
                    casellaList[i][j].dobleValor();
                    puntuacio += casellaList[i][j].getNumero();
                    if (casellaList[i][j].getNumero() == 2048) estaguanyada = true;
                    k = j+1;
                    while (k < 3) {
                        casellaList[i][k].setNumero(casellaList[i][k+1].getNumero());
                        k++;
                    }
                    casellaList[i][k].setNumero(0);
                }
            }
        }
    }

    public void mouDreta() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (casellaList[i][j].getNumero() == 0) {
                    k = j-1;
                    while (k > -1) {
                        if (casellaList[i][k].getNumero() != 0) {
                            casellaList[i][j].setNumero(casellaList[i][k].getNumero());
                            casellaList[i][k].setNumero(0);
                            k = -1;
                        }
                        else k--;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (casellaList[i][j].getNumero() == casellaList[i][j-1].getNumero()) {
                    casellaList[i][j].dobleValor();
                    puntuacio += casellaList[i][j].getNumero();
                    if (casellaList[i][j].getNumero() == 2048) estaguanyada = true;
                    k = j-1;
                    while (k > 0) {
                        casellaList[i][k].setNumero(casellaList[i][k-1].getNumero());
                        k--;
                    }
                    casellaList[i][k].setNumero(0);
                }
            }
        }
    }

    public void mouAmunt() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (casellaList[j][i].getNumero() == 0) {
                    k = j+1;
                    while (k < 4) {
                        if (casellaList[k][i].getNumero() != 0) {
                            casellaList[j][i].setNumero(casellaList[k][i].getNumero());
                            casellaList[k][i].setNumero(0);
                            k = 4;
                        }
                        else k++;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (casellaList[j][i].getNumero() == casellaList[j+1][i].getNumero()) {
                    casellaList[j][i].dobleValor();
                    puntuacio += casellaList[j][i].getNumero();
                    if (casellaList[j][i].getNumero() == 2048) estaguanyada = true;
                    k = j+1;
                    while (k < 3) {
                        casellaList[k][i].setNumero(casellaList[k+1][i].getNumero());
                        k++;
                    }
                    casellaList[k][i].setNumero(0);
                }
            }
        }
    }

    public void mouAvall() {
        int k;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (casellaList[j][i].getNumero() == 0) {
                    k = j-1;
                    while (k > -1) {
                        if (casellaList[k][i].getNumero() != 0) {
                            casellaList[j][i].setNumero(casellaList[k][i].getNumero());
                            casellaList[k][i].setNumero(0);
                            k = -1;
                        }
                        else k--;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (casellaList[j][i].getNumero() == casellaList[j-1][i].getNumero()) {
                    casellaList[j][i].dobleValor();
                    puntuacio += casellaList[j][i].getNumero();
                    if (casellaList[j][i].getNumero() == 2048) estaguanyada = true;
                    k = j-1;
                    while (k > 0) {
                        casellaList[k][i].setNumero(casellaList[k-1][i].getNumero());
                        k--;
                    }
                    casellaList[k][i].setNumero(0);
                }
            }
        }
    }

    public InfoPartida actualitza(Jugador jugadorActual) {
        //actualitza la info de la partida i afegeix un nou numero aleatoriament
        //si aquesta encara no ha guanyat ni acabat
        if (obteCasellesAmbNumero().size() == 2048 || estaguanyada) estaacabada = true;
        else {
            int a1, b1, c1;
            boolean insert = false;
            while (! insert) {
                a1 = rand(1,4);
                b1 = rand(1,4);
                c1 = rand(1,2);
                if (casellaList[a1-1][b1-1].getNumero() == 0) {
                    casellaList[a1-1][b1-1].setNumero(c1*2);
                    insert = true;
                }
            }

        }
        InfoPartida result = new InfoPartida();

        result.setAcabada(estaacabada);
        result.setGuanyada(estaguanyada);
        result.setPuntuacio(puntuacio);
        result.setCaselles(obteCasellesAmbNumero());

        //si el jugador supera la seva millor puntuaci� aquesta queda materialitzada
        if (estaguanyada && (jugadorActual.getMillorpuntuacio() < puntuacio))
            jugadorActual.setMillorpuntuacio(puntuacio);
        return result;
    }
}
