package vn.edu.iuh.fit.model;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MainModel {
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        boolean login=false;
        if(user.equals("tien")&&(pass.equals("123"))) login=true;
        if(login){
            response.sendRedirect("service.jsp");
        }else {
            String errMess="Đăng nhập không thành công. Vui lòng kiểm tra lại thông tin đăng nhập";
            request.setAttribute("err", errMess);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
