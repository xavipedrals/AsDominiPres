package com.company.Presentacio;

import com.company.Domini.UseCases.JugarPartidaUseCaseController;

/**
 * Created by marcos on 13/06/2015.
 */

//CONTROLADOR PRESENTACION
public class PresentationController {


    private static JugarPartidaUseCaseController jp;

    private static JugarPartidaView jpv;

    //TODO FUNCIONS RELACIONADES AMB EVENTS QUE SERAN CRIDATS DESDE LA VISTA

    public static void prOkIniciaSessio(String user, String pwd){
        try {
            //Aquí se gestiona el posible error de la db.
            jp.ferAutenticacio(user,pwd);
        } catch (Exception e) {
            //TODO imprimir mensaje de error
            e.printStackTrace();
        }

    }

    public static void prJugarMenuPrincipal(){

    }

    public static void prMenuRanking(){

    }

    public static void prDretaJugarPartida(){

    }

    public static void prEsquerraJugarPartida(){

    }

    public static void prAmuntJugarPartida(){

    }

    public static void prAvallJugarPartida(){

    }

    public static void actualitza(){
            //TODO PARAMETROS DE ESTA LLAMADA???
    }




}
