package com.company.Data;

import com.company.DataInterface.ICtrlJugador;
import com.company.Domini.Jugador;
import com.company.Utility.HibernateHelper;

import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
//Controlador de la classe Jugador
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

    //Guarda un Jugador a la BD
    @Override
    public void saveJugador(Jugador jugador) {
        HibernateHelper.save(jugador);
    }
}
