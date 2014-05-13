package com.intuit.ctof14;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.*; 
import com.twilio.sdk.*; 
import com.twilio.sdk.resource.factory.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import org.json.JSONObject;

@Path("v1/notification")
@Api(value="v1/notifications", description="This service will deliver a notification via SMS using Twilio")
public class NotificationService
{
  @POST
  @Path("/sendSms")
  @ApiOperation(value="send a notification",notes="sends via an SMS message")
  public String sendSms(String smsData)
  {
    JSONObject responseJson = new JSONObject();
    String recepientPhoneNumber = "";
    String messageContent = "";
    try{
      final String ACCOUNT_SID = "ACda0e7672a7c450e40fee82182142d6c3"; 
      final String AUTH_TOKEN = "e92c6abe6134b15dae90ca3fe9a689a0";
      
      JSONObject smsDataJson = new JSONObject(smsData);
      if(smsDataJson != null && 
          smsDataJson.getString("recepientPhoneNumber") != "" 
          && smsDataJson.getString("messageContent") != "")
      {
          recepientPhoneNumber = smsDataJson.getString("recepientPhoneNumber");
          messageContent = smsDataJson.getString("messageContent");
          
          TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
      	   // Build the parameters 
      	   List<NameValuePair> params = new ArrayList<NameValuePair>();
           params.add(new BasicNameValuePair("From", "+16173402858"));
           params.add(new BasicNameValuePair("To", recepientPhoneNumber));
           params.add(new BasicNameValuePair("Body", messageContent));
    
      	   MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
      	   Message message = messageFactory.create(params); 
      	   System.out.println(message.getSid());
        
          responseJson.put("success", "true");
      }
      else
      {
          responseJson.put("success", "false");
      }

      return responseJson.toString();  
    }
    catch(Exception e)
    {
      responseJson.put("success", "false");
    }
    return responseJson.toString();
  }
}