package com.company.Domini.UseCases;

import com.company.Domini.Partida;
import com.company.Domini.Transactions.TxFerAutenticacio;
import com.company.Domini.Transactions.TxFerMoviment;
import com.company.Domini.Transactions.TxObtenirRanking;
import com.company.Utility.Pair;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class JugarPartidaUseCaseController {

    TxFerAutenticacio autenticacio;
    TxFerMoviment moviment;
    TxObtenirRanking ranking;

    public void ferAutenticacio(String user, String pwd) throws Exception{
        autenticacio = new TxFerAutenticacio();
        autenticacio.setUserN(user);
        autenticacio.setPasswd(pwd);
        autenticacio.executar();
    }

    public Partida crearPartida(){
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
