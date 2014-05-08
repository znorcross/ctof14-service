package com.intuit.ctof14;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("v1/notification")
@Api(value="v1/notifications", description="This service will deliver a notification via SMS using Twilio")
public class NotificationService
{
  @POST
  @Consumes("application/json")
  public Response sendNotification(Notification message) {
    // Send message here
    return Response.ok().build();
  }
}