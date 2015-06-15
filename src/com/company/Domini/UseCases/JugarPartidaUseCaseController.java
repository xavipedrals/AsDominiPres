package com.company.Domini.UseCases;

import com.company.DataInterface.CtrlDataFactory;
import com.company.Domini.*;
import com.company.DataInterface.ICtrlJugador;
import com.company.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.EstrategiaRanking.MillorPuntuacio;
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
        UsuariRegistrat uReg = uRegCtrl.getUsuariRegistrat(userN);
        if(uReg.getPwd().equals(passwd)){
            System.out.println("pwdCorrecte");

            ICtrlJugador jugadorCtrl = CtrlDataFactory.getInstance().getCtrlJugador();
            //jugadorActual será o bé el jugador que ha iniciat sessió o null.
            jugadorActual= jugadorCtrl.getJugador(userN);

            //TODO això es un comprovació que sobrarà, ja que a excepció ve de la bd.
            if (jugadorActual== null) throw new Exception("Usuari no jugador");
        }
        else {
            System.out.println("pwdIncorrecte");
            throw new Exception("pwdInconrrecte");
        }
    }


    public ArrayList<Integer> crearPartida(){
        Partida nova = new Partida();
            nova.setCasellaList(generarTaulell());
            nova.setEstaAcabada(false);
            nova.setEstaGuanyada(false);
            nova.setEstrategiaRanking(new MillorPuntuacio());
            nova.setPuntuacio(0);
            nova.setIdPartida(Joc2048.getIdAndIncrement());
        //nova.insert();
        partidaActual = nova;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(jugadorActual.getMillorPuntuacio());
        result.addAll(nova.getCasellesAmbNumero());
        return result;
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
                Casella c = new Casella(i, j, n, partidaActual);
                caselles[i][j] = c;
                n = 0;
            }
        }
        return caselles;
    }

    //Esto tiene que devolver un arraylist o algo
    public ArrayList<Integer> ferMoviment(String mov, Partida p){
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
        ArrayList<Integer> result = partidaActual.actualitza(jugadorActual);
        return result;
    }

    public ArrayList<Pair> obtenirRanking(){
        //Agafem la estrategia i li passem la partida per fer la consulta.
        partidaActual.getEstrategiaRanking().obtenirRanking();
        return null;
    }

}
