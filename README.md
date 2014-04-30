CTOF Challenge Instructions
============================

Answers for Part 1b in TestServiceConsumer.java
            
    // Write your code here to choose the best restaurant by setting winningRestaurant to your choice
    if (itemContent.length() >= winningContent.length()) {
      winningRestaurant = itemContent;
    }

    // Write your code here to set the feed type and content just like you did with swagger. The best restaurant is passed as a parameter
    // Hint: JSONObject is just like a dictionary. You can do feedItem.put("fieldName","fieldValue")
    // Hint: The two fields you set for a feed note from the swagger documentation are feedType and content
    feedItem.put("feedType", "note");
    feedItem.put("content", "Let's meet at "+bestRestaurant);

