package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class Jugador extends UsuariRegistrat{
    private String email;
    private int millorPuntuacio;

    public Jugador(){

    }

    public Jugador(String nom, String email){
        super(nom);
        this.email = email;
        this.millorPuntuacio = 0;
    }


    public int getMillorPuntuacio() {
        return millorPuntuacio;
    }

    public void setMillorPuntuacio(int millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
