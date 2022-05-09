package GoRest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get01Pojo extends GorestBaseUrl {

    @Test
    public void get01 (){
       
        spec.pathParams("first","users","second",13);

      
        GorestinnerPojo gorestinnerRequestPojo = new GorestinnerPojo(13,"Archan Adiga II","archan_adiga_ii@murray.org","male","inactive");
        GorestouterPojo gorestouterRequestPojo =new GorestouterPojo(null,gorestinnerRequestPojo);

        
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        GorestouterPojo actualDataPojo = response.as(GorestouterPojo.class);

        
        assertEquals(200,response.getStatusCode());
        assertEquals(gorestinnerRequestPojo.getId(),actualDataPojo.getData().getId());
        assertEquals(gorestinnerRequestPojo.getName(),actualDataPojo.getData().getName());
        assertEquals(gorestinnerRequestPojo.getEmail(),actualDataPojo.getData().getEmail());
        assertEquals(gorestinnerRequestPojo.getGender(),actualDataPojo.getData().getGender());
        assertEquals(gorestinnerRequestPojo.getStatus(),actualDataPojo.getData().getStatus());
        assertEquals(gorestouterRequestPojo.getMeta(),actualDataPojo.getMeta());

    }
}
