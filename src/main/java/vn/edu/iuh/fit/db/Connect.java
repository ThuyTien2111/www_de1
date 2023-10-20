package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connect {
    private static Connect instance;
    private EntityManagerFactory entityManagerFactory;

    public Connect() {
        entityManagerFactory= Persistence.createEntityManagerFactory("De1GK");
    }

    public static Connect getInstance() {
        if(instance==null) instance=new Connect();
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
