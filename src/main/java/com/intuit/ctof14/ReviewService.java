package com.intuit.ctof14;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.wordnik.swagger.annotations.Api;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1")
@Api(value="v1/review", description="Review API - this service stores and returns reviews and ratings")
public class ReviewService
{
  @Path("review/{id}")
  @GET
  @Produces("application/json")
  public Response review(@QueryParam("id") String id) {
    InputStream stream = this.getClass().getResourceAsStream("reviews.json");
    JSONTokener tokener = new JSONTokener(stream);
    JSONObject reviews = new JSONObject(tokener);
    
    return Response.ok(reviews.get(id)).build();
  }
  
  @Path("dailyRating")
  @GET
  @Produces("application/json")
  public double getDailyRating() {
    return 3.5;
  }
}