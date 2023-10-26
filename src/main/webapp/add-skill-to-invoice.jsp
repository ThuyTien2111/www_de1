<%@ page import="vn.edu.iuh.fit.service.SvcService" %>
<%@ page import="vn.edu.iuh.fit.entity.Service" %>
<%@ page import="vn.edu.iuh.fit.service.SvcPriceService" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 26/10/2023
  Time: 2:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lịch</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Form đặt lịch</h2>
    <form method="post" action="invoiceControl?action=addInvoiceByAppt">
        <%
            long svcID= (long) request.getAttribute("svcID");
            long apptNo= (long) request.getAttribute("apptNo");
            SvcPriceService svcPriceService =new SvcPriceService();
            SvcService svcService=new SvcService();
            Service service=svcService.getServiceByID(svcID);
            Double price= svcPriceService.getPrice(svcID);
        %>
        <div class="form-group">
            <label for="svcID">Mã dịch vụ:</label>
            <input id="svcID" name="svcID" class="form-control" type="text" value="<%=svcID%>" readonly>
        </div>
        <div class="form-group">
            <label for="svcName">Tên dịch vụ:</label>
            <input id="svcName" name="svcName" class="form-control" type="text" value="<%=service.getSvcName()%>" readonly>
        </div>
        <div class="form-group">
            <label for="price">Giá dịch vụ:</label>
            <input id="price" name="price" class="form-control" type="text" value="<%=price%>" readonly>
        </div>
        <div class="form-group">
            <label for="apptNo">Mã hóa đơn:</label>
            <input id="apptNo" name="apptNo" class="form-control" type="number" value="<%=apptNo%>" readonly>
        </div>
        <div class="form-group">
            <label for="start">Bắt đầu lúc:</label>
            <input id="start" name="start" class="form-control" type="datetime-local">
        </div>
        <div class="form-group">
            <label for="end">Kết thúc lúc:</label>
            <input id="end" name="end" class="form-control" type="datetime-local">
        </div>
        <div class="form-group">
            <label for="payment">Phương thức thanh toán:</label>
            <select id="payment" name="payment" class="form-control" >
                <option value="1">COD</option>
                <option value="2">CREDIT CARD</option>
                <option value="3">DEBIT CARD</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Xác nhận đặt hẹn</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
