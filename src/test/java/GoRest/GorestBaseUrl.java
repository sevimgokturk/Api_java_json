package GoRest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GorestBaseUrl {

    protected RequestSpecification spec;
    @Before
    public void setUpBaseUrl(){
        spec=new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
    }
}


