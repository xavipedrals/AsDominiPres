package com.company.Presentacio;

import com.company.Domini.UseCases.JugarPartidaUseCaseController;
import com.company.Utility.InfoPartida;

public class PresentationController {
    /*
    * El controlador de presentació s'encarrega de rebre els events que reben de les diferents vistes
    * indicar al controlador de cas dús que ha de fer i actualitza la informació relacionada.
    *
    * Cal destacar que a diferencia del disseny original que vam fer,
    * ha estat necessari definir les vistes per a cada pantalla per tal
    * de que el codi fos mantenible i fàcil de llegir.
     */

    //Strings per a codificar les excepcions
    final static private String EXC_USERNAME_NO_E = "usernameNoExisteix";
    final static private String EXC_PWD_INC = "pwdIncorrecte";
    final static private String EXC_USER_NO_J = "usuariNoJugador";
    final static private String EXC_NO_PARTIDES = "noHiHaPartides";

    //Controladors
    private static JugarPartidaUseCaseController controladorJugarPartida;
    private static JugarPartidaFrame jugarPartidaFrame;

    // Singleton
    private static PresentationController instance;

    public static PresentationController getInstance(){
        if (instance == null) {
            instance = new PresentationController();
        }
        return instance;
    }

    //Inicialització del controlador de cas d'us
    // i de la jugarPartidaFrame, classe contenidora de les diferents vistes
    public PresentationController(){
        controladorJugarPartida = new JugarPartidaUseCaseController();
        jugarPartidaFrame = new JugarPartidaFrame();
    }

    public void inicia(){
        jugarPartidaFrame.inicia();
    }


    //Aquestes funcions indiquen el comportament quan es rep un event de qualsevol vista.
    //Son cridades per les vistes en concret, definit ActionListeners als botons.
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

    public static void actualitza(InfoPartida info){
        boolean guanyada = info.isGuanyada();
        boolean acabada = info.isAcabada();
        int puntuacio = info.getPuntuacio();

        if (guanyada && acabada){
            jugarPartidaFrame.mostraMenuPrincipal("Has guanyat! La teva puntuació es: " + puntuacio);
        }
        else if(!guanyada && acabada){
            jugarPartidaFrame.mostraMenuPrincipal("Has perdut! :( ");
        }
        else{
            jugarPartidaFrame.actualitzaPuntuacio(puntuacio);
            jugarPartidaFrame.actualitzaCaselles(info.getCaselles());
        }
    }

}
