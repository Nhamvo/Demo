<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <!-- Thêm favicon -->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Thêm thư viện Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">

    <!-- Thêm CSS tùy chỉnh -->
    <style>
        /* Màu sắc và hiệu ứng */
        body {
            background-color: #f8f9fa;
        }

        h1, .navbar-brand {
            color: #008080;
            text-shadow: 2px 2px 4px #000000;
        }

        .navbar {
            background-color: #f8f9fa;
        }

        .nav-link {
            color: #000000;
            transition: color 0.3s ease;
        }

        .nav-link:hover {
            color: #008080;
        }

        /* Hiệu ứng icon */
        .navbar-toggler-icon {
            background-image: url('path/to/icon.png');
            background-size: cover;
            width: 24px;
            height: 24px;
        }
    </style>

    <!-- Thêm thư viện Bootstrap và JavaScript -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1><i class="fas fa-store"></i>Xin Chào Cửa Hàng Sof3011</h1>
    <p>Xin Chào ${name}</p>
    <p>Email : ${email}</p>


    <br/>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/SU23B2_SOF3011_SD18105_war_exploded"><i class="fas fa-store"></i>Login</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/khach-hang/hien-thi">Quản Lý Khách Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/cua-hang/hien-thi">Quản Lý Cửa hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/san-pham/hien-thi">Quản Lý Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/mau-sac/hien-thi">Quản Lý Màu Sắc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/dong-sp/hien-thi">Quản Lý Dòng Sản Phẩm</a>
                    </li>
                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link" href="<%= request.getContextPath() %>/chiTiet-sp/index">Quản Lý Chi Tiết Sản Phẩm</a>--%>
                    <%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/chuc-vu/hien-thi">Quản Lý Chức vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/nhan-vien/hien-thi">Quản Lý Nhân Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/nsx/hien-thi">Quản Lý NSX</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>
