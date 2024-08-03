package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

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
}
