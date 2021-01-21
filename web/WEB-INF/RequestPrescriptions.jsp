<%-- 
    Document   : RequestPrescriptions
    Created on : 21-Jan-2021, 09:10:02
    Author     : wills
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Request Prescription</h1>
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
                    <option value="meaydin">Mehmet Aydin</option>
                    <option value="eaydin">Emin Aydin</option></select></td>
                </tr>
                <tr>
                    <td>Type of Prescription:</td>
                    <td><select type="Prescriptiontype" id="type">
                            <option value ="Repeat">Repeat</option>
                            <option value ="Inital">Inital</option>
                    </td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="submit"/></td>
                </tr>
            </table>
    </body>
</html>
