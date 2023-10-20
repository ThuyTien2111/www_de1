package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Appointment;
import vn.edu.iuh.fit.entity.Invoice;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDao {
    private EntityManager manager;

    public InvoiceDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Invoice invoice){
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
            query.setParameter(1,invoice.getService().getSvcId());
            ServicePrice servicePrice= (ServicePrice) query.getSingleResult();
            //gan service_price moi lay duoc cho service cua invoice
            invoice.setPrice(servicePrice.getSvcPrice());
            //gan ngay tao hoa don bang ngay hom nay
            invoice.setInvDate((LocalDateTime.now()));
            //mac dinh hoa don moi tao co status 1
            invoice.setStatus(1);
            //them invoice
            manager.persist(invoice);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Double calcTotalPrice(long apptNo){
        Double rs= (double) 0;
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            if(manager.find(Appointment.class,apptNo)==null) rs=(double)0;
            else {
                String sql = "SELECT SUM(Price*TIMESTAMPDIFF(MINUTE, appointment.Start, appointment.End) / 60.0) AS totalPrice FROM invoice\n" +
                        "INNER JOIN appointment ON appointment.ApptNo=invoice.ApptNo\n" +
                        "WHERE invoice.ApptNo=?";
                Query query = manager.createNativeQuery(sql); //lay class cua double la se lỗi
                query.setParameter(1, apptNo);
                rs=Double.parseDouble(query.getSingleResult().toString());
                tr.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return rs;
    }
}
