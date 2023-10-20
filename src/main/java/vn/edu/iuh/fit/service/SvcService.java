package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.ServiceDao;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;

import java.util.List;

public class SvcService {
    private ServiceDao serviceDao;

    public SvcService() {
        serviceDao=new ServiceDao();
    }
    public boolean addService(Service service, ServicePrice servicePrice){
        if((service.getStatus()>=0)&&(service.getStatus()<=2)){
            return serviceDao.add(service, servicePrice);
        }
        else return false;
    }
    public boolean updateService(Service service){
        if((service.getStatus()>=0)&&(service.getStatus()<=2)){
            return serviceDao.update(service);
        }
        else return false;
    }
    public boolean deleteService(long id){
        return serviceDao.delete(id);
    }
    public boolean activeService(long id){
        return serviceDao.active(id);
    }

        public Service getServiceByID(long id){
        return serviceDao.get(id);
    }
    public List<Service> getAllService(){
        return serviceDao.getAll();
    }

}
