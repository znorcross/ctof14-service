CTOF Challenge Instructions
============================

Answers:
         for (int index = 0; index < feed.length(); index++)
         {
            JSONObject item = feed.getJSONObject(index);
            String itemContent = item.getString("content");
            if (!itemContent.startsWith("Let's meet at") && itemContent.length() >= winningContent.length())
            {
               winningContent = itemContent;
            }
         }

        JSONObject json = new JSONObject();
        json.put("feedType", "note");
        json.put("content", "Let's meet at "+bestRestaurant);

