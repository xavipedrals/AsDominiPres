package com.company.Presentacio;


import com.company.Presentacio.Views.*;
import com.company.Utility.Pair;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by marcos on 13/06/2015.
 */
public class JugarPartidaFrame extends JFrame{

    private final int xPos = 0;
    private final int yPos = 0;
    private final int h = 500;
    private final int w = 800;


    private JugarPartidaTemplate panel;

    public JugarPartidaFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(xPos, yPos, h, w);
        panel = new LoginView();
        setSize(300, 200);
        setContentPane(panel);
    }



    public void mostraMenuPrincipal(){
        canviaPanel(new ViewMenuPrincipal());

    }

    public void mostraMenuPrincipal(String msg){
        canviaPanel(new ViewMenuPrincipal());

    }

    public void mostraPartida(String ESTODEBERIASERINFOPARTIDA){
        canviaPanel(new ViewPartida());

    }

    public void mostraRanking(ArrayList<Pair> e){
        canviaPanel(new ViewRanking());
    }

    public static void actualitzaPuntuacio(int Punts){
    }


    public static void mostraMissatge(String txt){

    }
    public static void actualitzaCaselles(ArrayList<String> ESTOHADESERUNARRAYLISTDE3COSAS){

    }

    private void canviaPanel(JugarPartidaTemplate panel){
        remove(this.panel);
        this.panel = panel;
        setContentPane(this.panel);
        validate();
        repaint();
    }
    //TODO EN EL ESQUEMA MOSTRA RANKIGN ESTA REPE
}
