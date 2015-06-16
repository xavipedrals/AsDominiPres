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
        //System.out.println("Object to string : " + o.toString());
        //canvi
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

    public static Joc2048 getJoc2048(){
        //TODO: Posar menys guarro
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
            System.out.print("hola");
            joc = j;
        }
        return joc;
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

//    private static List getPartidesJugador(String username){
//        SessionFactory sf = HibernateHelper.getSessionFactory();
//        Session session = sf.openSession();
//
//        Jugador j = getJugador(username);
//
//        session.beginTransaction();
//        String hql = "from " + Partida.class.getName() + " p  where p.jugadorByUsername = :arg";
//        List partidaList = session.createQuery(hql)
//                .setParameter("arg", username)
//                .list();
//        session.getTransaction().commit();
//
//        session.close();
//
//        return partidaList;
//    }
//
//    public static ArrayList<Pair> getRankingmillorsPuntuacionsMitjanes(){
//        ArrayList<Jugador> jugadorArrayList = (ArrayList<Jugador>) getAllJugadors();
//        ArrayList<Pair> result = new ArrayList<Pair>();
//        for (Jugador j : jugadorArrayList){
//            ArrayList<Partida> partidaArrayList = (ArrayList<Partida>) getPartidesJugador(j.getUsername());
//            int puntuacioTotal = 0;
//            for (Partida p : partidaArrayList){
//                puntuacioTotal += p.getPuntuacio();
//            }
//            int avgPuntuacio = puntuacioTotal / partidaArrayList.size();
//            result.add(new Pair(j.getUsername(), avgPuntuacio));
//        }
//
//        return result;
//    }

//    public static List getRankingmillorsPuntuacionsMitjanes(){
//        SessionFactory sf = HibernateHelper.getSessionFactory();
//        Session session = sf.openSession();
//
//        session.beginTransaction();
//        String hql = "select j.username, AVG(p.puntuacio) from " + Jugador.class.getName() + " j, "+ Partida.class.getName() +" p  " +
//                "where j.username = p.username and p.estaguanyada = true" +
//                " group by j.username order by j.millorpuntuacio DESC";
//        Iterator jugadorList = session.createQuery(hql)
//                .list()
//                .iterator();
//        session.getTransaction().commit();
//
//        session.close();
//
//        while ( jugadorList.hasNext() ) {
//            Object[] tuple = (Object[]) jugadorList.next();
//            System.out.print(tuple.toString()+ "\n");
//        }
//
//        return null;
//    }




}