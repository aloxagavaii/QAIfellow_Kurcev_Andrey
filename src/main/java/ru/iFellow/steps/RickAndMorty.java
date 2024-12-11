package ru.iFellow.steps;

import ru.iFellow.api.RickAndMortyApi;
import ru.iFellow.pojoClasses.Character;
import org.junit.Assert;
import java.util.List;

public class RickAndMorty {
    private static final RickAndMortyApi rickAndMortyApi = new RickAndMortyApi();

  public List<Character> getMorty(String url, int statusCode) {
      return rickAndMortyApi.getRickAndMorty(url)
              .statusCode(statusCode)
              .extract().body().jsonPath().getList("results", Character.class);
  }

  public List<String> getListEpisodes(String url, int statusCode) {
      return rickAndMortyApi.getRickAndMorty(url)
              .statusCode(statusCode)
              .extract().body().jsonPath().getList("characters");
  }


  public Character getLastCharacter(String url, int statusCode) {
      return rickAndMortyApi.getRickAndMorty(url)
              .statusCode(statusCode)
              .extract().body().as(Character.class);
  }

  public void asserts(Character last, Character morty) {
      Assert.assertNotEquals(last.getLocation().getName(), morty.getLocation().getName());
      Assert.assertEquals(last.getSpecies(), morty.getSpecies());
  }
}
