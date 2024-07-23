package AutomationRestAPI.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples
{    
@Test
public void test_PUT()
{

JSONObject request = new JSONObject();

request.put("name", "Vishwas");
request.put("job", "Quality Engineer Trainee");

System.out.println(request.toJSONString());

baseURI = "https://reqres.in/api";

given().
body(request.toJSONString()).
when().
put("/users/2").
then().
statusCode(200).
log().
all();
}

@Test
public void test_Patch()
{

JSONObject request = new JSONObject();

request.put("name", "Vishwas");
request.put("job", "Quality Engineer Trainee");

System.out.println(request.toJSONString());

baseURI = "https://reqres.in";

given().
body(request.toJSONString()).
when().
patch("/api/users/2").
then().
statusCode(200).
log().
all();
}

@Test
public void test_Delete()
{



baseURI = "https://reqres.in";

given().

when().
delete("/api/users/2").
then().
statusCode(204).
log().
all();
}
 }

