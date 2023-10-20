package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AppointmentDao {
    private EntityManager manager;

    public AppointmentDao() {
        manager=Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public Map<Service, Long> getNumberUsedOfService(){
       Map<Service, Long> map=new HashMap<>();
        EntityTransaction tr=manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT ServiceID, COUNT(*) as TotalUsed \n" +
                    "FROM appointment\n" +
                    "INNER JOIN invoice ON appointment.ApptNo=invoice.ApptNo\n" +
                    "GROUP BY ServiceID";
            List<Object[]> objects= manager.createNativeQuery(sql, "NumberUsedOfServiceDTO").getResultList();
            for (Object[] obj:objects) {
                Service s=manager.find(Service.class, obj[0]);
                map.put(s, (Long) obj[1]);
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
       return map;
    }
}
