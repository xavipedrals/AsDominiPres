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


    public Partida crearPartida(){
        Partida nova = new Partida();
            nova.setCasellaList(generarTaulell());
            nova.setEstaAcabada(false);
            nova.setEstaGuanyada(false);
            nova.setEstrategiaRanking(new MillorPuntuacio());
            nova.setPuntuacio(0);
            nova.setIdPartida(Joc2048.getIdAndIncrement());
        nova.insert();
        partidaActual = nova;
        return nova;
    }

    private List<Casella> generarTaulell() {
        return new ArrayList<Casella>();
    }

    //Esto tiene que devolver un arraylist o algo
    public String ferMoviment(String mov, Partida p){




        return null;
    }

    public ArrayList<Pair> obtenirRanking(){




        return null;
    }

}
