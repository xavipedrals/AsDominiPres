package com.company.Presentacio.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marcos on 15/06/2015.
 */
public class  JugarPartidaTemplate extends JPanel{
    protected JTextField messageArea;

    public JugarPartidaTemplate(){
        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();

        //Panell central
        add(panel, BorderLayout.CENTER);
        messageArea = new JTextField();
        messageArea.setEditable(false);
        add(messageArea,BorderLayout.PAGE_END);
    }

    //Per ocultar la vista del missatge --> Ranking
    public void hideMessage(){
        messageArea.setEnabled(false);
        messageArea.setVisible(false);
    }

    public void mostraMissatge(String msg){
        messageArea.setText(msg);
    }

}
