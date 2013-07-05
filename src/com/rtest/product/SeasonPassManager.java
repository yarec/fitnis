package com.rtest.product;

import java.util.Collections;
import java.util.List;
 
public class SeasonPassManager {
   private final Schedule schedule;
   private List<Program> toDoList = Collections.emptyList();
 
   public SeasonPassManager(Schedule schedule) {
      this.schedule = schedule;
   }
 
   public int sizeOfToDoList() {
      return toDoList.size();
   }

   public Iterable<?> toDoListIterator() {
      return toDoList;
   }
   public List<Program> toDoListContentsFor(String programId) {
      return toDoList;
   }

   public Program createNewSeasonPass(String programName, int channel) {
      List<Program> programsFound = schedule.findProgramsNamedOn(programName, channel);

      toDoList = programsFound;

      if (programsFound.size() > 0)
         return programsFound.get(0);
      return null;
   }
}