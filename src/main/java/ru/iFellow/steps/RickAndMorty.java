package ru.iFellow.steps;

import io.restassured.http.ContentType;
import ru.iFellow.pojoClasses.Character;
import static io.restassured.RestAssured.given;
import org.junit.Assert;
import java.util.List;

public class RickAndMorty {
  public void rickAndMortySteps(String url, int statusCode) {
      List<Character> morty = given()
              .when()
              .contentType(ContentType.JSON)
              .get(url+"/character/?name=Morty Smith")
              .then().log().all()
              .statusCode(statusCode)
              .extract().body().jsonPath().getList("results", Character.class);

      List<String> episodes = given()
              .when()
              .contentType(ContentType.JSON)
              .get(morty.get(0).getEpisode().get("episode".length()-1))
              .then().log().all()
              .statusCode(statusCode)
              .extract().body().jsonPath().getList("characters");

      Character lastCharacter = given()
              .when()
              .contentType(ContentType.JSON)
              .get(episodes.get(episodes.size()-1))
              .then().log().all()
              .statusCode(statusCode)
              .extract().body().as(Character.class);

      Assert.assertNotEquals(lastCharacter.getLocation().getName(), morty.get(0).getLocation().getName());
      Assert.assertEquals(lastCharacter.getSpecies(), morty.get(0).getSpecies());
  }
}
