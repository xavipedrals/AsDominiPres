package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Joc2048 {
    static private int idActual = 0;


    /**Implementacio de possible singleton**/
    private static Joc2048 joc2048 = new Joc2048();
    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private Joc2048(){ }
    /* Static 'instance' method */
    public static Joc2048 getInstance( ) {
        return joc2048;
    }

    /**Fi**/

    public static int getIdActual(){
        return idActual;
    }

    public static int getIdAndIncrement(){
        int id = idActual;
        ++idActual;
        return id;
    }
}
