package com.company.Presentacio.Views;

import javax.swing.*;
import java.awt.*;


/* JugarPartidaTemplate, es la classe de la que heredaran les altres vistes.
*  D'aquesta manera, podem definir una messageArea comuna a totes, que també es pot
*  desactivar si les vistes no en tenen.
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
        messageArea.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageArea,BorderLayout.PAGE_END);
    }


    public void hideMessage(){
        messageArea.setEnabled(false);
        messageArea.setVisible(false);
    }

    public void mostraMissatge(String msg){
        messageArea.setText(msg);
    }

}
