package com.company.Domini;

import com.company.Utility.HibernateHelper;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class SingletonJoc2048 {

    static private Joc2048 instance;
    //static private int idActual = 0;

    /* Static 'instance' method */
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

    public static int getIdAndIncrement(){
        if (instance == null){
            setInstance();
        }
        int aux = instance.getIdpartida();
        //System.out.print("aux " + aux + "\n");
        HibernateHelper.emptyTable(Joc2048.class.getName());
        instance = new Joc2048();
        instance.setIdpartida(aux+1);
        HibernateHelper.save(instance);
        return aux;
    }
}
