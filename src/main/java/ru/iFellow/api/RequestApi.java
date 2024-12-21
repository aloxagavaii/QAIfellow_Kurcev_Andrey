package ru.iFellow.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RequestApi {
    private static final AllureRestAssured allureFilter = new AllureRestAssured()
            .setRequestAttachmentName("Запрос")
            .setResponseAttachmentName("Ответ");

    public ValidatableResponse getRequest(String url) {
        return given()
                .filter(allureFilter)
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then().log().all();
    }

    public ValidatableResponse postRequest(String url, String uri, Object user) {
        return given()
                .filter(allureFilter)
                .header("Content-type", "application/json")
                .baseUri(url)
                .body(user)
                .when()
                .post(uri)
                .then().log().all();
    }
}
