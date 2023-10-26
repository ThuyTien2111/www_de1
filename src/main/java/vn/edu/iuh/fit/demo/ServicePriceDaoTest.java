package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ServicePriceDao;

public class ServicePriceDaoTest {
    public static void main(String[] args) {
        ServicePriceDao servicePriceDao=new ServicePriceDao();
//        System.out.println(servicePriceDao.getPrice(2));
        servicePriceDao.getCheapestPrice().forEach(sp->System.out.println(sp.toString()));
//        servicePriceDao.getServicePrice().forEach(sp->System.out.println(sp.toString()));

    }
}
