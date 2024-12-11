package ru.iFellow.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.iFellow.pojoClasses.pojoReqres.User;
import ru.iFellow.steps.ReqresSteps;

import java.io.File;
import java.io.IOException;

public class ReqresTest {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    @Tag("1")
    @DisplayName("создание пользователя на reqres")
    public void reqresTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/fileReqres.Json");
        User user = objectMapper.readValue(file, User.class);
        user.setName("Tomato");
        user.setJob("Eat maket");

        reqresSteps.createUser("https://reqres.in", user, 201);
    }
}
