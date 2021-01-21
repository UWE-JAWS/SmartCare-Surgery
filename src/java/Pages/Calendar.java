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
    }
    
    public void startAppointment(int ID, Time currTime) {
    }
    
    public void endAppointment(int ID, Time currTime) {
    }
    
    public void removeAppointment(int ID) {
    }
    
    public Appointment[] getClientAppointment(string username) {
        Appointment [] appointmentList = new Appointment[64];
        //for
        return appointmentList;
    }
    
    public Appointment[] getStaffAppointment() {
        Appointment [] appointmentList = new Appointment[64];
        return appointmentList;
    }
}