<%-- 
    Document   : nurseDashboard
    Created on : 16-Dec-2020, 14:06:48
    Author     : wills
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/dashboardStyle.css">
        <link rel="shortcut icon" type="image/png" href="style/logo.png">
        <title>SmartCare-Surgery Nurse Dashboard</title>
    </head>
    <body>
    <div class="wrapper">
            <div class="box header">
                <h1>Welcome to Nurse Dashboard!</h1>
            </div>
            <div class="box content">
                <div class="content top">
                    <a href= "conErr.jsp">View Patient timetables</a>
                </div>
                <div class="content mid">
                    <h3>Prescription page</h3>
                </div>
                <div class="content bot">
                    <form action="index.jsp"><input type="submit" value="Logout"></form>
                </div>
            </div>
        </div>
    </body>
</html>
