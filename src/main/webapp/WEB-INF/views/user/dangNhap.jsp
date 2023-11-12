<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhà Sản Xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<form action="/user/home" method="post">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center" style="color: red">Đăng Nhập</div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="username">Tên đăng nhập:</label>
                            <input type="text" class="form-control" name="ma" placeholder="Nhập tên đăng nhập">
                        </div>
                        <div class="form-group">
                            <label for="password">Mật khẩu:</label>
                            <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu">
                        </div>
                        <button type="submit" class="btn btn-primary">Đăng Nhập</button>
                        <br>
                        <p class="text-center" style="color: blue">${tb}</p>

                        <a href="/dang-ki">Đăng Kí</a>

                    </form>
                    <div class="dbtn"><a class="btn" href="/GoogleLoginServlet">Login With Google</a>

                    </div>
            </div>
        </div>
    </div>
</div>

</form>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>