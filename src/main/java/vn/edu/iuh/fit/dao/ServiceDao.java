package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Invoice;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceDao {
    private EntityManager manager;

    public ServiceDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Service service, ServicePrice servicePrice){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            manager.persist(service);
            servicePrice.setSvcPriceDate(LocalDateTime.now());
            servicePrice.setService(service);
            manager.persist(servicePrice);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Service service){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            manager.merge(service);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean delete(long id){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            Service s= manager.find(Service.class,id);
            s.setStatus(0);
            manager.merge(s);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean active(long id){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            Service s= manager.find(Service.class,id);
            s.setStatus(1);
            manager.merge(s);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Service get(long id){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            return manager.find(Service.class,id);
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Service> getAll(){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            tr.commit();
            return manager.createQuery("select s from Service s", Service.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
