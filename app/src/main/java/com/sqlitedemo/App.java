/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.sqlitedemo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String args[]) {
        Configuration configuration = new Configuration();
        // SQLite Settings (this should be configured in a persistence.xml file or something)
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        configuration.setProperty("hibernate.connection.url", "jdbc:sqlite:test.db");
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.community.dialect.SQLiteDialect");
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = new User();
        user.setName("Fake User");
        user.setEmail("hey@fake.com");
        session.persist(user);

        tx.commit();
        session.close();
    }
}
