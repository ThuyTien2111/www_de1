<%@ page import="vn.edu.iuh.fit.service.SvcService" %>
<%@ page import="vn.edu.iuh.fit.entity.Service" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 20/10/2023
  Time: 5:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa dịch vụ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Cập nhật thông tin dịch vụ</h2>
    <form method="post" action="serviceControl?action=update">
        <%
            Service service= (Service) request.getAttribute("service");
        %>
        <div class="form-group">
            <label for="svcID">Mã dịch vụ:</label>
            <input class="form-control" type="text" id="svcID" name="svcID" readonly value="<%=service.getSvcId()%>">
        </div>
        <div class="form-group">
            <label for="svcName">Tên dịch vụ:</label>
            <input class="form-control" type="text" id="svcName" name="svcName" value="<%=service.getSvcName()%>">
        </div>
        <div class="form-group">
            <label for="svcDes">Mô tả:</label>
            <input class="form-control" type="text" id="svcDes" name="svcDes" value="<%=service.getSvcDesc()%>">
        </div>
        <div class="form-group">
            <label for="svcStatus">Trạng thái:</label>
            <select class="form-control" id="svcStatus" name="svcStatus">
                <option value="0">STOPED</option>
                <option value="1">ACTIVE</option>
                <option value="2">TERMINATED</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Cập nhật xong</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
