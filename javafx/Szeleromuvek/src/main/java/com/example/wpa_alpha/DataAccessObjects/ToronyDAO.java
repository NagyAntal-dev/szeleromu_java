package com.example.wpa_alpha.DataAccessObjects;

import com.example.wpa_alpha.PersistenceModels.Torony;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public class ToronyDAO {

    /**
     * Visszaadja id alapján a megfelelő megyét. Ha nincs olyan Torony akkor null értéket ad vissza.
     * @param id A kért Torony id-je
     * @return Torony object
     */
    public static Torony getToronyById(int id){
        DatabaseConn conn = new DatabaseConn(new Torony());
        return conn.getSession().get(Torony.class,id);
    }

    /**
     * Visszaadja az összes megyét.
     * @return ArrayList<Torony>
     */
    public static ArrayList<Torony> getAllTorony(){
        DatabaseConn conn = new DatabaseConn(new Torony());
        CriteriaBuilder criteriaBuilder = conn.getSession().getCriteriaBuilder();
        CriteriaQuery<Torony> criteriaQuery = criteriaBuilder.createQuery(Torony.class);
        criteriaQuery.from(Torony.class);
        ArrayList<Torony> result = (ArrayList<Torony>) conn.getSession().createQuery(criteriaQuery).getResultList();
        return result;
    }

    /**
     * Átadott megyét hozzáadja az adatbázishoz.
     * @param item
     */
    public static void addTorony(Torony item){
        DatabaseConn conn = new DatabaseConn(new Torony());
        Transaction transaction = conn.getSession().beginTransaction();
        conn.getSession().save(item);
        transaction.commit();
    }

    /**
     * Átadott megyét felülírja/szerkeszti.
     * @param item
     */
    public static void updateTorony(Torony item){
        DatabaseConn conn = new DatabaseConn(new Torony());
        Transaction transaction = conn.getSession().beginTransaction();
        conn.getSession().update(item);
        transaction.commit();
    }

    /**
     * Átadott megyét törli.
     * @param item
     */
    public static void deleteTorony(Torony item){
        DatabaseConn conn = new DatabaseConn(new Torony());
        Transaction transaction = conn.getSession().beginTransaction();
        conn.getSession().remove(item);
        transaction.commit();
    }

    /**
     * Átadott Torony id-je alapján töröl.
     * @param id
     */
    public static void deleteTorony(int id){
        Torony item = ToronyDAO.getToronyById(id);
        DatabaseConn conn = new DatabaseConn(new Torony());
        Transaction transaction = conn.getSession().beginTransaction();
        conn.getSession().remove(item);
        transaction.commit();
    }
}
