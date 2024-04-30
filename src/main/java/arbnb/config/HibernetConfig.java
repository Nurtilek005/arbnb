package arbnb.config;

import arbnb.entyti.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernetConfig {


    public static EntityManagerFactory getentityManeger() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD, "1234");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL, "true");

            System.out.println("In method");
            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Agensy.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(House.class);
            configuration.addAnnotatedClass(Owner.class);
            configuration.addAnnotatedClass(Rent_info.class);
            System.out.println("In method2");
            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}
