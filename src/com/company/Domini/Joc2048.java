package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Joc2048 {

    static private Joc2048 instance;
    static private int idActual = 0;

    /* Static 'instance' method */
    public static Joc2048 getInstance( ) {
        if (instance == null){
            instance = new Joc2048(){};
        }
        return instance;
    }

    public static int getIdActual(){
        return idActual;
    }

    public static int getIdAndIncrement(){
        int id = idActual;
        ++idActual;
        return id;
    }
}
