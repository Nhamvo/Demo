<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">


<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }

    header {
        background-color: #333;
        color: #fff;
        padding: 20px;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    h1 {
        font-size: 24px;
    }

    nav ul {
        list-style: none;
        display: flex;
    }

    nav li {
        margin-right: 20px;
    }

    nav a {
        text-decoration: none;
        color: #fff;
        font-weight: bold;
        transition: color 0.3s ease;
    }

    nav a:hover {
        color: #ff9800;
    }

    .header-icons {
        display: flex;
        align-items: center;
    }

    .search-box {
        display: flex;
        align-items: center;
        background-color: #555;
        padding: 5px;
        border-radius: 5px;

    }

    .search-box input {
        border: none;
        background-color: transparent;
        color: #fff;
        margin-right: 5px;
        width: 250px;
        height: 22px;
    }

    .search-box button {
        border: none;
        background-color: transparent;
        cursor: pointer;
    }

    .cart-icon {
        position: relative;
    }

    .cart-icon img {
        width: 30px;
        height: 30px;
    }

    .cart-count {
        position: absolute;
        top: -5px;
        right: -5px;
        background-color: #ff9800;
        color: #fff;
        font-size: 12px;
        padding: 3px 5px;
        border-radius: 50%;
    }
    .main{
        margin-top: 30px;
    }



    main {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }

    .product {
        border: 1px solid #ccc;
        margin: 10px;
        padding: 10px;
        max-width: 200px;
        text-align: center;
    }

    .product img {
        max-width: 100%;
    }



    .cart-overlay {
        background-color: rgba(0, 0, 0, 0.8);
        display: none;
        height: 100%;
        left: 0;
        position: fixed;
        top: 0;
        width: 100%;
    }

    .cart {
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        left: 50%;
        padding: 20px;
        position: fixed;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .cart h2 {
        border-bottom: 1px solid #ccc;
        padding-bottom: 10px;
        text-align: center;
    }

    .cart ul {
        list-style: none;
        padding: 0;
    }

    .cart li {
        border-bottom: 1px solid #ccc;
        padding: 10px 0;
    }

    .cart button {
        background-color: #333;
        border: none;
        color: #fff;
        cursor: pointer;
        margin-top: 20px;
        padding: 10px 20px;
    }

    /*/////////////*/


    .product {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
        background-color: #f7f7f7;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin: 10px;
        transition: transform 0.3s ease-in-out;
        position: relative;
        overflow: hidden;
    }

    .product img {
        max-width: 100%;
        height: auto;
        transition: transform 0.3s ease-in-out;
    }

    .product h3 {
        font-size: 18px;
        margin-top: 10px;
    }

    .product p {
        font-size: 14px;
        color: #777;
        margin-top: 5px;
    }

    .product button {
        margin-top: 10px;
        background-color: #ff9800;
        color: white;
        border: none;
        padding: 8px 16px;
        cursor: pointer;
    }

    .product button:hover {
        background-color: #f57c00;
    }

    /* Hiệu ứng hover cho ảnh */
    .product:hover img {
        transform: scale(1.1);
    }

    /* Hiệu ứng hiển thị nút giỏ hàng */
    .product .cart-btn {
        position: absolute;
        bottom: 10px;
        left: 50%;
        transform: translateX(-50%);
        opacity: 0;
        transition: opacity 0.3s ease-in-out;
    }

    .product img:hover .cart-btn {
        opacity: 1;
    }
    .product-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        max-width: 1000px; /* Điều chỉnh chiều rộng tối đa của hàng */
    }

    .product {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
        background-color: #f7f7f7;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin: 10px;
        transition: transform 0.3s ease-in-out;
        position: relative;
        overflow: hidden;
        width: calc(20% - 20px); /* Điều chỉnh chiều rộng của sản phẩm */
    }

    .main {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }

    .product {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
        background-color: #f7f7f7;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin: 10px;
        transition: transform 0.3s ease-in-out;
        position: relative;
        overflow: hidden;
        width: calc(20% - 20px); /* Điều chỉnh chiều rộng của sản phẩm */
        max-width: calc(20% - 20px); /* Điều chỉnh chiều rộng tối đa của sản phẩm */
    }

    /* Điều chỉnh margin giữa các sản phẩm */
    .product:nth-child(5n+1) {
        margin-left: 0;
    }

    .product:nth-child(5n) {
        margin-right: 0;
    }

    /* Hiệu ứng hover cho ảnh */
    .product img {
        max-width: 100%;
        height: auto;
        transition: transform 0.3s ease-in-out;
    }

    .product:hover img {
        transform: scale(1.1);
    }

    /* Hiệu ứng hiển thị nút giỏ hàng */
    .product .cart-btn {
        position: absolute;
        bottom: 10px;
        left: 50%;
        transform: translateX(-50%);
        opacity: 0;
        transition: opacity 0.3s ease-in-out;
    }
    header {
        background-color: #333;
        color: #fff;
        padding: 20px;
        position: fixed;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 2;
    }


</style>
    <script>
        function showSuccessMessage() {
            alert("Thanh toán thành công");
        }
    </script>

</head>
<body>

<header>
    <div class="container">
        <h1>NhamVoVn</h1>
        <div class="header-icons">
            <div class="search-box">
                <input type="text" placeholder="Tìm kiếm sản phẩm...">
            </div>
        </div>
        <nav>
            <ul>
                <li><a href="#">Trang chủ</a></li>
                <li><a href="#">Dịch vụ</a></li>
                <li><a href="#">Giới thiệu</a></li>
                <li><a href="#"> Hotline 0941099278</a></li>
            </ul>
        </nav>
<%--        <div class="cart-icon">--%>
<%--            <a href="ngocnguyen.vn"> <img src="${pageContext.request.contextPath}/views/image/pngegg.png"--%>
<%--                                          alt="Giỏ hàng"></a>--%>
<%--            <span class="cart-count">0</span>--%>
        </div>
    </div>
</header>
<div class="main">
    <main>
        <c:forEach var="o" items="${listSp.content}" >
            <div class="product" style="margin: 25px">
                <img src="${pageContext.request.contextPath}/static/image/${o.hinhAnh}" alt="Product">
                <h3>${o.sanPham.ten}</h3>
                <b style="color: red; font-size: 20px">${o.giaBan} đ</b>
                <!-- Sử dụng icon giỏ hàng của Font Awesome -->
                <button onclick="addToCart(1)">
                    <i class="fa fa-shopping-cart"></i> Add To Cart
                </button>
            </div>

        </c:forEach>


        <div class="cart-overlay" id="cart-overlay">
            <div class="cart">
                <h2>Giỏ hàng</h2>
                <ul id="cart-items">
                    <!-- Danh sách sản phẩm trong giỏ hàng sẽ hiển thị ở đây -->
                </ul>
                <button onclick="closeCart()">Đóng</button>
            </div>
        </div>

    </main>

    <nav aria-label="Page navigation">
        <ul class="pagination  justify-content-center">
            <c:forEach begin="0" end="${listSp.totalPages - 1}" varStatus="i">
                <li class="page-item ${i.index == list.number ? 'active' : ''}">
                    <a class="page-link" href= "/user/ban-hang?page=${i.index}&size=${listSp.size}">
                            ${i.index + 1}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>

    <%--        <div class="col-4 cart">--%>
    <%--            <div class="cart-icon">--%>
    <%--                <i class="fas fa-shopping-cart"></i>--%>
    <%--            </div>--%>

    <%--            <h2><i class="fas fa-shopping-cart"></i> Giỏ hàng</h2>--%>
    <%--            <table class="table">--%>
    <%--                <thead>--%>
    <%--                <tr>--%>
    <%--                    <th>Tên sản phẩm</th>--%>
    <%--                    <th>Giá</th>--%>
    <%--                    <th>Số lượng</th>--%>
    <%--                </tr>--%>
    <%--                </thead>--%>
    <%--                <tbody>--%>

    <%--                </tbody>--%>
    <%--            </table>--%>
    <%--            <a href="./thanhToan" class="btn btn-success" onclick="showSuccessMessage()"><i class="fas fa-check"></i>--%>
    <%--                Thanh toán</a>--%>
    <%--        </div>--%>
</div>
</div>
</body>
</html>
