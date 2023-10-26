package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.InvoiceModel;

import java.io.IOException;

@WebServlet("/invoiceControl")
public class InvoiceControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("addInvoice")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.addInvoice(req, resp);
            }else if(action.equals("paid")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.paidInvoices(req, resp);
            }else if(action.equals("cancel")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.cancelInvoices(req, resp);
            }else if(action.equals("addInvoiceByAppt")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.addInvoice(req, resp);
            }
        }else {
            resp.sendRedirect("service.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("addInvoice")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.getSkill(req, resp);
            }else if(action.equals("getInvoices")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.getInvoices(req, resp);
            }else if(action.equals("paid")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.paidInvoices(req, resp);
            }else if(action.equals("cancel")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.cancelInvoices(req, resp);
            }else if(action.equals("addSvcToAppt")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.getSvcNotHave(req, resp);
            }else if(action.equals("addInvoiceByAppt")){
                InvoiceModel invoiceModel=new InvoiceModel();
                invoiceModel.getSkillByAppt(req, resp);
            }
        }else {
            resp.sendRedirect("service.jsp");
        }
    }
}
