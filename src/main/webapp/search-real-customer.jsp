<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <title>جستجوی مشتری حقیقی</title>
</head>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <h1 style="color: saddlebrown">لطفااطلاعات مشتری مورد نظر خود را در یکی از بخش های زیر وارد نمایید.</h1>
    <br>
    <div class="searchBox">
        <div class="searchBoxChild">
            <form  action="/SearchRealCustomerServlet" method="post">
                <br>
                <table  >
                    <tr>
                        <td> نام : </td>
                        <td><input name="firstName" type="text" placeholder="نام.."></td>
                    </tr>
                    <tr>
                        <td>نام خانوادگی :</td>
                        <td><input name="lastName" type="text" placeholder="نام خانوادگی.."></td>
                    </tr>
                    <tr>
                        <td>شماره ملی:</td>
                        <td><input name="nationalCode" type="text" placeholder="شماره ملی.."></td>
                    </tr>

                </table>
                <input type="submit" class="button" value="جستجو ">

            </form>
        </div>
        <div class="searchBoxChild">
            <form  action="/SearchRealCustomerServlet" method="post">
                <br>
                <table >
                    <tr>
                        <td>شماره مشتری:</td>
                        <td><input name="customerNumber" type="text" placeholder="شماره مشتری.."></td>
                    </tr>
                </table>
                <br>
                <br>
                <input type="submit" class="button" value="جستجو ">
            </form>
        </div>
    </div>
</div>
<body/>