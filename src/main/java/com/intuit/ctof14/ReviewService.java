package com.intuit.ctof14;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.intuit.ctof14.ReviewService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/reviews")
@Api(value="v1/reviews", description="Review API - this service stores and returns reviews and ratings")
public class ReviewService
{
  @Path("/review/{id}")
  @GET
  @Produces("application/json")
  @ApiOperation(value = "Get a Review", notes = "More notes about this method")
  public Response review(@PathParam("id") String id) {
    try {
      InputStream stream = this.getClass().getResourceAsStream("/reviews.json");
      StringWriter writer = new StringWriter();
      IOUtils.copy(stream, writer, "UTF-8");
      
      JSONObject reviews = new JSONObject(writer.toString());
      
      return Response.ok(reviews.get(id).toString(), MediaType.APPLICATION_JSON_TYPE).build();
    } catch (IOException ex) {
      return Response.status(500).build();      
    }
  }
  
  @Path("/dailyRating")
  @GET
  @Produces("application/json")
  public double getDailyRating() {
    return 3.5;
  }
}