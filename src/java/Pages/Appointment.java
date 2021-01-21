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
    int ID;
    string uName;
    string role;
    Date appointmentDate;
    Time startTime;
    Time endTime;
}
