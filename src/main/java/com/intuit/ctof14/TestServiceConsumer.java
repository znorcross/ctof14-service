package com.intuit.ctof14;

import org.json.JSONArray;
import org.json.JSONObject;

import com.intuit.ctof14.Application;
import com.intuit.ctof14.TestServiceConsumer;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("testConsumer")
public class TestServiceConsumer
{
  final static String baseFeedUri = "https://activityfeed-prf.platform.intuit.com";
  
   @GET
   @Path("findBestRestaurant")
   @Produces("application/json")
   public Response findBestRestaurant()
   {
      HttpRequest request = null;
      try
      {
         // Setup request to gateway activity feed end point using the very handy 
         // Unirest library http://unirest.io/
         request =
            Unirest.get(TestServiceConsumer.baseFeedUri+"/v1/feeds")
              .header("accept", "application/json")
              .header("Authorization", Application.getAuthorizationHeader());

         // Make request to gateway
         HttpResponse<JsonNode> jsonResponse = request.asJson();
         JsonNode body = jsonResponse.getBody();

         // Get the array of feed elements
         JSONArray feed = body.getObject().getJSONArray("feed");
         
         String winningRestaurant = "";
         
         // Iterate through feed list finding best restaurant
         for (int index = 0; index < feed.length(); index++)
         {
            JSONObject item = feed.getJSONObject(index);
            String itemContent = item.has("content") ? item.getString("content") : "";
            if(itemContent.length() > winningRestaurant.length()) {
               winningRestaurant = itemContent;
            }
         }
         
         // Return winner
         JSONObject obj = new JSONObject();
         obj.put("result", winningRestaurant);
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
        // Create a new note feed item
        JSONObject feedItem = new JSONObject();
        feedItem.put("content", "A Better " + bestRestaurant);
        feedItem.put("feedType", "Note");
        
         // Setup request to gateway activity feed end point
         // Set the body of the request to the json object
         request =
            Unirest.post(TestServiceConsumer.baseFeedUri+"/v1/feed")
              .header("accept", "application/json")
              .header("Authorization", Application.getAuthorizationHeader())
              .header("Content-Type","application/json")
              .body(feedItem.toString());

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
