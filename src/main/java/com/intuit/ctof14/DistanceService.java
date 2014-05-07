package com.intuit.ctof14;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.wordnik.swagger.annotations.Api;

@Path("v1/distance")
@Api(value="v1/distance")
public class DistanceService
{
  @GET
  @Produces("application/json")
  public double distance(@QueryParam("from") String from, @QueryParam("to") String to) {
    return 3.5;
  }
  
}