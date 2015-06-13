package com.company.Domini.Transactions;

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
    public void executar() {
        //TODO FER AUTENTICACIO
    }
}
