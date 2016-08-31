<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <title>مدیریت مشتری حقیقی</title>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <p><b>سامانه خدمات مشتریان</b></p>
        <h1 style="color: saddlebrown">لطفا نوع عملیات درخواستی را انتخاب نمایید:</h1>
        <br>

        <a href="create-real-customer.jsp" class="button">تعریف مشتری جدید</a>
        <a href="search-real-customer.jsp" class="button">جستجوی مشتری فعلی </a>
    <br>
    <br>
    <br>
        <a href="create-loan-type.jsp" class="button">تعریف نوع تسهیلات </a>
        <a href="CreateLoanFileServlet?action=firstCall" class="button">تشکیل پرونده تسهیلاتی </a>
</div>
</body>
</html>
