package com.csye6220.esdfinalproject.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.csye6220.esdfinalproject.model.*;



public class HibernateUtil {

	public static SessionFactory buildSessionFactory(){
        Map<String, Object> map = new HashMap<>();
        map.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        map.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/esd_final_project?createDatabaseIfNotExist=true");
        map.put("hibernate.connection.username", "root");
        map.put("hibernate.connection.password","Neha@1509");

        map.put("hibernate.hbm2ddl.auto", "update");
        map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        map.put("hibernate.dialect.storage_engine", "innodb");
        map.put("hibernate.show-sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(map).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addPackage("com.csye6220.esdfinalproject.model");
        metadataSources.addAnnotatedClasses(ApplyJob.class,User.class,JobPost.class,Company.class);

        Metadata metadata = metadataSources.buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;
    }
}

