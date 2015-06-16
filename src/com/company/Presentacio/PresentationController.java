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
    final static private String EXC_NO_PARTIDES = "noHiHaPartides";

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

    public static void prOkIniciaSessio(String user, String pwd) {
        try {
            controladorJugarPartida.ferAutenticacio(user, pwd);
            jugarPartidaFrame.mostraMenuPrincipal();
        } catch (Exception e) {
            //TODO imprimir mensaje de error
            String except = e.getMessage();
            switch (except) {
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
            }
        }
    }


    public static void prJugarMenuPrincipal(){
        jugarPartidaFrame.mostraPartida(controladorJugarPartida.crearPartida());
    }

    public static void prMenuRanking(){
        jugarPartidaFrame.mostraMenuPrincipal();
    }

    public static void prDretaJugarPartida(){
        actualitza(controladorJugarPartida.ferMoviment("dreta"));
    }

    public static void prEsquerraJugarPartida(){
        actualitza(controladorJugarPartida.ferMoviment("esq"));
    }

    public static void prAmuntJugarPartida(){
        actualitza(controladorJugarPartida.ferMoviment("amunt"));
    }

    public static void prAvallJugarPartida(){
        actualitza(controladorJugarPartida.ferMoviment("avall"));
    }


    public static void prRankingMenuPrincipal() {
        try {
            jugarPartidaFrame.mostraRanking(controladorJugarPartida.obtenirRanking());
        }catch (Exception e ){
            String except = e.getMessage();
            switch (except) {
                case EXC_NO_PARTIDES:
                    jugarPartidaFrame.mostraMissatge("No hi ha partides.");
                    break;
                default:
                    jugarPartidaFrame.mostraMissatge("Excepcio no controlada: " + e.toString());
            }
        }
    }

    public static void actualitza(ArrayList<Integer> info){
        int guanyada = info.get(0);
        int acabada = info.get(1);
        int puntuacio = info.get(2);
        if (guanyada == 1 && acabada == 1){
            jugarPartidaFrame.mostraMenuPrincipal("Has guanyat! La teva puntuació es: " + puntuacio);
        }
        else if(guanyada == 0 && acabada == 1){
            jugarPartidaFrame.mostraMenuPrincipal("Has perdut! :( ");
        }
        else{
            info.remove(0); info.remove(1);
            jugarPartidaFrame.actualitzaPuntuacio(info.get(0));
            info.remove(0);
            jugarPartidaFrame.actualitzaCaselles(info);
        }
    }

    public void DEMOranking() {
        jugarPartidaFrame.DEMORanking();
    }
}
