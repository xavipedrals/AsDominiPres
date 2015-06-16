package com.company.Utility;

import com.company.Domini.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.ArrayList;
import java.util.List;

//És una classe que serveix per ajudar a fer les operacions a base de dades a través de Hibernate.
//S'encarrega de crear la sessió i fer-la servir per fer les transaccions.
public class HibernateHelper {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    //Crea una sessió a la base de dades en base al fitxer hibernate.cfg.xml
    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Inserta un objecte, si ja existeix tira exec
    public static Object save(Object o) {
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return o;
    }

    // Actualitza un objecte, si no existeix tira exec
    public static Object update(Object o) {
        delete(o);
        save(o);
        return o;
    }

    // Esborra un objecte, si no existeix tira exec
    public static void delete(Object o) {
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    //Borra totes les tuples d'una taula
    public static int emptyTable(String myTable) {
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = String.format("delete from %s", myTable);
        Query query = session.createQuery(hql);
        int res = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return res;
    }

    //Fa get a un UsuariRegistrat existent a la BD, si no existeix retorna null
    public static Usuariregistrat getUsuariRegistrat(String username){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Usuariregistrat u = (Usuariregistrat) session.get(Usuariregistrat.class, username);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    //Fa get a un Jugador existent a la BD, si no existeix retorna null
    public static Jugador getJugador(String username){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Jugador j = (Jugador) session.get(Jugador.class, username);
        session.getTransaction().commit();
        session.close();
        return j;
    }

    //Fa get a una Partida existent a la BD, si no existeix retorna null
    public static Partida getPartida(int idPartida){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Partida p = (Partida) session.get(Partida.class, idPartida);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    //Fa get a una Casella existent a la BD, si no existeix retorna null
    public static Casella getCasella(int idPartida, int numeroFila, int numeroColumna){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        CasellaPK cpk = new CasellaPK();
        cpk.setIdpartida(idPartida);
        cpk.setNumerocolumna(numeroColumna);
        cpk.setNumerofila(numeroFila);
        session.beginTransaction();
        Casella c = (Casella) session.get(Casella.class, cpk);
        session.getTransaction().commit();
        session.close();
        return c;
    }

    //Fa get a totes les tuples de Joc2048 existents a la BD, si no existeix retorna null
    //Si es controla bé només hi haurà una tupla de 2048 a la BD
    public static Joc2048 getJoc2048(){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "from " + Joc2048.class.getName() + " j";
        List jocList = session.createQuery(hql)
                .list();
        session.getTransaction().commit();
        session.close();
        Joc2048 joc = new Joc2048();
        ArrayList<Joc2048> joc2048ArrayList = (ArrayList<Joc2048>) jocList;
        for(Joc2048 j : joc2048ArrayList){
            joc = j;
        }
        return joc;
    }

    //Retorna una llista amb totes les caselles existents a la BD amb un cert idPartida, 
    // si no existeixen o idPartida no existeix retorna llista buida
    public static List getCasellesPartida (int idPartida){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "from " + Casella.class.getName() + " c  where c.idpartida = :arg";
        List casellaList = session.createQuery(hql)
                .setParameter("arg", idPartida)
                .list();
        session.getTransaction().commit();
        session.close();
        return casellaList;
    }

    //Retorna una llista amb tots els Jugadors existents a la BD, 
    // si no existeixen jugadors retorna llista buida
    public static List getAllJugadors(){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        String hql = "from " + Jugador.class.getName() + " j";
        List jugadorList = session.createQuery(hql)
                .list();
        session.getTransaction().commit();
        session.close();
        return jugadorList;
    }

    //Retorna una llista ordenada per millor puntuacio de Jugadors existents a la BD
    // si no existeixen jugadors retorna llista buida
    public static List getRankingmillorsPuntuacions(){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        String hql = "from " + Jugador.class.getName() + " j  where j.millorpuntuacio <> 0 order by j.millorpuntuacio DESC";
        List jugadorList = session.createQuery(hql)
                .list();
        session.getTransaction().commit();

        session.close();

        return jugadorList;
    }

    public static void updateCaselles(Casella[][] casellas){
        for(Casella[] c : casellas){
            for(Casella q: c){
                update(c);
            }
        }
    }
    


    
}