<%-- 
    Document   : employee
    Created on : 14-Dec-2020, 19:44:31
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Employee</title>
    </head>
    <body>
        <h1>Insert new employee details</h1>
        <%! int i=0;
            String str=""; 
            String url = "";
        %>
        <form method="POST" action="NewEmployee.do">     
            <table>
                <tr>
                    <th></th>
                    <th>Please provide your following details</th>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" id="date" name="DoB"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><input type="text" name="role"/></td>
                </tr>
                <tr> 
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>   
        <%
            if (i++>0 && request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
                i--;
            }
        %>
        </br>
        <jsp:include page="adminFoot.jsp"/>
    </body>
</html>
