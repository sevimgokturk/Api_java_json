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
        //set the url
        spec.pathParams("first","todos","second",198);

        // set the requests
       /* String exceptedData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "}";

                */ // long way ===> do this step by using TestData
        JsonplaceholderApiTestData jsonplaceholderApiTestData = new JsonplaceholderApiTestData();
        String expectedData = jsonplaceholderApiTestData.expectedDataInString(10,"quis eius est sint explicabo", true);
        HashMap<String,Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        // get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();

        //do assertion
        HashMap<String,Object> actualDataMap= JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        //assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));

    }

    //2.Way with pojo
    @Test
    public void get02Pojo(){

        //set the url
        spec.pathParams("first","todos","second",198);

        // set the requests
        JsonplaceholderApiTestData jsonplaceholderApiTestData = new JsonplaceholderApiTestData();
        String expectedData = jsonplaceholderApiTestData.expectedDataInString(10,"quis eius est sint explicabo", true);
        JsonplaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonplaceHolderPojo.class);
        // get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //do assertion
        JsonplaceHolderPojo actualDataPojo= JsonUtil.convertJsonToJavaObject(response.asString(),JsonplaceHolderPojo.class);
        //assertEquals(expectedDataPojo.getId(),actualDataPojo.getId());
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());

    }
















}
