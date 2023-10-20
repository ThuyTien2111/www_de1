package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;

import java.util.ArrayList;
import java.util.List;

public class ServicePriceDao {
    private EntityManager manager;

    public ServicePriceDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<Service> getCheapestPrice(){
        List<Service> list=new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT * FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE Price IN(\n" +
                    "SELECT MIN(Price) FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate)\n" +
                    "FROM service_price \n" +
                    "WHERE ServiceID=service.ServiceID\n" +
                    ")\n" +
                    ")\n";
            list=manager.createNativeQuery(sql, Service.class).getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    public double getPrice(long svcID){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            //xu ly gia
            String sql="SELECT service.ServiceID, Price, Note, ServicePriceDate FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate)\n" +
                    "FROM service_price \n" +
                    "WHERE ServiceID=service.ServiceID\n" +
                    ")\n" +
                    "AND (service.ServiceID=?)\n";
            Query query= manager.createNativeQuery(sql, ServicePrice.class);
            query.setParameter(1,svcID);
            ServicePrice servicePrice= (ServicePrice) query.getSingleResult();
            tr.commit();
            return servicePrice.getSvcPrice();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return 0;
    }

}
