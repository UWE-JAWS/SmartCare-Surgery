<%-- 
    Document   : EmployeeAddress
    Created on : 15-Dec-2020, 18:29:25
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Address</title>
    </head>
    <body>
        <h2>Enter Employee Details</h2>
           <form method="POST" action="EmpAddress.do">     
            <table>
                <tr>
                    <th></th>
                    <th>Please provide your following details</th>
                </tr>
                <tr>
                    <td>Full Name:</td>
                    <td><input type="text" name="fullname"/></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address"/></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form>
        <%=((String)(request.getAttribute("msg"))!=null)?(String)(request.getAttribute("msg")):""%>
         <jsp:include page="adminFoot.jsp"/>
    </body>
</html>
