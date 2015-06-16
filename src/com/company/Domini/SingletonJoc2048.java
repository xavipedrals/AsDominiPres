package com.company.Domini;

import com.company.Utility.HibernateHelper;


//Classe singleton per controlar que només hi hagi una instància de Joc2048
public class SingletonJoc2048 {

    static private Joc2048 instance;

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

    //Retorna idPartida de Joc2048 i l'incrementa en 1
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
