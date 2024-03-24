package com.cc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class girtHiberanteUtil {
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;

    static {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();//获取本地绑定的对象
    }
}
