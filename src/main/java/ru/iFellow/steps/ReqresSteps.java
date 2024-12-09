package ru.iFellow.steps;

import ru.iFellow.pojoClasses.pojoReqres.User;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresSteps {
public void createUser(String url, User body, int statusCode) {
    given()
            .header("Content-type", "application/json")
            .baseUri(url)
            .body(body)
            .when()
            .post("api/users")
            .then().log().all()
            .assertThat()
            .statusCode(statusCode)
            .and()
            .body("name", equalTo("Tomato"))
            .and()
            .body("job", equalTo("Eat maket"));
}
}
