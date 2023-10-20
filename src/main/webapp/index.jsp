<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Đăng nhập</h2>
    <form action="mainControl?action=login" method="post">
        <%
            String error= (String) request.getAttribute("err");
            if(error!=null){
        %>
        <div class="alert alert-danger"><%=error%></div>
        <%
            }
        %>
        <div class="form-group">
            <label for="user">Tên người dùng:</label>
            <input class="form-control" type="text" id="user" name="user">
        </div>
        <div class="form-group">
            <label for="pass">Mật khẩu:</label>
            <input class="form-control" type="password" id="pass" name="pass">
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>