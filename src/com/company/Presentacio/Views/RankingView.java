package com.company.Presentacio.Views;

import com.company.Utility.Pair;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by marcos on 16/06/2015.
 */
public class RankingView extends JugarPartidaTemplate{


    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JButton menuButton;
    private ArrayList<Pair> result;

    private void insereixDades() {
        ArrayList<Pair> r = new ArrayList<Pair>();
        for (int i = 0; i < 5; ++i) {
            Pair p = new Pair("Usuari"+i, i*35000);
            result.add(p);
        }
    }

    public RankingView(){
        insereixDades();
        DefaultListModel listModel1 = new DefaultListModel();
        DefaultListModel listModel2 = new DefaultListModel();
        list1 = new JList(listModel1);
        list2 = new JList(listModel2);
        for (Pair p : result) {
            listModel1.addElement(p.user);
            listModel2.addElement(p.puntuacio);
        }

        add(panel1);
    }
}
