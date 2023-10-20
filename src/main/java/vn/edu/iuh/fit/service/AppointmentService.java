package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.AppointmentDao;
import vn.edu.iuh.fit.entity.Service;

import java.util.Map;

public class AppointmentService {
    private AppointmentDao appointmentDao;

    public AppointmentService() {
        appointmentDao=new AppointmentDao();
    }
    public Map<Service, Long> getNumberUsedOfService(){
        return appointmentDao.getNumberUsedOfService();
    }
}
