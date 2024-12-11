package ru.iFellow.api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi {
    public ValidatableResponse getRickAndMorty(String url) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then().log().all();
    }
}
