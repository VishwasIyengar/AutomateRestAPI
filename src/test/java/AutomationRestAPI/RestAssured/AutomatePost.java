package AutomationRestAPI.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AutomatePost
{
	 
	@Test
    public void test_POSTRegSuccess() {
		
        // Create JSON request body
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");

       System.out.println("Request Body: " + request.toJSONString());

        // Set base URI
        baseURI = "https://reqres.in";

        // Perform POST request and validate response
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
            .post("/api/register")
        .then()
            .assertThat()
            .statusCode(200);
    }


@Test
public void test_POSTRegUnsuccess()
{
JSONObject request = new JSONObject();

request.put("email", "sydney@fife");
// request.put("password", "pistol");

System.out.println(request.toJSONString());

baseURI = "https://reqres.in";

given()
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(request.toJSONString()).
when().
post("/api/register").
then().
assertThat().
statusCode(400);
}

@Test
public void test_POSTLoginSuccess()
{
JSONObject request = new JSONObject();

request.put("email", "eve.holt@reqres.in");
request.put("password", "pistol");

System.out.println(request.toJSONString());

baseURI = "https://reqres.in";

given()
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(request.toJSONString()).
when().
post("/api/login").
then().
assertThat().
statusCode(200);
}



@Test
public void test_POSTLoginUnSuccess()
{    
   JSONObject request = new JSONObject();
   request.put("email", "eve.holt@reqres.in");
   
   baseURI = "https://reqres.in/api";
   
   given()
       .contentType(ContentType.JSON)
       .accept(ContentType.JSON)
       .body(request.toJSONString()).
   when()
       .post("/login").
   then()
       .statusCode(400).log().all();
}
}

