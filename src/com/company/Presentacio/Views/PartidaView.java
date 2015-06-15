package com.company.Presentacio.Views;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * Created by marcos on 15/06/2015.
 */
public class PartidaView extends JugarPartidaTemplate{
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JButton button1;

    private final String puntuacioAct = "Puntuacio actual: ";
    private final String puntuacioMax = "Puntuacio maxima: ";

    public PartidaView(ArrayList<Integer> info){
//        table1 = new JTable(2,2);
//        table1.setValueAt(puntuacioAct,0,0);
//        table1.setValueAt(puntuacioMax,1,0);
//        table1.setValueAt(0,0,0);
//        table1.setValueAt(0,1,0);


//        table2 = new JTable(4,4);

//        //Todo, actualizar este for que está a ceros para que coja datos del array.
//        for (int i = 0; i < 4 ; ++i){
//            for (int j = 0 ; j < 4; ++j){
//                table2.setValueAt(0, i, j);
//            }
//        }
//
//        hideMessage();
//        table1.setVisible(true);
//        table2.setVisible(true);
        table1.setModel(new myPuntuacioModel());
        table2.setModel(new myTaulellModel());
        add(panel1);
    }

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
                {"Puntuació Actual: ",0},
                {"Millor puntuació: ",0}
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

//        public void setTag1(String x){
//            values[1][1] = x;
//        }
//
//        public void setTag2(String x){
//            values[1][1] = x;
//        }

        public void setPuntuacioActual(int p ){
            values[0][1] = p;
        }
        public void setPuntuacioMaxima(int p){
            values[1][1] = p;
        }
    }


    public void actualitzaCaselles(ArrayList<Integer> info){
        //TODO llamar al hacer movimiento. controller --> actualitza caselles
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
