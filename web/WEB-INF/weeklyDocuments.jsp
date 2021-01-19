<%-- 
    Document   : weeklyDocuments
    Created on : 19-Jan-2021, 18:28:05
    Author     : Dylan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weekly Documents</title>
    </head>
    <body>
        <%! int i=0;
            String str=""; 
            String url = "";
        %>
        <h1>Enter the dates within you would like to generate documents for:</h1>
        <form method="POST" action="weeklyDocuments.do"> 
        <<table>
            <tr>
                    <td>Start Date:</td>
                    <td><input type="date" id="date" name="astartDate"></td>
                </tr>
                <tr>
                    <td>End Date:</td>
                    <td><input type="date" id="date" name="endDate"></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="submit"/></td>
                </tr>
        </table>
        <%
            if (i++>0 && request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
                i--;
            }
        %>
    </body>
</html>
