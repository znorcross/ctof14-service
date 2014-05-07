package com.intuit.ctof14;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;

@Path("v1/drivers")
public class DriverService
{
  @Path("/delivery")
  @Consumes("application/json")
  public void deliverFood(String id) {
    // Deliver this order. Post back to feed in 30 seocnds.
  }
}