package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.convert.ServicePriceDTO;
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
    public List<ServicePriceDTO> getCheapestPrice(){
        List<ServicePriceDTO> list=new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT service.ServiceID, service.ServiceName, service.Description, service.Status , Price \n" +
                    "FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE Price IN(\n" +
                    "SELECT MIN(Price)\n" +
                    "FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate)\n" +
                    "FROM service_price\n" +
                    "WHERE ServiceID=service.ServiceID\n" +
                    ")\n" +
                    ")";
            List<Object[]> objects=manager.createNativeQuery(sql, "ServicePriceDTO").getResultList();
            for (Object[] obj:objects) {
                list.add(new ServicePriceDTO((Long) obj[0], (String) obj[1], (String) obj[2], (Integer) obj[3], (Double) obj[4]));
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    //lấy giá cho từng service
    public double getPrice(long svcID){
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            //xu ly gia
            String sql="SELECT * FROM service_price\n" +
                    "WHERE ServiceID=?\n" +
                    "AND ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate) FROM service_price\n" +
                    "WHERE ServiceID=?\n" +
                    ")";
            Query query= manager.createNativeQuery(sql, ServicePrice.class);
            query.setParameter(1,svcID);
            query.setParameter(2,svcID);
            ServicePrice servicePrice= (ServicePrice) query.getSingleResult();
            tr.commit();
            return servicePrice.getSvcPrice();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return 0;
    }
    //lấy ds service kèm giá gần nhất của nó
    public List<ServicePriceDTO> getServicePrice(){
        EntityTransaction tr=manager.getTransaction();
        List<ServicePriceDTO> list=new ArrayList<>();
        tr.begin();
        try {
            //xu ly gia
            String sql="SELECT service.ServiceID, service.ServiceName, service.Description, service.Status , Price \n" +
                    "FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate)\n" +
                    "FROM service_price\n" +
                    "WHERE ServiceID=service.ServiceID\n" +
                    ")";
            List<Object[]> objects= manager.createNativeQuery(sql, "ServicePriceDTO").getResultList();
            for (Object[] obj:objects) {
                list.add(new ServicePriceDTO((long)obj[0],(String) obj[1], (String) obj[2], (int) obj[3], (double)obj[4]));
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    public List<ServicePriceDTO> getServicePriceNotHave(long apptNo){
        EntityTransaction tr=manager.getTransaction();
        List<ServicePriceDTO> list=new ArrayList<>();
        tr.begin();
        try {
            //xu ly gia
            String sql="SELECT service.ServiceID, service.ServiceName, service.Description, service.Status , Price \n" +
                    "FROM service\n" +
                    "INNER JOIN service_price ON service_price.ServiceID=service.ServiceID\n" +
                    "WHERE ServicePriceDate=(\n" +
                    "SELECT MAX(ServicePriceDate)\n" +
                    "FROM service_price\n" +
                    "WHERE ServiceID=service.ServiceID\n" +
                    ") AND service.ServiceID NOT IN (\n" +
                    "SELECT ServiceID FROM invoice\n" +
                    "WHERE ApptNo=?\n" +
                    ")";
            Query query=manager.createNativeQuery(sql, "ServicePriceDTO");
            query.setParameter(1, apptNo);
            List<Object[]> objects= query.getResultList();
            for (Object[] obj:objects) {
                list.add(new ServicePriceDTO((long)obj[0],(String) obj[1], (String) obj[2], (int) obj[3], (double)obj[4]));
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }

}
