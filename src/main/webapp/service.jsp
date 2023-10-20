<%@ page import="vn.edu.iuh.fit.dao.ServiceDao" %>
<%@ page import="vn.edu.iuh.fit.service.SvcService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Service" %>
<%@ page import="vn.edu.iuh.fit.service.SvcPriceService" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 20/10/2023
  Time: 4:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách dịch vụ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Danh sách dịch vụ</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên dịch vụ</th>
            <th>Mô tả</th>
            <th>Trạng thái</th>
            <th>Giá</th>
        </tr>
        </thead>
        <tbody>
        <%
            SvcService service=new SvcService();
            List<Service> services=service.getAllService();
            SvcPriceService svcPriceService=new SvcPriceService();
            //Phân trang
            int pageSize = 5; // Số công việc trên mỗi trang
            int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, services.size());
            List<Service> svcOnPage = services.subList(startIndex, endIndex);
            for (Service s:svcOnPage) {
                String status="";
                if(s.getStatus()==0){
                    status="STOPED";
                } else if (s.getStatus()==1) {
                    status="ACTIVE";
                } else if (s.getStatus()==2) {
                    status="TERMINATED";
                }
                //Xử lý giá
                String price= String.valueOf(svcPriceService.getPrice(s.getSvcId()));
        %>
        <tr>
            <td><%=s.getSvcName()%></td>
            <td><%=s.getSvcDesc()%></td>
            <td><%=status%></td>
            <td><%=price%></td>
            <td>
                <a href="serviceControl?action=update&svcID=<%=s.getSvcId()%>" class="btn btn-warning">Sửa</a>
                <a href="serviceControl?action=delete&svcID=<%=s.getSvcId()%>" class="btn btn-danger">Xóa</a>
                <a href="serviceControl?action=active&svcID=<%=s.getSvcId()%>" class="btn btn-info">Active</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <!-- Phân trang -->
    <ul class="pagination">
        <%
            int totalPages = (int) Math.ceil((double) services.size() / pageSize);
            for (int i = 1; i <= totalPages; i++) {
        %>
        <li class="page-item <%= i == currentPage ? "active" : "" %>">
            <a class="page-link" href="service.jsp?page=<%= i %>"><%= i %></a>
        </li>
        <%
            }
        %>
    </ul>
    <a href="add-service.jsp" class="btn btn-primary">Thêm dịch vụ</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
