package com.company.Domini.UseCases;

import com.company.DataInterface.CtrlDataFactory;
import com.company.Domini.*;
import com.company.DataInterface.ICtrlJugador;
import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.EstrategiaRanking.MillorPuntuacio;
import com.company.Presentacio.PresentationController;
import com.company.Utility.Pair;

import java.util.ArrayList;
import java.util.List;

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

    public void ferAutenticacio(String userN, String passwd) throws Exception{
        ICtrlUsuariRegistrat uRegCtrl = CtrlDataFactory.getCtrlUsuariRegistrat();
        Usuariregistrat uReg = uRegCtrl.getUsuariRegistrat(userN);
        if (uReg != null) {
            if (uReg.getPassword().equals(passwd)) {
                ICtrlJugador jugadorCtrl = CtrlDataFactory.getInstance().getCtrlJugador();
                jugadorActual = jugadorCtrl.getJugador(userN);
                if (jugadorActual == null) throw new Exception("usuariNoJugador");

            } else {
                throw new Exception("pwdIncorrecte");
            }
        }
        else{
            throw new Exception("usernameNoExisteix");
        }
    }

    public Partida getPartidaActual(){
        return partidaActual;
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }


    public ArrayList<Integer> crearPartida(){
        Partida nova = new Partida();
            nova.setCasellaList(generarTaulell());
            nova.setEstaacabada(false);
            nova.setEstaguanyada(false);
            nova.setEstrategiaRanking(new MillorPuntuacio());
            nova.setPuntuacio(0);
            nova.setIdpartida(Joc2048.getIdAndIncrement());
        //nova.insert();
        partidaActual = nova;
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        result.add(0);
//        result.add(jugadorActual.getMillorpuntuacio());
//        result.addAll(nova.obteCasellesAmbNumero());
//        //
        // return result;
        //TODO QUE NO RETORNE NULL!
        return null;
    }

    private Casella[][] generarTaulell() {
        Casella caselles[][] = new Casella[4][4];
        int a1 = rand(0,1), b1 = rand(0,3), c1 = rand(1,2);
        int a2 = rand(2,3), b2 = rand(0,3), c2 = rand(1,2);
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == a1 && j == b1) n = (c1 * 2);
                else if (i == a2 && j == b2) n = (c2 * 2);
                Casella c = new Casella();
                c.setNumerofila(i);
                c.setNumerocolumna(j);
                c.setNumero(n);
                c.setPartidaByIdpartida(partidaActual);
                caselles[i][j] = c;
                n = 0;
            }
        }
        return caselles;
    }

    public ArrayList<Integer> ferMoviment(String mov){
        switch (mov) {
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
        return partidaActual.actualitza(jugadorActual);
    }

    public ArrayList<Pair> obtenirRanking(){
        //Si no hi ha cap partida actual sera null, per tant per defecte retornem la estrategia de millor puntuació.
        if (partidaActual == null ) return new MillorPuntuacio().obtenirRanking();
        else return partidaActual.obteEstrategiaRanking().obtenirRanking();
    }
}
