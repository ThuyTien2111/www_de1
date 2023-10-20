package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.AppointmentDao;

public class ApptDaoTest {
    public static void main(String[] args) {
        AppointmentDao appointmentDao=new AppointmentDao();
        appointmentDao.getNumberUsedOfService().entrySet().forEach(entry->{
            System.out.println(entry.getKey()+"\n So luong:"+entry.getValue());
        });
    }
}
