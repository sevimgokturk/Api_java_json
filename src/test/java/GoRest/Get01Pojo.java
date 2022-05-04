package GoRest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get01Pojo extends GorestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                            {
                    "meta": null,
                    "data": {
                        "id": 13,
                        "name": "Archan Adiga II",
                        "email": "archan_adiga_ii@murray.org",
                        "gender": "male",
                        "status": "inactive"
                    }
                }

    */

    /*
        First !!!  Create BaseUrl Class
        To do that task do the followings;
        1)Check the response body on Postman
        2)Create Pojo Classes
                        1) create private variable for every keys
                        2) create constructor with all parameters without any parameters
                        3) create getters and setters
                        4) create toString() method
                        5) Add ==>  @JsonIgnoreProperties(ignoreUnknown = true)
        3)Follow the 4 steps in API automation
                        //1.Step: Set the URL
                        //2.Step: Set the Expected Data
                        //3.Step:Send POST Request and get the Response
                        //4.Step: Do Assertions
     */

    @Test
    public void get01 (){
        //1.Step: Set the URL
        spec.pathParams("first","users","second",13);

        //2.Step: Set the Expected Data
        GorestinnerPojo gorestinnerRequestPojo = new GorestinnerPojo(13,"Archan Adiga II","archan_adiga_ii@murray.org","male","inactive");
        GorestouterPojo gorestouterRequestPojo =new GorestouterPojo(null,gorestinnerRequestPojo);

        //3.Step:Send POST Request and get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        GorestouterPojo actualDataPojo = response.as(GorestouterPojo.class);

        //4.Step: Do Assertions
        assertEquals(200,response.getStatusCode());
        assertEquals(gorestinnerRequestPojo.getId(),actualDataPojo.getData().getId());
        assertEquals(gorestinnerRequestPojo.getName(),actualDataPojo.getData().getName());
        assertEquals(gorestinnerRequestPojo.getEmail(),actualDataPojo.getData().getEmail());
        assertEquals(gorestinnerRequestPojo.getGender(),actualDataPojo.getData().getGender());
        assertEquals(gorestinnerRequestPojo.getStatus(),actualDataPojo.getData().getStatus());
        assertEquals(gorestouterRequestPojo.getMeta(),actualDataPojo.getMeta());

    }
}
