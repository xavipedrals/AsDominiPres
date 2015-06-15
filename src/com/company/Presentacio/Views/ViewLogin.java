package com.company.Presentacio.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marcos on 15/06/2015.
 */
public class ViewLogin extends JugarPartidaTemplate {
    JTextArea userText;
    JTextField username;
    JTextArea passText;
    JTextField password;
    JButton login;


    public ViewLogin(){

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        userText = new JTextArea();
        username = new JTextField();
        passText = new JTextArea();
        password = new JTextField();
        login = new JButton();

        userText.setText("Usuari");

        passText.setText("Password");

        login.setText("Inicia sessio");

        add(userText);
        add(username);
        add(passText);
        add(password);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login pressed");
            }
        });

        add(login);
    }








}
