package com.rtest.fixtures;

import com.rtest.product.ConflictingProgramException;
import com.rtest.product.Program;
import com.rtest.product.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProgramsToSchedule {
   static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy|h:mm");
   private int channel;
   private String date;
   private String startTime;
   private int minutes;
   private String programName;
   private String episodeName;
   private String lastId;
   private static int numberCreated = 0;
   private boolean lastCreationSuccessful;

   private static Schedule schedule = new Schedule();

   public AddProgramsToSchedule() {
      System.out.printf("Creating ProgramsToSchedule #%d\n", ++numberCreated);
   }

   public void setName(String name) {
      this.programName = name;
   }

    public static Schedule getSchedule() {
       return schedule;
    }

   public void setEpisode(String name) {
      this.episodeName = name;
   }

   public void setChannel(int channel) {
      this.channel = channel;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }

   public void setMinutes(int minutes) {
      this.minutes = minutes;
   }

   public void execute() {
      try {
         Program p = schedule.addProgram(programName, episodeName, channel,
               buildStartDateTime(), minutes);
         lastId = p.getId();
         lastCreationSuccessful = true;
      } catch (ConflictingProgramException e) {
         lastCreationSuccessful = false;
      }
   }

   public boolean created() {
      //execute();
      return lastCreationSuccessful;
   }

   public String lastId() {
      if (lastCreationSuccessful)
         return lastId;
      return "n/a";
   }

   private Date buildStartDateTime() {
      try {
         String dateTime = String.format("%s|%s", date, startTime);
         return dateFormat.parse(dateTime);
      } catch (ParseException e) {
         throw new RuntimeException("Unable to prase date/time", e);
      }
   }
}