package com.company.Data;

import com.company.DataInterface.ICtrlJugador;
import com.company.Domini.Jugador;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

//Controlador de la classe Jugador
//No tenim funcions de crear i guardar jugador perquè el cas d'ús Jugar Partida no les inclou
public class CtrlJugador implements ICtrlJugador{

    private static CtrlJugador instance;
    public static CtrlJugador getInstance(){
        if (instance == null){
            instance = new CtrlJugador();
        }
        return instance;
    }

    public CtrlJugador(){}

    //Retorna tots els jugadors existents a la BD
    //Si no existeixen jugadors a la BD retorna una llista buida
    @Override
    public ArrayList<Jugador> tots() {
        return (ArrayList<Jugador>) HibernateHelper.getAllJugadors();
    }

    //Retorna el jugador amb l'username corresponent
    //Si no existeix a la BD retorna null
    @Override
    public Jugador getJugador(String username) {
        return HibernateHelper.getJugador(username);
    }

    //Actualitza una instància de jugador a la BD
    @Override
    public void updateJugador(Jugador jugador) {
        HibernateHelper.save(jugador);
    }
}
