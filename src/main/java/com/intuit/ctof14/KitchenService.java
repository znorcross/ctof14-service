package com.intuit.ctof14;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1/kitchenOrder")
@Api(value="v1/kitchenOrder", description="gets the kitchen working")
public class KitchenService
{
  @POST
  @Consumes("application/json")
  @ApiOperation(value="prepares an order")
  public Response prepareOrder(@QueryParam("orderId") String orderId) {
    // Post back to feed one minute later
    return Response.ok().build();
  }
}