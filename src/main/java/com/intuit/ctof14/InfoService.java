package com.intuit.ctof14;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1/info")
@Api(value="v1/info", description="Info API - this service stores and returns info")
public class InfoService
{
  @GET
  @Consumes("application/json")
  @ApiOperation(value="returns all info when no infoId is provided , else corressponding info for id provided")
  public Response getDeal(@QueryParam("infoId") String infoId) {
      try {
      InputStream stream = this.getClass().getResourceAsStream("/info.json");
      StringWriter writer = new StringWriter();
      IOUtils.copy(stream, writer, "UTF-8");
      
      JSONObject info = new JSONObject(writer.toString());
      
      String infoData = infoId != null ? info.get(infoId).toString() : info.toString();
      
      return Response.ok(infoData, MediaType.APPLICATION_JSON_TYPE).build();
    } catch (IOException ex) {
      return Response.status(500).build();      
    }

  }
}