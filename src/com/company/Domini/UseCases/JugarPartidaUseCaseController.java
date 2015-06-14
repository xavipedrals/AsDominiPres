package com.company.Domini.UseCases;

import com.company.Data.CtrlDataFactory;
import com.company.Domini.DataInterface.ICtrlJugador;
import com.company.Domini.DataInterface.ICtrlPartida;
import com.company.Domini.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.Joc2048;
import com.company.Domini.Jugador;
import com.company.Domini.Partida;
import com.company.Domini.Transactions.TxFerMoviment;
import com.company.Domini.Transactions.TxObtenirRanking;
import com.company.Domini.UsuariRegistrat;
import com.company.Utility.Pair;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class JugarPartidaUseCaseController {
    private Jugador jugadorActual;

    public JugarPartidaUseCaseController(){

    }



    public void ferAutenticacio(String userN, String passwd) throws Exception{
        ICtrlUsuariRegistrat uRegCtrl = CtrlDataFactory.getCtrlUsuariRegistrat();
        UsuariRegistrat uReg = uRegCtrl.getUsuariRegistrat(userN);
        if(uReg.getPwd().equals(passwd)){
            System.out.println("pwdCorrecte");

            ICtrlJugador jugadorCtrl = CtrlDataFactory.getCtrlJugador();
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
        ICtrlPartida partidaCtrl = CtrlDataFactory.getCtrlPartida();
        partidaCtrl.setPartida(new Partida());



        return null;
    }

    //Esto tiene que devolver un arraylist o algo
    public String ferMoviment(){




        return null;
    }

    public ArrayList<Pair> obtenirRanking(){




        return null;
    }

}
