package com.intuit.ctof14;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Application extends ResourceConfig implements ServletContextListener
{
   public final static String TEAM_ID = "100";
   public final static String APP_ID = "Intuit.platform.qbodeveloper.testapp";
   public final static String APP_SECRET = "preprdvbgYUUxBx5SGqpPdOm3Iqhg38R6G7J75BO";
   
   private final static String VCAP_APPLICATION = "VCAP_APPLICATION";

   public Application()
   {
      packages("com.wordnik.swagger.jersey.listing;com.intuit.ctof14");
      register(MoxyJsonFeature.class);
      register(JsonMoxyConfigurationContextResolver.class);
   }
   
   public static String getAuthorizationHeader() {
     return "Intuit_IAM_Authentication intuit_userid=12345,intuit_realmid="+Application.TEAM_ID+",intuit_appid="+Application.APP_ID+",intuit_app_secret="+Application.APP_SECRET;
   }

   public static String getCodenvyAppRunUrl()
   {
      String appInstance = System.getenv(VCAP_APPLICATION);
      String appUrl = null;

      if (appInstance != null)
      {
         try
         {
            JSONObject appInstanceObj = new JSONObject(appInstance);
            appUrl = appInstanceObj.getJSONArray("uris").getString(0);
         }
         catch (JSONException ex)
         {

         }
      }

      return appUrl;

   }

   public static void updateProxyUrl()
   {
      try
      {
         HttpClient httpClient = new DefaultHttpClient();
         HttpGet httpGet =
            new HttpGet("http://team-" + Application.TEAM_ID + "-service.codenvy.ctof.intuit.com/update_url/" + getCodenvyAppRunUrl());
         httpClient.execute(httpGet);
      }
      catch (Exception ex)
      {
      }
   }

   public void contextInitialized(ServletContextEvent event)
   {
      Application.updateProxyUrl();
   }

   public void contextDestroyed(ServletContextEvent event)
   {
   }
}