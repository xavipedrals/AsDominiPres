package com.company.Domini.Transactions;

import com.company.Data.CtrlDataFactory;
import com.company.Domini.DataInterface.ICtrlJugador;
import com.company.Domini.DataInterface.ICtrlUsuariRegistrat;
import com.company.Domini.Joc2048;
import com.company.Domini.Jugador;
import com.company.Domini.UsuariRegistrat;

/**
 * Created by marcos on 13/06/2015.
 */
public class TxFerAutenticacio extends Transaction {
    private String userN;
    private String passwd;


    public TxFerAutenticacio(){

    }

    public TxFerAutenticacio(String user, String password){
        this.userN = user;
        this.passwd = password;
    }

    public void setUserN(String user){
        this.userN = user;
    }

    public void setPasswd(String pwd){
        this.passwd = pwd;
    }

    @Override
    public void executar() throws Exception {
        //TODO EXCEPCIONES EN BD

        ICtrlUsuariRegistrat uRegCtrl = CtrlDataFactory.getCtrlUsuariRegistrat();
        UsuariRegistrat uReg = uRegCtrl.getUsuariRegistrat(userN);

        if(uReg.getPwd().equals(passwd)){
            //System.out.println("pwdCorrecte");
            //Als diagrames de seqüència teniem ficat que es comprovava el mail de usuari registrat,
            //Pero usuari registrat no té mail, només el jugador així que, comprovem en jugador.
            //Ara comprovem si existeix el jugador pel nom que també es PK

            ICtrlJugador jugadorCtrl = CtrlDataFactory.getCtrlJugador();

            Jugador jugador = jugadorCtrl.getJugador(userN);
            if (jugador == null) throw new Exception("Usuari no jugador");
            else {
                //Aquest es el jugador que ha fet login
                Joc2048.assignaJugador(jugador);
            }
        }
        else {
            System.out.println("pwdIncorrecte");
           throw new Exception("pwdInconrrecte");
        }
    }


}
