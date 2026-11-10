<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Java Web Demo</title>
</head>
<body>
    <h1>Demo Servlet + JSP + Tomcat 11</h1>

    <form action="${pageContext.request.contextPath}/hello"
          method="post">
        <label>Nhập tên:</label>
        <input type="text" name="name" required>
        <button type="submit">Gửi</button>
    </form>
</body>
</html>
