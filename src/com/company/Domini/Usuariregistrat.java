package com.company.Domini;

import javax.persistence.*;

/**
 * Created by marcos on 15/06/2015.
 */
@Entity
public class Usuariregistrat {
    private String nom;
    private String cognom;
    private String username;
    private String password;
    private Jugador jugadorByUsername;

    @Basic
    @Column(name = "nom", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "cognom", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    @Id
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuariregistrat that = (Usuariregistrat) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (cognom != null ? !cognom.equals(that.cognom) : that.cognom != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (cognom != null ? cognom.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "usuariregistratByUsername")
    public Jugador getJugadorByUsername() {
        return jugadorByUsername;
    }

    public void setJugadorByUsername(Jugador jugadorByUsername) {
        this.jugadorByUsername = jugadorByUsername;
    }
}
