package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.InvoiceDao;
import vn.edu.iuh.fit.entity.Appointment;
import vn.edu.iuh.fit.entity.Invoice;
import vn.edu.iuh.fit.entity.Service;

import java.time.LocalDateTime;

public class InvoiceDaoTest {
    public static void main(String[] args) {
        InvoiceDao invoiceDao= new InvoiceDao();
//        System.out.println(invoiceDao.add(new Invoice(new Appointment(2), new Service(4), 1,2)));
        System.out.println(invoiceDao.calcTotalPrice(10));

    }
}
