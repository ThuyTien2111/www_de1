package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ServiceDao;
import vn.edu.iuh.fit.entity.Service;

public class ServiceDaoTest {
    public static void main(String[] args) {
        ServiceDao serviceDao=new ServiceDao();
//        serviceDao.getAll().forEach(s->System.out.println(s.toString()));
//        System.out.println(serviceDao.get(2));
//        System.out.println(serviceDao.add(new Service(30,"service name", "svc description", 2)));
//        System.out.println(serviceDao.update(new Service(30,"service name 2", "svc description", 2)));
        System.out.println(serviceDao.delete(30));

    }
}
