package com.intuit.ctof14;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("v1/email")
@Api(value="v1/email", description="email service")
public class EMailService
{
  @POST
  @Consumes("application/json")
  @ApiOperation(value="send e-mail")
  public void sendEMail(Notification email) {
    // send an e-mail using the ICN service
  }
}