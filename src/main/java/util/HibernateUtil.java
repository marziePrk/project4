package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    //TODO add try catch

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
