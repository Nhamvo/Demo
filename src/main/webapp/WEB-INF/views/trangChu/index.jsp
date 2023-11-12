<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhà Sản Xuất</title>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">--%>
    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">--%>
    <%--    <link rel="stylesheet" href="./index.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">--%>
    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">--%>
</head>
<body>

<header th:fragment="header">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                               data-bs-toggle="dropdown" aria-expanded="false">
                                                Danh Mục
                                            </a>
                                            <ul class="dropdown-menu" aria-labelledby="">
                                                <c:forEach var="c" items="${listDongSp}">
                                                    <li><a class="dropdown-item" href="/user/hien-thi-danh-muc?id=${c.id}">${c.ten}</a></li>

                                                </c:forEach>



                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                            </ul>
                                        </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/khach-hang/hien-thi">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Quản Lý
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="">
                            <li><a class="dropdown-item" href="/nhan-vien/hien-thi">Nhân Viên</a></li>
                            <li><a class="dropdown-item" href="/chuc-vu/hien-thi">Chức Vụ</a></li>
                            <li><a class="dropdown-item" href="/san-pham/hien-thi">Sản Phẩm</a></li>
                            <li><a class="dropdown-item" href="/nsx/hien-thi">Nhà Sản Xuất</a></li>
                            <li><a class="dropdown-item" href="/khach-hang/hien-thi">Khách Hàng</a></li>
                            <li><a class="dropdown-item" href="/dong-sp/hien-thi">Dòng SP</a></li>
                            <li><a class="dropdown-item" href="/cua-hang/hien-thi">Cửa Hàng</a></li>
                            <li><a class="dropdown-item" href="/chitiet-sp/hien-thi">Chi Tiết SP</a></li>
                            <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu Sắc</a></li>


                            <li>
                                <hr class="dropdown-divider">
                            </li>
                        </ul>
                    </li>

                </ul>
                <form class="d-flex">
                    <%--                    <p>Xin Chào : ${user}</p>--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>

                        <a href="/user/dang-xuat?ma=${user}">

                            <button class="btn btn-outline-success" type="submit">Đăng Xuất</button>
                        </a>




                </form>
            </div>
        </div>
    </nav>
</header>
<div><h1 class="text-center" style="color: blue">Danh Sách Các Sản Phẩm</h1></div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên SP</th>
        <th scope="col">Màu Sắc</th>
        <th scope="col">Mã Dòng SP</th>
        <th scope="col">Năm Bh</th>
        <th scope="col">Mã Màu Sắc</th>
        <th scope="col">Mã Màu Sắc</th>
        <th scope="col">Mã Màu Sắc</th>
        <th scope="col">Mã Màu Sắc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dongsp" items="${list}" varStatus="i">
<%--        <tr>--%>
<%--            <td>${dongsp.id}</td>--%>
<%--            <td>${dongsp.sanPham.ma}</td>--%>
<%--            <td>${dongsp.nsx.ma}</td>--%>
<%--            <td>${dongsp.mauSac.ma}</td>--%>
<%--            <td>${dongsp.dongSp.ma}</td>--%>
<%--            <td>${dongsp.namBh}</td>--%>
<%--            <td>${dongsp.moTa}</td>--%>
<%--            <td>${dongsp.soLuongTon}</td>--%>
<%--            <td>${dongsp.giaNhap}</td>--%>
<%--            <td>${dongsp.giaBan}</td>--%>



<%--        </tr>--%>
    </c:forEach>
    </tbody>
</table>

</body>



<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--</body>--%>
</html>