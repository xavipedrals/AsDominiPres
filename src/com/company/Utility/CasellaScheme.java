package com.company.Utility;

/**
 * Created by marcos on 16/06/2015.
 */
public class CasellaScheme {
    private int row;
    private int col;
    private int num;

    public CasellaScheme(int numerofila, int numerocolumna, Integer numero){
        row = numerofila;
        col = numerocolumna;
        num = numero;
    }
    public CasellaScheme(){
        row = 0;
        col = 0;
        num = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
