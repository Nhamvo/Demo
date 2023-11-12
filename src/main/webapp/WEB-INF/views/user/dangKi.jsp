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
<form action="/user/add" method="post" >
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header text-center" style="color: red">Đăng Ký</div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label for="">UserName:</label>
                                <input type="text" class="form-control" name="ma" placeholder="Nhập UserName">
                            </div>
                            <div class="form-group">
                                <label for="">Password:</label>
                                <input type="password" class="form-control" name="matKhau" placeholder="Nhập Password">
                            </div>
                            <div class="form-group">
                                <label for="">Tên</label>
                                <input type="text" class="form-control" name="ten" placeholder="Nhập Tên">
                            </div>
                            <div class="form-group">
                                <label for="">Số điện thoại</label>
                                <input type="tel" class="form-control" name="sdt" placeholder="Nhập SDT">
                            </div>
                            <div><p class="text-center" style="color: blue">${tb}</p></div>


                            <button type="submit" class="btn btn-primary text-center">Đăng Ký</button><br>
                            <a href="/login" style="color: blue">Quay lại đăng nhập</a>
                        </form>
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