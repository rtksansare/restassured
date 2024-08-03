package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
public class NewTest {
    @Test
    public void firstTest(){
    RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
    RequestSpecification request = RestAssured.given(); 
    JSONObject requestParams = new JSONObject();
    requestParams.put("userName", "test_rest");
    requestParams.put("password", "Testrest@123"); 
    request.body(requestParams.toJSONString());
    Response response = request.put("/User"); 
    ResponseBody body = response.getBody();
    System.out.println(response.getStatusLine());
    System.out.println(body.asString());
    }

    @Test
    public void postMethodExample(){
        // RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = RestAssured.get("https://petstore.swagger.io/v2/store/inventory");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "GET request failed");
        // response.then().body("data.id", equalTo(2));
        // response.then().body("data.first_name", equalTo("Janet")); 
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void postMethod(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "23454");
        requestBody.put("petId", "456");
        requestBody.put("quantity", "20");
        requestBody.put("shipDate", "2024-08-03T17:45:12.027Z");
        requestBody.put("status", "placed");
        requestBody.put("complete", "true"); 

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toJSONString())
                .post("https://petstore.swagger.io/v2/store/order");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "POST request failed");
        // response.then().body("id", equalTo("[23454]"));
        System.out.println(response.getBody());
        response.then().body("petId", equalTo("[456] "));
        
    }
}
