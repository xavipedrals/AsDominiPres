package com.company.Presentacio.Views;

import com.company.Presentacio.PresentationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marcos on 15/06/2015.
 */
public class LoginView extends JugarPartidaTemplate{

    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JPasswordField textField2;

    public LoginView(){
        //User
        textArea1.setText("Usuari");
        textArea1.setEditable(false);
        textArea1.setOpaque(false);

        textField1.setText("");

        //Password
        textArea2.setText("Contrassenya");
        textArea2.setEditable(false);
        textArea2.setOpaque(false);

        textField2.setText("");
        textField2.setAlignmentX(CENTER_ALIGNMENT);
        textField2.setAlignmentY(CENTER_ALIGNMENT);

        button1.setText("Inicia sessio");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PresentationController.getInstance().prOkIniciaSessio(textField1.getText(),new String(textField2.getPassword()));
            }
        });

        add(panel1);
    }
}
