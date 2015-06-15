package com.company.Presentacio;

import com.company.Domini.UseCases.JugarPartidaUseCaseController;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */

//CONTROLADOR PRESENTACION
public class PresentationController {
    final static private String EXC_USERNAME_NO_E = "usernameNoExisteix";
    final static private String EXC_PWD_INC = "pwdIncorrecte";
    final static private String EXC_USER_NO_J = "usuariNoJugador";

    private static JugarPartidaUseCaseController controladorJugarPartida;
    private static JugarPartidaFrame jugarPartidaFrame;

    /* Singleton */
    private static PresentationController instance;

    public static PresentationController getInstance(){
        if (instance == null) {
            instance = new PresentationController();
        }
        return instance;
    }

    public PresentationController(){
        controladorJugarPartida = new JugarPartidaUseCaseController();
        jugarPartidaFrame = new JugarPartidaFrame();
    }

    public void inicia(){
        jugarPartidaFrame.inicia();
    }

    public static void prOkIniciaSessio(String user, String pwd){
        jugarPartidaFrame.mostraMenuPrincipal();
/*
        try {
            //Aquí se gestiona el posible error de la db.
            //TODO DESCOMENTAR ESTO PARA QUE EL LOGIN FUNCIONE
            //controladorJugarPartida.ferAutenticacio(user,pwd);
        } catch (Exception e) {
            //TODO imprimir mensaje de error
            String except = e.getMessage();
            switch (except){
                case EXC_USERNAME_NO_E:
                    jugarPartidaFrame.mostraMissatge("No existex cap usuari amb aquest username.");
                    break;
                case EXC_PWD_INC:
                    jugarPartidaFrame.mostraMissatge("Password incorrecte.");
                    break;
                case EXC_USER_NO_J:
                    jugarPartidaFrame.mostraMissatge("Usuari no jugador.");
                    break;
                default:
                    jugarPartidaFrame.mostraMissatge("Excepcio no controlada: " + e.toString());
                    */
    }

    public static void prJugarMenuPrincipal(){
        jugarPartidaFrame.mostraPartida(controladorJugarPartida.crearPartida());
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


    public static void prRankingMenuPrincipal() {


    }

    public static void STUBRanking(){
        jugarPartidaFrame.mostraRanking(new ArrayList<>());
    }
}
