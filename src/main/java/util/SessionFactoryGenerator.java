package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class SessionFactoryGenerator {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private SessionFactoryGenerator() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
