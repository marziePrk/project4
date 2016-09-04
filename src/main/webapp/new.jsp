<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href=jspfile/cssfile/styleSheet.css rel=stylesheet>
    <title>پرونده تسهیلاتی</title>
</head>
<body>
<div class="title">
    <h1>پرونده تسهیلاتی</h1>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <form action="/LoanFileServlet">
                    <input type="text" name="action" value="search-realcustomer-and-loantype" hidden>
                    <table>
                        <tr>
                            <td>شماره مشتری</td>
                            <td><input type="text" name="customerId" value="<%=request.getAttribute("customerId")%>">
                            </td>
                            <td><input class="button" type="submit" value="بازیابی"></td>
                            <td><a href="../index.jsp" class="form">بازگشت به صفحه قبل</a></td>
                        </tr>
                    </table>
                </form>
                <br>
                <hr>
                <br>
                <form action="/LoanFileServlet">
                    <% int customerExists = (int) request.getAttribute("customerExists");%>
                    <% if (customerExists == 1) {%>
                    <input type="text" hidden name="action" value="create-loanfile">
                    <% RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer"); %>
                    <input type="text" hidden name="CustomerId" value="<%=request.getAttribute("customerId")%>">
                    <table>
                        <tr>
                            <td> نوع تسهیلات</td>
                            <td>
                                <%boolean loanTypeExists = (boolean) request.getAttribute("LoanTypeExists"); %>
                                <% if (loanTypeExists) { %>
                                <% List<LoanType> loanTypes = (List<LoanType>) request.getAttribute("loanTypes"); %>
                                <select class="my-dropdown" name="loanType">
                                    <% for (LoanType loanType : loanTypes) { %>
                                    <option value="<%= loanType.getLoanTypeId()%>"><%= loanType.getLoanTypeName()%>
                                    </option>
                                    <%}%>
                                </select>
                                <%} else {%>
                                <p>تسهیلاتی موجود نمی باشد.</p>
                                <%}%>
                            </td>
                        </tr>
                        <tr>
                            <td> نام مشتری :</td>
                            <td><%= realCustomer.getFirstName() %>
                            </td>
                        </tr>
                        <tr>
                            <td> نام خانوادگی مشتری :</td>
                            <td><%= realCustomer.getLastName() %>
                            </td>
                        </tr>
                        <tr>
                            <td> مدت قرارداد</td>
                            <td><input type="text" name="duration"></td>
                        </tr>
                        <tr>
                            <td>مبلغ قرارداد</td>
                            <td><input type="text" name="cost"></td>
                        </tr>
                    </table>
                    <input class="button" type="submit" value="ثبت">
                    <%} %>
                    <% if (customerExists == -1) { %>
                    <p> شماره مشتری را وارد نمایید</p>
                    <%}%>
                    <% if (customerExists == 0) {%>

                    <h2>خطا</h2>
                    <p>شماره مشتری یافت نشد</p>
                    <%} %>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>