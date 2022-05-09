package Jsonplaceholder;


import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get02ObjectMapper extends JsonplscrholderBaseUrl {
     /*
        Given
           https://jsonplaceholder.typicode.com/todos/198
        When
         I send GET Request to the URL
      Then
         Status code is 200
         And response body is like {
                               "userId": 10,
                               "id": 198,
                               "title": "quis eius est sint explicabo",
                               "completed": true
                             }
     */

    @Test
   public void get01ObjectMappper(){
       
        spec.pathParams("first","todos","second",198);

      
        JsonplaceholderApiTestData jsonplaceholderApiTestData = new JsonplaceholderApiTestData();
        String expectedData = jsonplaceholderApiTestData.expectedDataInString(10,"quis eius est sint explicabo", true);
        HashMap<String,Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        
        Response response = given().spec(spec).when().get("/{first}/{second}");
       
        HashMap<String,Object> actualDataMap= JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));

    }

    //2.Way with pojo
    @Test
    public void get02Pojo(){

        
        spec.pathParams("first","todos","second",198);

      
        JsonplaceholderApiTestData jsonplaceholderApiTestData = new JsonplaceholderApiTestData();
        String expectedData = jsonplaceholderApiTestData.expectedDataInString(10,"quis eius est sint explicabo", true);
        JsonplaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonplaceHolderPojo.class);
       
        Response response = given().spec(spec).when().get("/{first}/{second}");
       
        JsonplaceHolderPojo actualDataPojo= JsonUtil.convertJsonToJavaObject(response.asString(),JsonplaceHolderPojo.class);
       
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());

    }
















}
