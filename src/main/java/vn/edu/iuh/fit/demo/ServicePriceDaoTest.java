package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ServicePriceDao;

public class ServicePriceDaoTest {
    public static void main(String[] args) {
        ServicePriceDao servicePriceDao=new ServicePriceDao();
        servicePriceDao.getCheapestPrice().forEach(sp->System.out.println(sp.toString()));
    }
}
