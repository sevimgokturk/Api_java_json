package Jsonplaceholder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonplscrholderBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUpBaseUrl(){
        spec=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
