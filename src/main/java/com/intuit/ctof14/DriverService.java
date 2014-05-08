package com.intuit.ctof14;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1/drivers")
public class DriverService
{
  @Path("/delivery")
  @Consumes("application/json")
  public Response deliverFood(@QueryParam("orderId") String id) {
    // Deliver this order. Post back to feed in 30 seocnds.
    return Response.ok().build();
  }
}