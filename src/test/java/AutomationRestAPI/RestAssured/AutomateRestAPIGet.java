package AutomationRestAPI.RestAssured;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class AutomateRestAPIGet

{

@Test

public void test_GETListUser()

{

baseURI = "https://reqres.in/api";


given().

get("/users?page=2").

then().

statusCode(200).

body("data[1].first_name", equalTo("Lindsay")).

body("data.first_name", hasItems("Lindsay","Tobias")).and().

log().

all();

}


@Test

public void test_GETSingleUser()

{

baseURI = "https://reqres.in";


given().

get("/api/users/2").

then().

statusCode(200).

body("data.first_name", equalTo("Janet"));

}


@Test

public void test_GETSingleUserNotFound()

{

baseURI = "https://reqres.in";


given().

get("/users/23").

then().

statusCode(404);

}


@Test

public void test_GETListOfResources()

{

baseURI = "https://reqres.in";


given().

get("/api/unknown").

then().

statusCode(200).

body("data[0].name", equalTo("cerulean")).

log().

all();

}


@Test

public void test_GETSingleResource()

{

baseURI = "https://reqres.in";


given().

get("/api/unknown/2").

then().

statusCode(200).

body("data.name", equalTo("fuchsia rose")).

log().

all();

}


@Test

public void test_GETSingleResourceNotFound()

{

baseURI = "https://reqres.in";


given().

get("/api/unknown/23 ").

then().

statusCode(404);

}



@Test

public void test_GETDelayedResponse()

{

baseURI = "https://reqres.in";


given().

get("/api/users?delay=3").

then().

statusCode(200).

body("data[0].first_name", equalTo("George")).

log().

all();

}

}
