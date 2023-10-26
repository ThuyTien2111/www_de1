package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.InvoiceDao;
import vn.edu.iuh.fit.entity.Invoice;

import java.util.List;

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
    public List<Invoice> getInvoiceByApptNo(long apptNo){
        return invoiceDao.getInvoiceByApptNo(apptNo);
    }
    public boolean paidInvoice(long apptNo, long svcID){
        return invoiceDao.paidInvoice(apptNo, svcID);
    }
    public boolean cancelInvoice(long apptNo, long svcID){
        return invoiceDao.cancelInvoice(apptNo, svcID);
    }
}
