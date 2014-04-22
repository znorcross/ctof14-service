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
   private final static String teamId = "team123";
   
   private final static String VCAP_APPLICATION = "VCAP_APPLICATION";

   public Application()
   {
      packages("com.wordnik.swagger.jersey.listing;com.intuit.ctof14");
      register(MoxyJsonFeature.class);
      register(JsonMoxyConfigurationContextResolver.class);
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
            new HttpGet("http://" + teamId + ".codenvy.ctof.intuit.com/update_url/" + getCodenvyAppRunUrl());
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