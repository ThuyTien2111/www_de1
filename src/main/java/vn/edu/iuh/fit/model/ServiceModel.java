package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;
import vn.edu.iuh.fit.service.SvcService;

import java.io.IOException;

public class ServiceModel {
    private SvcService svcService=new SvcService();
    public void addService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        String svcName=request.getParameter("svcName");
        String svcDes=request.getParameter("svcDes");
        int status= Integer.parseInt(request.getParameter("svcStatus"));
        double price= Double.parseDouble(request.getParameter("svcPrice"));
        String note= request.getParameter("svcNote");
        svcService.addService(new Service(svcID, svcName, svcDes, status), new ServicePrice(price, note));
        response.sendRedirect("service.jsp");
    }
    public void deleteService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        svcService.deleteService(svcID);
        response.sendRedirect("service.jsp");
    }
    public void activeService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        svcService.activeService(svcID);
        response.sendRedirect("service.jsp");
    }
    public void updateService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        String svcName=request.getParameter("svcName");
        String svcDes=request.getParameter("svcDes");
        int status= Integer.parseInt(request.getParameter("svcStatus"));
        svcService.updateService(new Service(svcID, svcName, svcDes, status));
        response.sendRedirect("service.jsp");
    }
    public void getService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long svcID= Long.parseLong(request.getParameter("svcID"));
        Service service=svcService.getServiceByID(svcID);
        request.setAttribute("service", service);
        request.getRequestDispatcher("update-service.jsp").forward(request, response);
    }
}
