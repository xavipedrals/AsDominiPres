package com.company.Presentacio.Views;

import com.company.Utility.Pair;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by marcos on 16/06/2015.
 */
public class RankingView extends JugarPartidaTemplate{


    private JPanel panel1;
    private JButton menuButton;
    private JTable table1;
    private JTable table2;
    private ArrayList<Pair> result;
    private String list1Data[];
    private String list2Data[];

    private void insereixDades() {
        result = new ArrayList<Pair>();
        for (int i = 0; i < 5; ++i) {
            Pair p = new Pair("Usuari"+i, (5-i)*350000);
            result.add(p);
        }
        list1Data = new String[result.size()];
        list2Data = new String[result.size()];
        int i = 0;
        for (Pair p : result) {
            list1Data[i] = p.getUser();
            list2Data[i] = String.valueOf(p.getPuntuacio());
            i++;
        }
    }

    public RankingView(){
        insereixDades();
        table1.setModel(new myUsuariModel());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table2.setModel(new myPuntuacioModel());
        table2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        add(panel1);
    }

    private class myUsuariModel extends AbstractTableModel {
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
            //TODO EN PRINCIPIO NO SE DEBE PODER COGER NINGUN VALOR
            return values[rowIndex];
        }
    }

    private class myPuntuacioModel extends AbstractTableModel {
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
            //TODO EN PRINCIPIO NO SE DEBE PODER COGER NINGUN VALOR
            return values[rowIndex];
        }
    }

}
