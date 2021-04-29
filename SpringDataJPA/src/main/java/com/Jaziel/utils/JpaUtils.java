package com.Jaziel.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author 王杰
 * @date 2021/4/29 9:54
 */
public class JpaUtils {
    private static EntityManagerFactory myJPA;
    static {
        myJPA = Persistence.createEntityManagerFactory("myJPA");
    }

    public static EntityManager getJpaManager(){
        return myJPA.createEntityManager();
    }
}
