package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.ServicePriceDao;
import vn.edu.iuh.fit.entity.Service;

import java.util.List;

public class SvcPriceService {
    private ServicePriceDao servicePriceDao;

    public SvcPriceService() {
        servicePriceDao=new ServicePriceDao();
    }
    public List<Service> getCheapestPrice(){
        return servicePriceDao.getCheapestPrice();
    }
    public double getPrice(long svcID){
        return servicePriceDao.getPrice(svcID);
    }
}
