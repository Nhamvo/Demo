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
        <div class="row">
            <form:form action="/chitiet-sp/save" method="POST" modelAttribute="chiTiet">
                <form:input path="id" class="form-control" readonly="true" type="hidden"/>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label"> Sản Phẩm</label>
                    <form:select path="sanPham">
                        <option value="${sp.id}">${sp.ten} </option>
                    </form:select>

                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Nsx</label>
                    <form:select path="nsx">
                        <c:forEach items="${listNsx}" var="c">
                            <option value="${c.id}" ${c.ma==chiTiet.nsx.ma ? 'selected':''} >${c.ma} </option>
                        </c:forEach>

                    </form:select>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Màu Sắc</label>
                    <form:select path="mauSac">
                        <c:forEach items="${listMauSac}" var="c">
                            <option value="${c.id}" ${c.ma==chiTiet.mauSac.ma ? 'selected':''} >${c.ma} </option>
                        </c:forEach>

                    </form:select>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Dòng SP</label>
                    <form:select path="dongSp">
                        <c:forEach items="${listDongSp}" var="c">
                            <option value="${c.id}" ${c.ma==chiTiet.dongSp.ma ? 'selected':''} >${c.ma} </option>
                        </c:forEach>

                    </form:select>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Năm BH</label>
                    <form:input path="namBh" class="form-control"/>
                    <form:errors path="namBh" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Mô tả</label>
                    <form:input path="moTa" class="form-control"/>
                    <form:errors path="moTa" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Số lượng tồn</label>
                    <form:input path="soLuongTon" class="form-control"/>
                    <form:errors path="soLuongTon" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Giá Nhập</label>
                    <form:input path="giaNhap" class="form-control"/>
                    <form:errors path="giaNhap" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Giá Bán</label>
                    <form:input path="giaBan" class="form-control"/>
                    <form:errors path="giaBan" cssStyle="color: red"/>
                </div>
                <div class="col-6 col-xs-6 col-mb-6">
                    <label class="form-label">Hình Ảnh :</label>
                    <form:input path="hinhAnh" type="file" id="imageFile" />
                </div>

                <form:button type="submit" class="btn btn-primary">Lưu</form:button>
            </form:form>
        </div>
    </div>


    <%--    <div class="row py-2">--%>
    <%--        <form class="d-flex" role="search" action="/chitiet-sp/search" method="get">--%>
    <%--            <input class="form-control me-2" name="ten" type="search" placeholder="Search Name Or Mã"--%>
    <%--                   aria-label="Search" value="${searchName}">--%>
    <%--            <button class="btn btn-outline-success" type="submit">Search</button>--%>
    <%--        </form>--%>
    <%--        <span style="color: red">${thongBao}</span>--%>
    <%--    </div>--%>
    <%--    <table class="table table-striped table-hover">--%>
    <%--        <thead>--%>
    <%--        <tr>--%>
    <%--            <th scope="col">ID</th>--%>
    <%--            <th scope="col">Mã SP</th>--%>
    <%--            <th scope="col">Mã Nsx</th>--%>
    <%--            <th scope="col">Mã Màu Sắc</th>--%>
    <%--            <th scope="col">Mã Dòng SP</th>--%>
    <%--            <th scope="col">Năm Bh</th>--%>
    <%--            <th scope="col">Mã Màu Sắc</th>--%>
    <%--            <th scope="col">Mã Màu Sắc</th>--%>
    <%--            <th scope="col">Mã Màu Sắc</th>--%>
    <%--            <th scope="col">Mã Màu Sắc</th>--%>
    <%--            <th scope="col">Action</th>--%>
    <%--        </tr>--%>
    <%--        </thead>--%>
    <%--        <tbody>--%>
    <%--        <c:forEach var="dongsp" items="${list}" varStatus="i">--%>
    <%--            <tr>--%>
    <%--                <td>${dongsp.id}</td>--%>
    <%--                <td>${dongsp.sanPham.ma}</td>--%>
    <%--                <td>${dongsp.nsx.ma}</td>--%>
    <%--                <td>${dongsp.mauSac.ma}</td>--%>
    <%--                <td>${dongsp.dongSp.ma}</td>--%>
    <%--                <td>${dongsp.namBh}</td>--%>
    <%--                <td>${dongsp.moTa}</td>--%>
    <%--                <td>${dongsp.soLuongTon}</td>--%>
    <%--                <td>${dongsp.giaNhap}</td>--%>
    <%--                <td>${dongsp.giaBan}</td>--%>


    <%--                <td><a href="/chitiet-sp/view-update?id=${dongsp.id}"--%>
    <%--                       class="btn btn-outline-warning"><i--%>
    <%--                        class="bi bi-pencil"></i> Edit</a></td>--%>
    <%--                <td><a href="/chitiet-sp/remove?id=${dongsp.id}"--%>
    <%--                       class="btn btn-outline-warning"><i--%>
    <%--                        class="bi bi-pencil"></i> Delete</a></td>--%>
    <%--            </tr>--%>
    <%--        </c:forEach>--%>
    <%--        </tbody>--%>
    <%--    </table>--%>
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