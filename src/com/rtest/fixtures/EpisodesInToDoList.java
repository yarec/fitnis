package com.rtest.fixtures;

import com.om.query.QueryResultBuilder;
import com.om.query.domain.QueryResult;
import com.rtest.product.CreateSeasonPassFor;
import com.rtest.product.Program;
import com.rtest.product.TimeSlotPropertyHandler;

import java.util.List;

public class EpisodesInToDoList {
   private final String programId;

   public EpisodesInToDoList(String programId) {
      this.programId = programId;
   }

   public List<Object> query() {
      List<Program> programs = CreateSeasonPassFor.getSeasonPassManager().toDoListContentsFor(programId);
      QueryResultBuilder builder = new QueryResultBuilder(Program.class);
      builder.register("timeSlot", new TimeSlotPropertyHandler());
      QueryResult result = builder.build(programs);
      return result.render();
   }
}