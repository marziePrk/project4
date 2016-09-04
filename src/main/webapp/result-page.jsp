<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/1/2016
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <title><%=request.getAttribute("title")%></title>
</head>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <p><b><%=request.getAttribute("header")%></b></p>
    <br>
    <br>
    <a href="index.jsp" class="button">بازگشت به صفحه اول</a>

</div>
</body>
</html>
