<%@ page import="vn.edu.iuh.fit.service.SvcService" %>
<%@ page import="vn.edu.iuh.fit.service.InvoiceService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Invoice" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 26/10/2023
  Time: 2:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin chi tiết lịch hẹn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Danh sách dịch vụ đã đặt</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên dịch vụ</th>
            <th>Ngày lập hóa đơn</th>
            <th>Trạng thái hóa đơn</th>
        </tr>
        </thead>
        <tbody>
        <%
            long apptNo= (long) request.getAttribute("apptNo");
            InvoiceService invoiceService=new InvoiceService();
            List<Invoice> invoices=invoiceService.getInvoiceByApptNo(apptNo);
            for (Invoice invoice:invoices) {
                //xử lý ngày
                LocalDateTime invDate=invoice.getInvDate();
                String ivcDateStr=invDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String status="";
                if(invoice.getStatus()==0){
                 status="CANCELED";
                }else if(invoice.getStatus()==1){
                    status="UNPAID";
                }else if(invoice.getStatus()==2){
                    status="PAID";
                }
        %>
        <tr>
            <td><%=invoice.getService().getSvcName()%></td>
            <td><%=ivcDateStr%></td>
            <td><%=status%></td>
            <td>
                <a href="invoiceControl?action=paid&svcID=<%=invoice.getService().getSvcId()%>&apptNo=<%=apptNo%>" class="btn btn-success">Đã thanh toán</a>
                <a href="invoiceControl?action=cancel&svcID=<%=invoice.getService().getSvcId()%>&apptNo=<%=apptNo%>" class="btn btn-danger">Hủy</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <h2>Thông tin chi tiết</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Bắt đầu lúc</th>
            <th>Kết thúc lúc</th>
            <th>Hình thức thanh toán</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                int paymentID=invoices.get(0).getPaymentMethod();
                String pay="";
                if(paymentID==1){
                    pay="COD";
                }else if(paymentID==2){
                    pay="CREDIT CARD";
                }else if(paymentID==3){
                    pay="DEBIT CARD";
                }
            %>
            <td><%=invoices.get(0).getAppointment().getApptStart()%></td>
            <td><%=invoices.get(0).getAppointment().getApptEnd()%></td>
            <td><%=pay%></td>
        </tr>
        </tbody>
    </table>
    <%
        Double totalPrice=invoiceService.calcTotalPrice(apptNo);
    %>
    <h2>Thành tiền:  <%=totalPrice%>$</h2>
    <a href="invoiceControl?action=addSvcToAppt&apptNo=<%=apptNo%>" class="btn btn-lg btn-block btn-primary">Thêm dịch vụ vào lịch hẹn</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
