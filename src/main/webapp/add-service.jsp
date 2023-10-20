<%--
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
    <title>Thêm kỹ năng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Thêm kỹ năng</h2>
    <form method="post" action="serviceControl?action=add">
        <div class="form-group">
            <label for="svcID">Mã dịch vụ:</label>
            <input type="text" class="form-control" id="svcID" name="svcID">
        </div>
        <div class="form-group">
            <label for="svcName">Tên dịch vụ:</label>
            <input type="text" class="form-control" id="svcName" name="svcName">
        </div>
        <div class="form-group">
            <label for="svcDes">Mô tả:</label>
            <input type="text" class="form-control" id="svcDes" name="svcDes">
        </div>
        <div class="form-group">
            <label for="svcStatus">Trạng thái</label>
            <select id="svcStatus" name="svcStatus" class="form-control">
                <option value="0">STOPED</option>
                <option value="2">TERMINATED</option>
                <option value="1">ACTIVE</option>
            </select>
        </div>
        <div class="form-group">
            <label for="svcPrice">Giá dịch vụ:</label>
            <input type="number" class="form-control" id="svcPrice" name="svcPrice">
        </div>
        <div class="form-group">
            <label for="svcNote">Ghi chú:</label>
            <input type="text" class="form-control" id="svcNote" name="svcNote">
        </div>
        <button type="submit" class="btn btn-success">Xác nhận thêm</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
