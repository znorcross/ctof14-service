package com.intuit.ctof14;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.RequestBodyEntity;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("testConsumer")
public class TestServiceConsumer
{
   @GET
   @Path("findBestRestaurant")
   @Produces("application/json")
   public Response findBestRestaurant()
   {
      HttpRequest request = null;
      try
      {
         // Setup request to gateway activity feed end point
         request =
            Unirest.get("https://activityfeed-prf.platform.intuit.com/v1/feeds")
              .header("accept", "application/json")
              .header("Authorization", Application.getAuthorizationHeader());

         // Make request to gateway
         HttpResponse<JsonNode> jsonResponse = request.asJson();
         JsonNode body = jsonResponse.getBody();

         // Get the array of feed elements
         JSONArray feed = body.getObject().getJSONArray("feed");
         
         // Search through finding the longest content
         String winningContent = "";
         for (int index = 0; index < feed.length(); index++)
         {
            JSONObject item = feed.getJSONObject(index);
            String itemContent = item.getString("content");
            if (!itemContent.startsWith("Let's meet at") && itemContent.length() >= winningContent.length())
            {
               winningContent = itemContent;
            }
         }
         
         // Return winner
         JSONObject obj = new JSONObject();
         obj.put("result", winningContent);
         return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();
      }
      catch (Throwable e)
      {
          return Response.status(500).build();
      }
   }
   
   @GET
   @Path("postBestRestaurant")
   @Produces("application/json")
   public Response postBestRestaurant(@QueryParam("bestRestaurant") String bestRestaurant)
   {
      RequestBodyEntity request = null;
      try
      {
        // Create a new note object
        JSONObject json = new JSONObject();
        json.put("feedType", "note");
        json.put("content", "Let's meet at "+bestRestaurant);
        
         // Setup request to gateway activity feed end point
         request =
            Unirest.post("https://activityfeed-prf.platform.intuit.com/v1/feed")
              .header("accept", "application/json")
              .header("Authorization", Application.getAuthorizationHeader())
              .header("Content-Type","application/json")
              .body(json.toString());

         // Make request to gateway
         HttpResponse<JsonNode> jsonResponse = request.asJson();
         JsonNode body = jsonResponse.getBody();

         // Return success
         JSONObject obj = new JSONObject();
         obj.put("result", "success");
         return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();
      }
      catch (Throwable e)
      {
          return Response.status(500).build();
      }
     
   }
}
