package com.intuit.ctof14;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("v1/news")
@Api(value="v1/news", description="News API - this service stores and returns news")
public class NewsService
{

  @GET
  @Consumes("application/json")
  @ApiOperation(value="returns all news when no newsId is provided , else corressponding news for id provided")
  public Response getDeal(@QueryParam("newsId") String newsId) {
      try {
      InputStream stream = this.getClass().getResourceAsStream("/news.json");
      StringWriter writer = new StringWriter();
      IOUtils.copy(stream, writer, "UTF-8");
      
      JSONObject info = new JSONObject(writer.toString());
      
      String newsData = newsId != null ? news.get(newsId).toString() : news.toString();
      
      return Response.ok(newsData, MediaType.APPLICATION_JSON_TYPE).build();
    } catch (IOException ex) {
      return Response.status(500).build();      
    }

  }
}