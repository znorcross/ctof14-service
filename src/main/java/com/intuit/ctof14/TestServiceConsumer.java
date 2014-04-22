package com.intuit.ctof14;

import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("testConsumer")
public class TestServiceConsumer
{
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public Response insertNewFeedItem(String feedText) {
    JSONObject obj = new JSONObject();
    obj.put("result", "Feed text is"+feedText);
    return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();
  }
}
