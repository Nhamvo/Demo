<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhà Sản Xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header/header.jsp"/>

<div class="container">

    <div class="row py-2">
        <div class="row py-2">
            <form:form action="/khach-hang/update" method="POST" modelAttribute="dongSp">
                <div class="row">
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Id</label>
                        <form:input path="id" class="form-control"/>
                        <form:errors path="id" cssStyle="color: red"/>
                        <p style="color: red" class=""> ${tb}</p>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Mã</label>
                        <form:input path="ma" class="form-control"/>
                        <form:errors path="ma" cssStyle="color: red"/>
                        <p style="color: red" class=""> ${tb}</p>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Tên Khách Hàng</label>
                        <form:input path="ten" class="form-control"/>
                        <form:errors path="ten" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Tên Đệm</label>
                        <form:input path="tenDem" class="form-control"/>
                        <form:errors path="tenDem" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Họ</label>
                        <form:input path="ho" class="form-control"/>
                        <form:errors path="ho" cssStyle="color: red"/>
                    </div>

                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Ngày Sinh</label>
                        <form:input type="date" path="ngaySinh"  class="form-control"/>
                        <form:errors path="ngaySinh" cssStyle="color: red"/>
                    </div>

                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">SDT</label>
                        <form:input path="sdt" class="form-control"/>
                        <form:errors path="sdt" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Địa Chỉ</label>
                        <form:input path="diaChi" class="form-control"/>
                        <form:errors path="diaChi" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Thành Phố</label>
                        <form:input path="thanhPho" class="form-control"/>
                        <form:errors path="thanhPho" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Quốc Gia</label>
                        <form:input path="quocGia" class="form-control"/>
                        <form:errors path="quocGia" cssStyle="color: red"/>
                    </div>
                    <div class="col-6 col-xs-6 col-mb-6">
                        <label class="form-label">Mật Khẩu</label>
                        <form:input path="matKhau" class="form-control"/>
                        <form:errors path="matKhau" cssStyle="color: red"/>
                    </div>

                </div>
                <form:button type="submit" class="btn btn-primary">Thêm</form:button>
            </form:form>


        </div>

    <%--    <a href="http://localhost:8080/StoreManager_war_exploded/" class="btn btn-primary"><i--%>
    <%--            class="bi bi-house-down-fill"></i> Home</a>--%>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>