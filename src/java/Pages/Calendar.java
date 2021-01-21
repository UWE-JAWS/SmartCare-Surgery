/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package Pages;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.Date;
import java.sql.Time; 

/**
 *
 * @author spitf
 */

public class Calendar {
    public void addNewAppointment(string username, string role, Date appointmentDate) {
        // Adds a new appointment
    }
    
    public void startAppointment(int ID, Time currTime) {
        // Starts an appointment
    }
    
    public void endAppointment(int ID, Time currTime) {
        // Ends an appointment
    }
    
    public void removeAppointment(int ID) {
        // Removes the database entry with ID as its ID
    }
    
    public Appointment[] getClientAppointment(string username) {
        Appointment [] appointmentList = new Appointment[64];
        // Pull all appointments that don't have an end time and have the username associated with it.
        return appointmentList;
    }
    
    public Appointment[] getStaffAppointment() {
        Appointment [] appointmentList = new Appointment[64];
        // Pull all appointments.
        return appointmentList;
    }
}