package com.company.Domini.UseCases;

import com.company.DataInterface.CtrlDataFactory;
import com.company.Domini.*;
import com.company.DataInterface.ICtrlJugador;
import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.EstrategiaRanking.MillorPuntuacio;
import com.company.Utility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by marcos on 13/06/2015.
 */
public class JugarPartidaUseCaseController {
    private Jugador jugadorActual;
    private Partida partidaActual;

    private int rand(int min, int max){
        return (int) (min + (Math.random()*max));
    }

    public JugarPartidaUseCaseController(){

    }

    //fa el login del jugador mirant la BD i llençant exepcions si es necessari
    public void ferAutenticacio(String userN, String passwd) throws Exception{
        ICtrlUsuariRegistrat uRegCtrl = CtrlDataFactory.getCtrlUsuariRegistrat();
        Usuariregistrat uReg = uRegCtrl.getUsuariRegistrat(userN);
        if (uReg != null) {
            if (uReg.getPassword().equals(passwd)) {
                //ICtrlJugador jugadorCtrl = CtrlDataFactory.getInstance().getCtrlJugador();
                jugadorActual = CtrlDataFactory.getInstance().getCtrlJugador().getJugador(userN);
                if (jugadorActual == null) throw new Exception("usuariNoJugador");
            } else {
                throw new Exception("pwdIncorrecte");
            }
        }
        else{
            throw new Exception("usernameNoExisteix");
        }
    }

    public InfoPartidaNova crearPartida(){
        Partida nova = new Partida();
            nova.setEstaacabada(false);
            nova.setEstaguanyada(false);
            nova.setEstrategiaRanking(new MillorPuntuacio());
            nova.setPuntuacio(0);
            nova.setIdpartida(SingletonJoc2048.getIdAndIncrement());
            nova.setJugadorByUsername(jugadorActual);

        partidaActual = nova;

        CtrlDataFactory.getInstance().getCtrlPartida().savePartida(nova);

        Casella[][] taulell = generarTaulell();
        nova.setCasellaList(taulell);
        Casella[] aux = new Casella[16];
        int i = 0;
        for (Casella[] fila : taulell){
            for (Casella c : fila){
                aux[i] = c;
                ++i;
            }
        }
        ArrayList<Casella> casellas = new ArrayList<Casella>(Arrays.asList(aux));
        for(Casella c: casellas){
            System.out.print(c.getNumerocolumna() + "\n");
        }
        nova.setCasellasByIdpartida(casellas);
        //CtrlDataFactory.getInstance().getCtrlPartida().updatePartida(nova);

        InfoPartidaNova result = new InfoPartidaNova();

        result.setPuntuacio(0);
        result.setMillorPuntuacio(jugadorActual.getMillorpuntuacio());
        result.setCaselles(nova.obteCasellesAmbNumero());

        return result;
    }

    private Casella[][] generarTaulell() { //crea la taula amb dos valors 2 o 4 a llocs aleatoris
        Casella caselles[][] = new Casella[4][4];
        int a1 = rand(1,2), b1 = rand(1,4), c1 = rand(1, 2);
        int a2 = rand(3,4), b2 = rand(1,4), c2 = rand(1,2);
        int n = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (i == a1 && j == b1) n = (c1 * 2);
                else if (i == a2 && j == b2) n = (c2 * 2);
                Casella c = new Casella();
                c.setNumerofila(i);
                c.setNumerocolumna(j);
                c.setNumero(n);
                c.setIdpartida(partidaActual.getIdpartida());
                c.setPartidaByIdpartida(partidaActual);
                HibernateHelper.save(c);

                caselles[i-1][j-1] = c;
                n = 0;
            }
        }
        return caselles;
    }

    public InfoPartida ferMoviment(String mov){ //fa el moviment corresponent i retorna la
        switch (mov) {                          //informacio necessaria a la capa de presentacio
            case "esq":
                partidaActual.mouEsquerra();
                break;
            case "dreta":
                partidaActual.mouDreta();
                break;
            case "amunt":
                partidaActual.mouAmunt();
                break;
            case "avall":
                partidaActual.mouAvall();
                break;
        }
        //HibernateHelper.updateCaselles(partidaActual.getCasellaList());
        return partidaActual.actualitza(jugadorActual);
    }

    public ArrayList<Pair> obtenirRanking() throws Exception { //obte el ranking ordenat accedint a la BD
        //Si no hi ha cap partida actual sera null, per tant per defecte retornem la estrategia de millor puntuació.
        if (partidaActual == null) return new MillorPuntuacio().obtenirRanking();
        else return partidaActual.obteEstrategiaRanking().obtenirRanking();
    }
}
