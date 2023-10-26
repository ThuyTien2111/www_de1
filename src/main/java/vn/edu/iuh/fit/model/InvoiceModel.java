package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Appointment;
import vn.edu.iuh.fit.entity.Invoice;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.service.InvoiceService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InvoiceModel {
    private final InvoiceService invoiceService=new InvoiceService();
    public void addInvoice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        //xử lý kiểu ngày giờ
        String startStr=request.getParameter("start");
        LocalDateTime start=LocalDateTime.parse(startStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        String endStr=request.getParameter("end");
        LocalDateTime end=LocalDateTime.parse(endStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        int payment= Integer.parseInt(request.getParameter("payment"));

        invoiceService.addInvoice(new Invoice(new Appointment(apptNo, start, end), new Service(svcID), payment));

        response.sendRedirect("invoiceControl?action=getInvoices&apptNo="+apptNo);
    }
    public void getSkill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        request.setAttribute("svcID", svcID);
        request.getRequestDispatcher("add-invoice.jsp").forward(request, response);
    }

    public void getInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        request.setAttribute("apptNo", apptNo);
        request.getRequestDispatcher("appt-details.jsp").forward(request, response);
    }

    public void paidInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        long svcID= Long.parseLong(request.getParameter("svcID"));
        invoiceService.paidInvoice(apptNo, svcID);

        request.setAttribute("apptNo",apptNo);
        request.getRequestDispatcher("appt-details.jsp").forward(request, response);
    }
    public void cancelInvoices(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        long svcID= Long.parseLong(request.getParameter("svcID"));
        invoiceService.cancelInvoice(apptNo, svcID);

        request.setAttribute("apptNo",apptNo);
        request.getRequestDispatcher("appt-details.jsp").forward(request, response);
    }
    public void getSvcNotHave(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        request.setAttribute("apptNo", apptNo);
        request.getRequestDispatcher("svc-no-book.jsp").forward(request, response);
    }
    public void getSkillByAppt(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        long apptNo= Long.parseLong(request.getParameter("apptNo"));
        request.setAttribute("svcID", svcID);
        request.setAttribute("apptNo", apptNo);
        request.getRequestDispatcher("add-skill-to-invoice.jsp").forward(request, response);
    }

}
