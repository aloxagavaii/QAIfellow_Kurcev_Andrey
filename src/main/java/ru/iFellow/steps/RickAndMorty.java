package ru.iFellow.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Tag;
import ru.iFellow.api.RequestApi;
import ru.iFellow.pojoClasses.Character;
import org.junit.Assert;
import ru.iFellow.util.CommonProperties;

import java.io.IOException;
import java.util.List;

public class RickAndMorty {
    private final static RequestApi requestApi = new RequestApi();
    List<Character> morty;
    List<String> episodes;
    Character lastCharacter;

  @Если("получить информацию о Морти Смит и выбрать из ответа последний эпизод, где он появлялся")
  public void getMortyEpisodes() throws IOException {
      morty = requestApi.getRequest(CommonProperties.getProperty("mortyUrl"))
              .statusCode(Integer.parseInt(CommonProperties.getProperty("rickStatusCode")))
              .extract().body().jsonPath().getList("results", Character.class);
  }

  @И("получить из списка последнего эпизода последнего персонажа")
  public void getListEpisodes() throws IOException {
      episodes = requestApi.getRequest(morty.get(0).getEpisode().get("episode".length() - 1))
              .statusCode(Integer.parseInt(CommonProperties.getProperty("rickStatusCode")))
              .extract().body().jsonPath().getList("characters");
  }

  @И("получить данные по местонахождению и расе этого персонажа")
  public void getLastCharacter() throws IOException {
      lastCharacter = requestApi.getRequest(episodes.get(episodes.size() - 1))
              .statusCode(Integer.parseInt(CommonProperties.getProperty("rickStatusCode")))
              .extract().body().as(Character.class);
  }

  @Тогда("сравнить Морти и персонажа")
  public void asserts() {
      Assert.assertNotEquals(lastCharacter.getLocation().getName(), morty.get(0).getLocation().getName());
      Assert.assertEquals(lastCharacter.getSpecies(), morty.get(0).getSpecies());
  }
}
