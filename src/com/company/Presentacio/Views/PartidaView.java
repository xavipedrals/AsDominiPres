package com.company.Presentacio.Views;

import com.company.Presentacio.PresentationController;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by marcos on 15/06/2015.
 */
public class PartidaView extends JugarPartidaTemplate{
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JButton DOWNButton;
    private JButton UPButton;
    private JButton RIGHTButton;
    private JButton LEFTButton;
    private JTextArea textArea1;
    private myPuntuacioModel puntModel;
    private myTaulellModel taulellModel;

    private final String puntuacioAct = "Puntuacio actual: ";
    private final String puntuacioMax = "Puntuacio maxima: ";

    public PartidaView(ArrayList<Integer> info){

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setOpaque(false);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        rightRenderer.setOpaque(false);

        DefaultTableCellRenderer leftRenderer= new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        leftRenderer.setOpaque(false);


        puntModel = new myPuntuacioModel();
        table1.setModel(puntModel);
        table1.setCellSelectionEnabled(false);
        table1.setRowHeight(15);
//        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setColumnSelectionAllowed(false);
        table1.setRowSelectionAllowed(false);
        table1.setFocusable(false);

        table1.setOpaque(false);
        table1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        table1.setShowGrid(false);

        taulellModel = new myTaulellModel();
        table2.setModel(taulellModel);

        table2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table2.setRowHeight(50);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setColumnSelectionAllowed(false);
        table2.setRowSelectionAllowed(false);
        table2.setCellSelectionEnabled(false);
        table2.setFocusable(false);
        table2.setOpaque(false);


        UPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.prAmuntJugarPartida();
            }
        });

        DOWNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.prAvallJugarPartida();
            }
        });

        LEFTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.prEsquerraJugarPartida();
            }
        });

        RIGHTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentationController.prDretaJugarPartida();
            }
        });
        add(panel1);
    }










    //TODO A STATIC PER PODER ACCEDIR?
    private class myTaulellModel extends AbstractTableModel {
        public Object[][] values = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        @Override
        public int getRowCount() {
            return values.length;
        }

        @Override
        public int getColumnCount() {
            return values[0].length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return values[rowIndex][columnIndex];
        }

        public void setValue(Object value, int rowIndex, int columnIndex){
            values[rowIndex][columnIndex] = value;
        }
    }

    private class myPuntuacioModel extends AbstractTableModel {
        public Object[][] values = {
                {"Puntuacio actual: ",0},
                {"Millor puntuacio: ",0}
        };

        @Override
        public int getRowCount() {
            return values.length;
        }

        @Override
        public int getColumnCount() {
            return values[0].length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            //TODO EN PRINCIPIO NO SE DEBE PODER COGER NINGUN VALOR
            return values[rowIndex][columnIndex];
        }

        public void setPuntuacioActual(int p ){
            values[0][1] = p;
        }
        public void setPuntuacioSiMaxima(int p){
            if(p >= (Integer)values[1][1]){
                values[1][1] = p;
            }
        }
    }

    public void actualitzaPuntuacio(int p){
        puntModel.setPuntuacioActual(p);
        puntModel.setPuntuacioSiMaxima(p);
    }
    public void actualitzaCaselles(ArrayList<Integer> p) {
        int i, j, k;
        i = 0;

        for(Integer i : p){
            System.out.println(i);
        }
        while(i <= 13){
            taulellModel.setValue(p.get(i),p.get(i+1),p.get(i+2));
            i += 3;
        }
    }
}
