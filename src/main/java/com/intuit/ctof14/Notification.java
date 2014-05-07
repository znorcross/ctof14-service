package com.intuit.ctof14;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Notification for SMS messages")
public class Notification
{
   String recipient;
   String message;
   String sender;
   String subject;

   @ApiModelProperty(value = "the content of the text message")
   public String getMessage()
   {
      return message;
   }

   public void setMessage(String message)
   {
      this.message = message;
   }

   @ApiModelProperty(value = "the recipient")
   public String getRecipient()
   {
      return recipient;
   }

   public void setRecipient(String recipient)
   {
      this.recipient = recipient;
   }
   
   @ApiModelProperty(value="the sender")
   public String getSender()
   {
      return sender;
   }

   public void setSender(String sender)
   {
      this.sender = sender;
   }

   @ApiModelProperty(value="the subject")
   public String getSubject()
   {
      return subject;
   }

   public void setSubject(String subject)
   {
      this.subject = subject;
   }
}