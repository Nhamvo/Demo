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
        <form:form action="/cua-hang/add" method="POST" modelAttribute="dongSp">

                <div class="mb-6">
                    <label class="form-label">Mã</label>
                    <form:input path="ma" class="form-control"/>
                    <form:errors path="ma" cssStyle="color: red"/>
                </div>
                <div class="mb-6">
                    <label class="form-label">Tên CH</label>
                    <form:input path="ten" class="form-control"/>
                    <form:errors path="ten" cssStyle="color: red"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Địa Chỉ</label>
                    <form:input path="diaChi" class="form-control"/>
                    <form:errors path="diaChi" cssStyle="color: red"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Thành Phố</label>
                    <form:input path="thanhPho" class="form-control"/>
                    <form:errors path="thanhPho" cssStyle="color: red"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Quốc Gia</label>
                    <form:input path="quocGia" class="form-control"/>
                    <form:errors path="quocGia" cssStyle="color: red"/>
                </div>
                <form:button type="submit" class="btn btn-primary">Thêm</form:button>
                </form:form>


    </div>
    <div class="row py-2">
        <form class="d-flex" role="search" action="/cua-hang/search" method="get">
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
            <th scope="col">Tên CH</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>

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
                <td>${dongsp.diaChi}</td>
                <td>${dongsp.thanhPho}</td>
                <td>${dongsp.quocGia}</td>

                <td><a href="/cua-hang/view-update?id=${dongsp.id}"
                       class="btn btn-outline-warning"><i
                        class="bi bi-pencil"></i> Edit</a></td>
                <td><a href="/cua-hanga/remove?id=${dongsp.id}"
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
                    <a class="page-link" href= "/cua-hang/hien-thi?page=${i.index}&size=${listSp.size}">
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