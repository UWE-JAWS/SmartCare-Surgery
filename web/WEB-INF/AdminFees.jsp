<%@page import="com.Fees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1 id="textid">Administrator Fees</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Patient ID</th>
                <th>Transaction Amount</th>
                <th>Transaction Date</th>
            </tr>             
            <% 
                for (Fees fee : (ArrayList<Fees>)request.getAttribute("fees")) {
                    out.println("<tr>");
                    out.println("<td>" + fee.getID() + "</td>");
                    out.println("<td>" + fee.getPatientID() + "</td>");
                    out.println("<td>" + fee.getTransactionAmount() + "</td>");
                    out.println("<td>" + fee.getTransactionDate() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
