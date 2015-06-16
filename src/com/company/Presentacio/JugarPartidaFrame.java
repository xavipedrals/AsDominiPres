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
    private final int h = 800;
    private final int w = 500;


    private static JugarPartidaTemplate panel;

    public JugarPartidaFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(xPos, yPos, h, w);
//        setResizable(false);
    }

    public void DEMORanking(){
        setTitle("Inicia sessio");
        panel = new RankingView();
        setVisible(true);
        setContentPane(panel);
    }

    public void inicia(){
        setTitle("Inicia sessio");
        panel = new LoginView();
        setVisible(true);
        setContentPane(panel);
    }

    public void mostraMenuPrincipal(){
        setTitle("Menu principal");
        canviaPanel(new MenuPrincipalView());
    }

    public void mostraMenuPrincipal(String msg){
        setTitle("Menu principal");
        canviaPanel(new MenuPrincipalView(msg));
    }

    public void mostraPartida(ArrayList<Integer> x){
        setTitle("Partida");
        canviaPanel(new PartidaView(x));
    }

    public void mostraRanking(ArrayList<Pair> e){
        setTitle("Ranking");
        canviaPanel(new RankingView());
    }

    public static void actualitzaPuntuacio(int punts){
        PartidaView p = (PartidaView)panel;
        p.actualitzaPuntuacio(punts);
    }


    public static void mostraMissatge(String txt){
        panel.mostraMissatge(txt);
    }


    public static void actualitzaCaselles(ArrayList<Integer> info){
        PartidaView p = (PartidaView) panel;
        p.actualitzaCaselles(info);
    }

    private void canviaPanel(JugarPartidaTemplate panel){
        remove(this.panel);
        this.panel = panel;
        setContentPane(this.panel);
        validate();
        repaint();
    }
}
