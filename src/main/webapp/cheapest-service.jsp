<%@ page import="vn.edu.iuh.fit.dao.ServiceDao" %>
<%@ page import="vn.edu.iuh.fit.service.SvcService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Service" %>
<%@ page import="vn.edu.iuh.fit.service.SvcPriceService" %>
<%@ page import="vn.edu.iuh.fit.convert.ServicePriceDTO" %><%--
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
    <title>Danh sách dịch vụ có giá rẻ nhất</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Danh sách dịch vụ có giá rẻ nhất</h2>
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
            SvcPriceService svcPriceService=new SvcPriceService();
            List<ServicePriceDTO> services=svcPriceService.getCheapestPrice();
            //Phân trang
            int pageSize = 5; // Số công việc trên mỗi trang
            int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, services.size());
            List<ServicePriceDTO> svcOnPage = services.subList(startIndex, endIndex);
            for (ServicePriceDTO s:svcOnPage) {
                String status="";
                if(s.getStatus()==0){
                    status="STOPED";
                } else if (s.getStatus()==1) {
                    status="ACTIVE";
                } else if (s.getStatus()==2) {
                    status="TERMINATED";
                }

        %>
        <tr>
            <td><%=s.getSvcName()%></td>
            <td><%=s.getDes()%></td>
            <td><%=status%></td>
            <td><%=s.getPrice()%></td>
            <td>
                <a href="serviceControl?action=update&svcID=<%=s.getSvcID()%>" class="btn btn-warning">Sửa</a>
                <a href="serviceControl?action=delete&svcID=<%=s.getSvcID()%>" class="btn btn-danger">Xóa</a>
                <a href="serviceControl?action=active&svcID=<%=s.getSvcID()%>" class="btn btn-info">Active</a>
                <a href="invoiceControl?action=addInvoice&svcID=<%=s.getSvcID()%>" class="btn btn-success">Đặt lịch</a>
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
            <a class="page-link" href="cheapest-service.jsp?page=<%= i %>"><%= i %></a>
        </li>
        <%
            }
        %>
    </ul>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
