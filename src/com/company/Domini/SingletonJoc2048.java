package com.company.Domini;

import com.company.Utility.HibernateHelper;

/**
 * Created by xavivaio on 11/06/2015.
 */
//Classe que serveix per conntrolar que Joc2048 sigui un singleton
public class SingletonJoc2048 {

    //Unica instancia de Joc2048 en el programa, per això és static
    static private Joc2048 instance;

    //Crea la instancia si no està creada
    private static void setInstance(){
        if (instance == null) {
            instance = HibernateHelper.getJoc2048();
        }
    }

    public static Joc2048 getInstance( ) {
        if (instance == null){
            setInstance();
        }
        return instance;
    }

    //Retorna l'identificador de la partida i l'incrementa en 1
    public static int getIdAndIncrement(){
        if (instance == null){
            setInstance();
        }
        int aux = instance.getIdpartida();
        HibernateHelper.emptyTable(Joc2048.class.getName());
        instance = new Joc2048();
        instance.setIdpartida(aux+1);
        HibernateHelper.save(instance);
        return aux;
    }
}
