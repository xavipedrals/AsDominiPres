package com.company.Domini.Transactions;

import com.company.Domini.Partida;

/**
 * Created by marcos on 13/06/2015.
 */
public class TxFerMoviment extends Transaction {
    private String tipusMov;
    private Partida p;

    public TxFerMoviment(){
    }

    public TxFerMoviment(String mov, Partida p){
        this.tipusMov = mov;
        this.p = p;
    }

    public void setTipusMov(String mov){
        this.tipusMov = mov;
    }

    public void setP(Partida p){
        this.p = p;
    }

    @Override
    public void executar() {
        //TODO EXECUTAR
    }
}
