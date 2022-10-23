/*ScheduleFactory.java
 * ScheduleFactory entity
 *Author : Hlombekazi Mbelu 209024666
 * Date 7 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Schedule;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class ScheduleFactory {

    public static Schedule createSchedule( LocalDateTime startTime, LocalDateTime endTime)
    {
        String sch = Helper.generateUUID();
        Schedule schedule= new Schedule.Builder()
                .setScheduleId(sch)
                .setVehicleId(sch)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .seUserId(sch)
                .build();

        return schedule;
    }

}

