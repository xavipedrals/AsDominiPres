package com.company.Utility;

/**
 * Created by marcos on 13/06/2015.
 */
public class Pair {
        private String user;
        private int puntuacio;

        public Pair(){

        }

        public Pair(String a, int b){
            this.user = a;
            this.puntuacio = b;
        }

        public void setUser(String s){
            this.user = s;
        }

        public void setPuntuacio(int p){
            this.puntuacio = p;
        }

    public String getUser() {
        return user;
    }

    public int getPuntuacio() {
        return puntuacio;
    }
}
