package ru.iFellow.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.iFellow.pojoClasses.Character;
import ru.iFellow.steps.RickAndMorty;

import java.util.List;

public class RickAndMortyTest {
    private final RickAndMorty rickAndMorty = new RickAndMorty();
    private final static String url = "https://rickandmortyapi.com/api";
    private final static int statusCode = 200;

    @Test
    @Tag("1")
    @DisplayName("Рик и Морти")
    public void rickAndMortyTest() {
        List<Character> morty = rickAndMorty.getMorty(url+"/character/?name=Morty Smith",statusCode);
        List<String> episodes = rickAndMorty.getListEpisodes(morty.get(0).getEpisode().get("episode".length() - 1),statusCode);
        Character lastCharacter = rickAndMorty.getLastCharacter(episodes.get(episodes.size() - 1), statusCode);
        rickAndMorty.asserts(lastCharacter,morty.get(0));
    }
}
