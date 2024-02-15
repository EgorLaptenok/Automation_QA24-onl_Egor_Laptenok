package lesson17;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngUtils.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static propertyUtils.PropertyReader.getProperties;

@Listeners(Listener.class)
public class RequestTests {
    List<Map> userList = new ArrayList<>();

    @BeforeTest
    public void precondition() {
        baseURI = getProperties().getProperty("url");
    }

    @Test(priority = 1)
    public void listUsersTest() {
        Response response = given().basePath("/users").param("page", "2").get();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body("page", equalTo(2));
    }

    @Test(priority = 2)
    public void singleUserTest() {
        Response response = given().basePath("/users/2").get();
        response.then().assertThat().statusCode(200);
        response
                .then()
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", containsString("img"));
    }

    @Test(priority = 3)
    public void singleUserNotFoundTest() {
        Response response = given().basePath("/users/23").get();
        response.then().assertThat().statusCode(404);
    }

    @Test(priority = 4)
    public void listResourceTest() {
        Response response = given().basePath("/unknown").get();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("page", equalTo(1));
        userList = response.jsonPath().getList("data", Map.class);
    }

    @Test(priority = 5)
    public void singleResourceTest() {
        Response response = given().basePath("/unknown/" + userList.get(1).get("id")).get();
        response.then().assertThat().statusCode(200);
        response
                .then()
                .assertThat()
                .body("data.id", equalTo(userList.get(1).get("id")))
                .body("data.name", equalTo(userList.get(1).get("name")))
                .body("data.year", equalTo(userList.get(1).get("year")))
                .body("data.pantone_value", equalTo(userList.get(1).get("pantone_value")));
        response.prettyPrint();
    }

    @Test(priority = 6)
    public void postTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{" +
                        " \"name\": \"morpheus\"," +
                        " \"job\": \"leader\" " +
                        "}")
                .when()
                .post("/users")
                .then().assertThat().statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

    @Test(priority = 7)
    public void updatePutTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{" +
                        " \"name\": \"tester\"," +
                        " \"job\": \"qa\" " +
                        "}")
                .when()
                .put("/users/2")
                .then().assertThat()
                .statusCode(200)
                .body("name", equalTo("tester"))
                .body("job", equalTo("qa"));
    }

    @Test(priority = 8)
    public void updatePatchTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"job\": \"aqa\" }")
                .when()
                .patch("/users/2")
                .then().assertThat()
                .statusCode(200)
                .body("job", equalTo("aqa"));
    }

    @Test(priority = 9)
    public void deleteTest() {
        Response response = given().basePath("/users/2").delete();
        response.then().assertThat().statusCode(204);
    }

    @Test(priority = 10)
    public void headTest() {
        Response response = given().basePath("/users").head();
        response.then().assertThat().statusCode(200);
    }
}
