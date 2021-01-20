<%-- 
    Document   : adminDashboard
    Created on : Dec 15, 2020, 10 AM
    Author     : Simeon Dobchev (18008594)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/dashboardStyle.css">
        <link rel="shortcut icon" type="image/png" href="style/logo.png">
        <title>SmartCare-Surgery Administrator Dashboard</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="box header">
                <h1>Welcome, Administrator!</h1>
            </div>
            <form method="POST" action="AdminService.do">
            <div class="box content">
                View a table <br />
            <input type="radio" name="tbl" value="Timetable">View Daily Patient Timetables<br/>
            <input type="radio" name="tbl" value="NewEmp">Create an employee<br/>
            <input type="radio" name="tbl" value="Records">Edit Employee Records<br/>
            <input type="radio" name="tbl" value="Patient">Edit Patient Records<br/>
            <input type="radio" name="tbl" value="Documents">Generate Weekly Documents<br/>
            <input type=submit value="Action"> <br /><div class="content a">
                
            </form> 
            <div class="content bot">
                        <form action="index.jsp"><input type="submit" value="Logout"></form>
                    </div>
                
            </div>
        </div>
    </body>
</html>
