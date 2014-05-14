Cheat sheet for Hands on Coding Experience
============================

For Part 1:
Here is the code you need for TestServiceConsumer.java
            
For the findBestRestaurant method:
    // Write your code here to choose the best restaurant by setting winningRestaurant to your choice
    if (itemContent.length() >= winningRestaurant.length()) {
      winningRestaurant = itemContent;
    }

For the postBestRestaurant method:
    // Write your code here to set the feed type and content just like you did with swagger. The best restaurant is passed as a parameter
    // Hint: JSONObject is just like a dictionary. You can do feedItem.put("fieldName","fieldValue")
    // Hint: The two fields you set for a feed note from the swagger documentation are feedType and content
    feedItem.put("feedType", "Note");
    feedItem.put("content", "Let's meet at "+bestRestaurant);

