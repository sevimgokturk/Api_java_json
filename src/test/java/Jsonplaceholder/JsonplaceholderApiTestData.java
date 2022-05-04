package Jsonplaceholder;

import java.util.HashMap;
import java.util.Map;

public class JsonplaceholderApiTestData {

    public Map<String,Object> expectedDataWithAllKeys(Integer userId, String title, Boolean completed  ){
        Map<String ,Object> exceptedData = new HashMap<>();
        exceptedData.put("userId",userId);
        exceptedData.put("title",title);
        exceptedData.put("completed",completed);
        return exceptedData;
    }

    public String expectedDataInString(Integer userId, String title, Boolean completed ){
        String exceptedData ="{" + "\"userId\":" + userId + "," + "\"title\":" + "\"" + title + "\"" + "," + "\"completed\":" + completed + "}";
        return exceptedData;
    }



}
