package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.ServiceModel;

import java.io.IOException;

@WebServlet("/serviceControl")
public class ServiceControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("add")) {
                ServiceModel serviceModel = new ServiceModel();
                serviceModel.addService(req, resp);
            } else if (action.equals("delete")) {
                ServiceModel serviceModel=new ServiceModel();
                serviceModel.deleteService(req, resp);
            } else if (action.equals("active")) {
                ServiceModel serviceModel=new ServiceModel();
                serviceModel.activeService(req, resp);
            } else if (action.equals("update")) {
                ServiceModel serviceModel=new ServiceModel();
                serviceModel.updateService(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject = req.getParameter("action");
        if (actObject != null) {
            String action = actObject.toString();
            if (action.equals("delete")) {
                ServiceModel serviceModel = new ServiceModel();
                serviceModel.deleteService(req, resp);
            } else if (action.equals("active")) {
                ServiceModel serviceModel = new ServiceModel();
                serviceModel.activeService(req, resp);
            } else if (action.equals("update")) {
                ServiceModel serviceModel=new ServiceModel();
                serviceModel.getService(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }

}
