<%-- 
    Document   : driver
    Created on : 01-Nov-2015, 15:18:08
    Author     : me-aydin
--%>

<%@page import="model.Jdbc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Main Page</title>
    </head>
    <body>
        <h2>User's details:</h2>
        <%! int i=0;
            String str=""; 
            String url = "";
        %>
        <%
            if((String)request.getAttribute("msg")=="new") {
                str="Register";
                url = "NewUser.do";
            }
            else if((String)request.getAttribute("msg")=="login") {
                str="Login";
                url = "Login.do";
            } 
        %>
        <form method="POST" action="<%=url%>">     
            <table>
                <tr>
                    <th></th>
                    <th>Please provide your following details, Ignore role if logging in</th>
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
                    <td>Role:</td>
                    <td><input type="text" name="job"/></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="<%=str%>"/></td>
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
        <jsp:include page="foot.jsp"/>
    </body>
</html>