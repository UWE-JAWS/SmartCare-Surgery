<%-- 
    Document   : bookAppointment
    Created on : 16-Dec-2020, 20:32:01
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartCare | Book Appointments</title>
    </head>
    <body>
        <h2>Password change</h2>
           <form method="POST" action="BookAppointment.do">     
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
                    <td>Doctor/Nurse Name:</td>
                    <td><select name="docName" id="docName">
                    <option value="dbeat">Dr Beat</option>
                    <option value="fnightingale">Florence Nightingale</option></select></td>
                </tr>
                <tr>
                    <td>Date of Appointment:</td>
                    <td><input type="date" id="date" name="appDate"></td>
                </tr>
                <tr>
                    <td>Time of Appointment:</td>
                    <td><input type="time" id="time" name="appt"></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="submit"/></td>
                </tr>
            </table>
        </form>
        <%=((String)(request.getAttribute("msg"))!=null)?(String)(request.getAttribute("msg")):""%>
         <jsp:include page="foot.jsp"/>
    </body>
</html>
