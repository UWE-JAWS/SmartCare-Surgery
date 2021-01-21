/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package Pages;

import com.sun.javafx.tk.Toolkit.Task;
import java.time.LocalTime;
import java.sql.Time; 

/**
 *
 * @author spitf
 */
public class staffTimeout extends Thread {
    staffTimeout thread1 = new staffTimeout();
    
    Time startTime;
    public void startTimer() {
        thread1.start();
        try {
            thread1.sleep((300));   // 5 min sleep
            thread1.interrupt();
        } catch (InterruptedException e) {
            // We've been interrupted: no more messages.
            return;
        }
    }
}
