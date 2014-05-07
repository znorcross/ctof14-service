package com.intuit.ctof14;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/order")
@Api(value="v1/order", description="Food orders for a restaurant")
public class OrderService
{
  @GET
  @ApiOperation(value="Get an Order of food")
  @Path("/{id}")
  public Response getOrder(@PathParam("id") String id) {
    try {
      InputStream stream = this.getClass().getResourceAsStream("/orders.json");
      StringWriter writer = new StringWriter();
      IOUtils.copy(stream, writer, "UTF-8");
      
      JSONObject orders = new JSONObject(writer.toString());
      
      return Response.ok(orders.get(id).toString(), MediaType.APPLICATION_JSON_TYPE).build();
    } catch (IOException ex) {
      return Response.status(500).build();      
    }
    
  }
}