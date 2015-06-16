package com.company.Domini;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by marcos on 15/06/2015.
 */
//Classe autogenerada per Hibernate a partir de la taula Joc2048 de la BD
@Entity
public class Joc2048 {
    private int idpartida;

    @Id
    @Column(name = "idpartida", nullable = false, insertable = true, updatable = true)
    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Joc2048 that = (Joc2048) o;

        if (idpartida != that.idpartida) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idpartida;
    }
}
