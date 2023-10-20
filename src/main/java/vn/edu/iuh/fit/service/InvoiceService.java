package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.InvoiceDao;
import vn.edu.iuh.fit.entity.Invoice;

public class InvoiceService {
    private InvoiceDao invoiceDao;

    public InvoiceService() {
        invoiceDao=new InvoiceDao();
    }
    public boolean addInvoice(Invoice invoice){
        if((invoice.getPaymentMethod()>=1)&&(invoice.getPaymentMethod()<=3)){
            if((invoice.getStatus()>=0)&&(invoice.getStatus()<=2)){
                return invoiceDao.add(invoice);
            }else return false;
        }else return false;
    }
    public Double calcTotalPrice(long apptNo){
        return invoiceDao.calcTotalPrice(apptNo);
    }
}
