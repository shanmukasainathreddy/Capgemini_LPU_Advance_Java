package com.product;

import javax.persistence.*;

public class productDao {

     static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

     static EntityManager em = emf.createEntityManager();

    public void insertProduct(product p) {

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(p);
        et.commit();
    }

    public product findById(int id) {

        product p  =  em.find(product.class, id);
        return p;
    }

    public boolean deleteProduct(int id) {

    	product p = findById(id);


        if (p != null) {
            EntityTransaction et = em.getTransaction();
            et.begin(); // transaction starts
            em.remove(p);// removed by manager
            et.commit();
            return true;
        }
        else return false;
//        else throw new IllegealException();
    } 
    
    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}