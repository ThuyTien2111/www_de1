<%@ page import="vn.edu.iuh.fit.service.AppointmentService" %>
<%@ page import="vn.edu.iuh.fit.entity.Service" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 26/10/2023
  Time: 6:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê số lượng booking của từng dịch vụ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thống kê số lượng booking của từng dịch vụ</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên dịch vụ</th>
            <th>Lượt booking</th>
        </tr>
        </thead>
        <tbody>
        <%
            AppointmentService appointmentService=new AppointmentService();
            Map<Service, Long> map=appointmentService.getNumberUsedOfService();
            for (Map.Entry<Service, Long> entry:map.entrySet()) {
        %>
        <tr>
            <td><%=entry.getKey().getSvcName()%></td>
            <td><%=entry.getValue()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
