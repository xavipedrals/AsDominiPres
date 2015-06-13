package com.company.Domini;

/**
 * Created by xavivaio on 11/06/2015.
 */
public class UsuariRegistrat {
    private String nom;
    private String cognom;
    private String username;
    private String pwd;

    public UsuariRegistrat(){

    }
    public UsuariRegistrat(String nom){
            this.nom = nom;
    }

    public UsuariRegistrat(String nom,String cognom,String username,String pwd){
        this.nom = nom;
        this.cognom = cognom;
        this.username = username;
        this.pwd = pwd;
    }

    public void setNom(String s){
        this.nom = s;
    }

    public String getNom(){
        return this.nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
