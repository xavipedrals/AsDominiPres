package com.company.Presentacio.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marcos on 15/06/2015.
 */
public class JugarPartidaTemplate extends JPanel{
    protected JTextField messageArea;

    public JugarPartidaTemplate(){
        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();

        //Panell central
        add(panel, BorderLayout.CENTER);

        add(messageArea,BorderLayout.PAGE_END);

    }

}
