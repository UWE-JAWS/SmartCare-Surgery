<%@page import="model.Fees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 id="textid">Patient Fees</h1>
        <%
            ArrayList<Fees> fees = (ArrayList<Fees>)request.getAttribute("fees");
        %>
            <table>
                <tr>
                    <th>Patient ID</th>
                    <th>Transaction Amount</th>
                    <th>Transaction Date</th>
                </tr>
                <% 
                    for (int i = 0; i < fees.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + fees.get(i).getPatientID() + "</td>");
                        out.println("<td>" + fees.get(i).getTransactionAmount() + "</td>");
                        out.println("<td>" + fees.get(i).getTransactionDate() + "</td>");
                        out.println("</tr>");
                    }
                %>
            </table>
    </body>
</html>