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
        <form action="/SmartCare-Surgery/PatientDashboard/BookAppointment">
            <input type="submit" value="Book an Appointment"/>
        </form>
        <form action="/SmartCare-Surgery/PatientDashboard/ManagePrescription">
            <input type="submit" value="Request a Repeat Prescription"/>
        </form>
        <form action="/SmartCare-Surgery/Logout">
            <input type="submit" value="Log Out"/>
        </form>
    </body>
</html>
