<%-- 
    Document   : patientDashboard
    Created on : 16-Dec-2020, 19:05:38
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartCare | Patient Dashboard</title>
    </head>
    <body>
        <h1>Patient Dashboard</h1>
        <!--TODO: Replace placeholder with username once sessions are implemented-->
        <p>Welcome, <em>User Name</em></p>
        <p>What would you like to do today?</p>
        <!-- TODO: Change lazy way of making button links into proper <a> links -->
        <form method="POST" action="PatientDashboard.do">
                <div class="box content">
                    View a table <br />
                    <input type="radio" name="tbl" value="Book">Book an Appointment<br/>
                    <input type="radio" name="tbl" value="Prescription">Request a Repeat Prescription<br/>
                    <input type="radio" name="tbl" value="Fees">Pay Fees<br/>
                    <input type=submit value="Action"> <br /><div class="content a">
                        </form>
                    </div>
        <form action="/SmartCare-Surgery/index.jsp">
            <input type="submit" value="Log Out"/>
        </form>
    </body>
</html>
