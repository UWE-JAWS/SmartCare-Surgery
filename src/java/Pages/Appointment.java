/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package Pages;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author spitf
 */
public class Appointment {
    public int ID;
    public int userID;
    public Date appointmentDate;
    public Time startTime;
    public Time endTime;
    public int slot;
}
