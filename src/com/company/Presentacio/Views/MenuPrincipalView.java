package com.company.Presentacio.Views;

import com.company.Presentacio.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marcos on 15/06/2015.
 */
public class MenuPrincipalView extends JugarPartidaTemplate{
    private JButton button1;
    private JPanel panel1;
    private JButton button2;
    private JTextArea textArea1;


    //TODO LISTENERS

    public MenuPrincipalView(){
        //implementacio dels botons jugar i ranking del menu
        button1.setText("Jugar");
        button2.setText("Ranking");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jugar
                PresentationController.getInstance().prJugarMenuPrincipal();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.getInstance().prRankingMenuPrincipal();
            }
        });

        add(panel1);
    }

    public MenuPrincipalView(String msg){
        //definicio dels botons i crides a les funcions
        button1.setText("Jugar");
        button2.setText("Ranking");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("IMPLEMENTAME");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("IMPLEMENTAME");
            }
        });

              mostraMissatge(msg);
        add(panel1);
    }
}
