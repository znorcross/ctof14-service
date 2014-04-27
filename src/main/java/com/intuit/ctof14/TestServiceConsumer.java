package com.intuit.ctof14;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("testConsumer")
public class TestServiceConsumer
{
   @GET
   @Path("/{realmId}")
   @Produces("application/json")
   @Consumes("application/json")
   public Response getBestRestaurant(@PathParam("realmId") String realmId)
   {
      HttpRequest request = null;
      try
      {
         request =
            Unirest.get("https://activityfeed-prf.platform.intuit.com/v1/feeds")
              .header("accept", "application/json")
              .header("Authorization", Application.getAuthorizationHeader());
         HttpResponse<JsonNode> jsonResponse = request.asJson();
         JsonNode body = jsonResponse.getBody();
         JSONArray feed = body.getObject().getJSONArray("feed");
         String winningContent = "";
         for (int index = 0; index < feed.length(); index++)
         {
            JSONObject item = feed.getJSONObject(index);
            String itemContent = item.getString("content");
            if (itemContent.length() >= winningContent.length())
            {
               winningContent = itemContent;
            }
         }
         JSONObject obj = new JSONObject();
         obj.put("result", winningContent);
         return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();
      }
      catch (Throwable e)
      {
          return Response.status(500).build();
      }
   }
}
