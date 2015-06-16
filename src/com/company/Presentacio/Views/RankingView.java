package com.company.Presentacio.Views;

import com.company.Domini.Jugador;
import com.company.Presentacio.PresentationController;
import com.company.Utility.HibernateHelper;
import com.company.Utility.Pair;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by marcos on 16/06/2015.
 */
public class RankingView extends JugarPartidaTemplate{


    private JPanel panel1;
    private JButton menuButton;
    private JTable table1;
    private JTable table2;
    private String list1Data[];
    private String list2Data[];
    private ArrayList<Pair> res;

    //TODO passar per parametre
    private void insereixDades() {
        //consulta a la BD i agafa el ranking ja ordenat
        ArrayList<Jugador> result = (ArrayList<Jugador>)HibernateHelper.getRankingmillorsPuntuacions();
        res = new ArrayList<Pair>();
        for (Jugador j : result) {
            Pair p = new Pair(j.getUsername(), j.getMillorpuntuacio());
            res.add(p);
        }
        //posa la info a les files
        list1Data = new String[result.size()];
        list2Data = new String[result.size()];
        int i = 0;
        for (Pair p : res) {
            list1Data[i] = p.getUser();
            list2Data[i] = String.valueOf(p.getPuntuacio());
            i++;
        }
    }

    public RankingView(){
        //ompla les taules amb la info corresponent i les posa no editables
        //tambe defineix el boto menu per retornar
        insereixDades();
        table1.setModel(new myUsuariModel());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table2.setModel(new myPuntuacioModel());
        table2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.prMenuRanking();
            }
        });
        hideMessage();

        table1.setRowHeight(30);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setColumnSelectionAllowed(false);
        table1.setRowSelectionAllowed(false);
        table1.setCellSelectionEnabled(false);
        table1.setFocusable(false);


        table2.setRowHeight(30);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setColumnSelectionAllowed(false);
        table2.setRowSelectionAllowed(false);
        table2.setCellSelectionEnabled(false);
        table2.setFocusable(false);

        add(panel1);
    }

    private class myUsuariModel extends AbstractTableModel {
        //tipus de taula dels usuaris
        public Object[] values = list1Data;

        @Override
        public int getRowCount() {
            return values.length;
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return values[rowIndex];
        }
    }

    private class myPuntuacioModel extends AbstractTableModel {
        //tipus de taula de la puntuacio
        public Object[] values = list2Data;

        @Override
        public int getRowCount() {
            return values.length;
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return values[rowIndex];
        }
    }

}
