package com.company.Utility;

/**
 * Created by marcos on 15/06/2015.
 */

import com.company.Domini.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper {

    private static final SessionFactory sessionFactory = buildSessionFactory();

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
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(o);

        session.getTransaction().commit();

        session.close();
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

    public static Usuariregistrat getUsuariRegistrat(String username){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        Usuariregistrat u = (Usuariregistrat) session.get(Usuariregistrat.class, username);
        session.getTransaction().commit();

        session.close();

        return u;
    }

    public static Jugador getJugador(String username){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        Jugador j = (Jugador) session.get(Jugador.class, username);
        session.getTransaction().commit();

        session.close();

        return j;
    }

    public static Partida getPartida(int idPartida){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        Partida p = (Partida) session.get(Partida.class, idPartida);
        session.getTransaction().commit();

        session.close();

        return p;
    }

    private static Casella getCasellaPK(int idPartida, int numeroFila, int numeroColumna){
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

    public static Joc2048 getJoc2048(int idPartida){
        SessionFactory sf = HibernateHelper.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        Joc2048 j = (Joc2048) session.get(Joc2048.class, idPartida);
        session.getTransaction().commit();

        session.close();

        return j;
    }

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


}