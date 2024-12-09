package ru.iFellow.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.iFellow.pojoClasses.pojoReqres.User;
import ru.iFellow.steps.ReqresSteps;
import ru.iFellow.steps.RickAndMorty;
import java.io.File;
import java.io.IOException;

public class Tests {
    private final RickAndMorty rickAndMorty = new RickAndMorty();
    private final ReqresSteps reqresSteps = new ReqresSteps();
    private final static String url = "https://rickandmortyapi.com/api";
    private final static int statusCode = 200;

    @Test
    @Order(1)
    @DisplayName("Рик и Морти")
    public void rickAndMortyTest() {
        rickAndMorty.rickAndMortySteps(url,statusCode);
    }

    @Test
    @Order(2)
    @DisplayName("создание пользователя на reqres")
    public void reqresTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/ru/iFellow/fileReqres/fileReqres.Json");
        User user = objectMapper.readValue(file, User.class);
        user.setName("Tomato");
        user.setJob("Eat maket");

        reqresSteps.createUser("https://reqres.in", user, 201);
    }
}
