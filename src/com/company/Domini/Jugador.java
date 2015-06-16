package com.company.Domini;

import javax.persistence.*;
import java.util.Collection;


//Classe autogenerada per Hibernate a partir de la taula Jugador de la BD
@Entity
public class Jugador {
    private String username;
    private String email;
    private Integer millorpuntuacio;
    private Usuariregistrat usuariregistratByUsername;
    private Collection<Partida> partidasByUsername;

    @Id
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "millorpuntuacio", nullable = true, insertable = true, updatable = true)
    public Integer getMillorpuntuacio() {
        return millorpuntuacio;
    }

    public void setMillorpuntuacio(Integer millorpuntuacio) {
        this.millorpuntuacio = millorpuntuacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador that = (Jugador) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (millorpuntuacio != null ? !millorpuntuacio.equals(that.millorpuntuacio) : that.millorpuntuacio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (millorpuntuacio != null ? millorpuntuacio.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public Usuariregistrat getUsuariregistratByUsername() {
        return usuariregistratByUsername;
    }

    public void setUsuariregistratByUsername(Usuariregistrat usuariregistratByUsername) {
        this.usuariregistratByUsername = usuariregistratByUsername;
    }

    @OneToMany(mappedBy = "jugadorByUsername")
    public Collection<Partida> getPartidasByUsername() {
        return partidasByUsername;
    }

    public void setPartidasByUsername(Collection<Partida> partidasByUsername) {
        this.partidasByUsername = partidasByUsername;
    }
}
