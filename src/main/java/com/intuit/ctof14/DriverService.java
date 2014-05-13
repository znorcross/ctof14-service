package com.intuit.ctof14;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1/drivers")
@Api(value="v1/drivers")
public class DriverService
{
  @GET
  @Path("/delivery")
  @Consumes("application/json")
  @ApiOperation(value="DeilverFood", notes="call this to dilver the food with the order id")
  public Response deliverFood(@QueryParam("orderId") String id) {
    // Deliver this order. Post back to feed in 30 seocnds.
    return Response.ok().build();
  }
}