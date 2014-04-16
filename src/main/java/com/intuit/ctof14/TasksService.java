package com.intuit.ctof14;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.wordnik.swagger.annotations.*;

@Path("v1/tasks")
@Api(value="v1/tasks", description="Tasks API")
public class TasksService
{
  @GET
  @Produces("application/json")
  @ApiOperation(value = "Get all tasks", notes = "More notes about this method", response = List.class)
  public List<TaskModel> get() {
    ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();
    TaskModel task = new TaskModel();
    task.setId("1");
    task.setName("one");
    tasks.add(task);
    return tasks;
  }

  @Path("{id}")
  @GET
  @Produces("application/json")
  public TaskModel getById(@QueryParam("id") int id) {
    return new TaskModel();
  }
  
  @PUT
  @Consumes("application/json")
  public void create(TaskModel task) {
  }
}