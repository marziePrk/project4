<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <script>
        function validate() {
            var name=document.forms["myForm"]["loanTypeName"].value;
            var interestRate=document.forms["myForm"]["interestRate"].value;
            if (name==null || name=="")
            {
                alert(" پر کردن فیلد نام نوع تسهیلات الزامی است. ");
                return false;
            }
            if (interestRate==null || interestRate=="")
            {
                alert(" پر کردن فیلد نرخ سود الزامی است. ");
                return false;
            }
        }
    </script>
    <title>تعریف نوع تسهیلات</title>
</head>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <h1 style="color: saddlebrown">لطفا اطلاعات زیر را وارد نمایید:</h1>
    <br>
    <div class="tableBox">
        <form name="myForm" action="/CreateLoanTypeServlet"  method="post" onsubmit="return validate()">
            <table>
                <tr>
                    <td>نام نوع تسهیلات :</td>
                    <td><input name="loanTypeName" type="text" placeholder="نام نوع تسهیلات.."></td>
                </tr>
                <tr>
                    <td>نرخ سود :</td>
                    <td><input name="interestRate" type="text" placeholder="نرخ سود.."></td>
                </tr>

            </table>
            <input type="submit" class="button" value="ثبت اطلاعات" >
        </form>
    </div>
</div>
</body>
</html>