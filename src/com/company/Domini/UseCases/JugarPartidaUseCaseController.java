package com.company.Domini.UseCases;

import com.company.DataInterface.ICtrlDataFactory;
import com.company.Domini.*;
import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.EstrategiaRanking.MillorPuntuacio;
import com.company.Utility.*;
import com.company.Services.ServiceLayer;
import java.util.ArrayList;


public class JugarPartidaUseCaseController {
    private Jugador jugadorActual;
    private Partida partidaActual;

    private int rand(int min, int max){
        return (int) (min + (Math.random()*max));
    }

    public JugarPartidaUseCaseController(){

    }

    //fa el login del jugador mirant la BD i llen�ant exepcions si es necessari
    public void ferAutenticacio(String userN, String passwd) throws Exception{
        ICtrlUsuariRegistrat uRegCtrl = ICtrlDataFactory.getCtrlUsuariRegistrat();
        Usuariregistrat uReg = uRegCtrl.getUsuariRegistrat(userN);
        if (uReg != null) {
            if (uReg.getPassword().equals(passwd)) {
                jugadorActual = ICtrlDataFactory.getInstance().getCtrlJugador().getJugador(userN);
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

        ICtrlDataFactory.getInstance().getCtrlPartida().savePartida(nova);

        nova.setCasellaList(generarTaulell());

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
                ICtrlDataFactory.getInstance().getCtrlCasella().saveCasella(c);

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
        InfoPartida act = partidaActual.actualitza(jugadorActual);
        if (partidaActual.getEstaguanyada()) {
            //el jugador haguanyat aixi que enviem un mail
            ServiceLayer.getInstance().enviaMail(jugadorActual.getEmail(), partidaActual.getPuntuacio());
        }
        return act;
    }

    public ArrayList<Pair> obtenirRanking() throws Exception { //obte el ranking ordenat accedint a la BD
        //Si no hi ha cap partida actual sera null, per tant per defecte retornem la estrategia de millor puntuaci�.
        if (partidaActual == null) return new MillorPuntuacio().obtenirRanking();
        else return partidaActual.obteEstrategiaRanking().obtenirRanking();
    }
}
