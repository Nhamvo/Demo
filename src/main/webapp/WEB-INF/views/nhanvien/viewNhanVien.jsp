<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <form:form action="/nhan-vien/add" method="POST" modelAttribute="dongSp">
            <div class="row">
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Mã</label>
                    <form:input path="ma" class="form-control"/>
                    <form:errors path="ma" cssStyle="color: red"/>
                    <p style="color: red" class=""> ${tb}</p>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Tên Nhân Viên</label>
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
                    <label class="form-label">Giới Tính</label>
                    <form:radiobutton path="gioiTinh" value="true"  class="" checked="true"/>Nam
                    <form:radiobutton path="gioiTinh" value="false" class=""/>Nữ
                    <form:errors path="gioiTinh" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Ngày Sinh</label>
                    <form:input type="date" path="ngaySinh"  class="form-control"/>
                    <form:errors path="ngaySinh" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Địa Chỉ</label>
                    <form:input path="diaChi" class="form-control"/>
                    <form:errors path="diaChi" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">SDT</label>
                    <form:input path="sdt" class="form-control"/>
                    <form:errors path="sdt" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Mật Khẩu</label>
                    <form:input path="matKhau" class="form-control"/>
                    <form:errors path="matKhau" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">ID Cửa Hàng</label>
                    <form:select path="cuaHang">
                        <c:forEach items="${listCH}" var="c">
                         <option value="${c.id}">${c.ma}</option>
                        </c:forEach>
                    </form:select>

                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">ID Chức Vụ</label>
                    <form:select path="chucVu">
                        <c:forEach items="${listCV}" var="c">
                            <option value="${c.id}"  >${c.ten} </option>
                        </c:forEach>
                    </form:select>
                </div>

<%--                <form:select path="chucVu" class="form-select" >--%>
<%--                    <form:option value="" label="Chọn Chức Vụ"/>--%>
<%--                    <form:options items="${listCV}" itemValue="id" itemLabel="ten"/>--%>
<%--                </form:select>--%>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Trạng Thái</label>
                    <form:radiobutton  path="trangThai" selected="true" value="1"  class=""/>Hoạt Động
                    <form:radiobutton  path="trangThai" value="0" class=""/>Ngừng Hoạt Động
                    <form:errors path="trangThai" cssStyle="color: red"/>
                </div>

            </div>
                <form:button type="submit" class="btn btn-primary">Thêm</form:button>
                </form:form>


    </div>
    <div class="row py-2">
        <form class="d-flex" role="search" action="/nhan-vien/search" method="get">
            <input class="form-control me-2" name="ten" type="search" placeholder="Search Name Or Mã"
                   aria-label="Search" value="${searchName}">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <span style="color: red">${thongBao}</span>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Mã </th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Tên CH</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Trạng Thái</th>


            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dongsp" items="${list.content}" varStatus="i">
            <tr>
                <th scope="row">${i.index}</th>
                <td>${dongsp.id}</td>
                <td>${dongsp.ma}</td>
                <td>${dongsp.ten}</td>
                <td>${dongsp.ngaySinh}</td>
                <td>${dongsp.diaChi}</td>
                <td>${dongsp.sdt}</td>
                <td>${dongsp.cuaHang.ten}</td>
                <td>${dongsp.chucVu.ten}</td>
                <td>${dongsp.trangThai}</td>

                <td><a href="/nhan-vien/view-update?id=${dongsp.id}"
                       class="btn btn-outline-warning"><i
                        class="bi bi-pencil"></i> Edit</a></td>
                <td><a href="/nhan-vien/remove?id=${dongsp.id}"
                       class="btn btn-danger"><i
                        class="bi bi-pencil"></i> Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination  justify-content-center">
            <c:forEach begin="0" end="${list.totalPages - 1}" varStatus="i">
                <li class="page-item ${i.index == list.number ? 'active' : ''}">
                    <a class="page-link" href= "/nhan-vien/hien-thi?page=${i.index}&size=${listSp.size}">
                            ${i.index + 1}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
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