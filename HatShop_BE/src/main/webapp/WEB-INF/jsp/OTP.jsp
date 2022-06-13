<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/22/2022
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP</title>
</head>
<body>

<div class="container-form">
    <form  method="post" novalidate action="/sendOTP">
            <h1 class="display-5 mb-5">Nhập mã OTP</h1>
            <div class="alert alert-success toast-success" role="alert">
                Mã OTP gửi lại thành công
            </div>
            <div class="alert  alert-warning toast-danger" role="alert">
                Vui lòng đợi hết 2 phút để gửi lại mã
            </div>
            <c:if test="${timeCode==false}">
                <div class="alert alert-danger" role="alert">
                    Mã OTP đã quá hạn
                </div>
            </c:if>
            <c:if test="${code==false}">
                <div class="alert alert-danger" role="alert">
                    Mã OTP không chính xác
                </div>
            </c:if>
            <p class="lead text-center">
                Mã OTP đã được gửi về email <br/>
                ${email}
            </p>
            <div class="mb-4">
                <label for="otp" class="form-label">Mã OTP*</label>
                <input type="text" class="form-control input-otp" id="otp" required placeholder="Mã OTP" name="otp">
                <input name ="email" value="${email}" type="hidden"/>
                <input name ="pass" value="${pass}" type="hidden"/>
            </div>
            <div class="col-12  spiner-reset">
                <button type="submit">Hoàn tất</button>
                <a href="/resetOTP?email=${email}" class="link-dark d-inline-block ms-4 btn-reset-otp">Gửi lại mã</a>
            </div>
        </div>

    </form>
</div>

</body>
</html>