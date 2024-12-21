package ru.iFellow.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.api.RequestApi;
import ru.iFellow.pojoClasses.pojoReqres.User;
import ru.iFellow.util.CommonProperties;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresSteps {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("src/test/resources/fileReqres.Json");
    private final static RequestApi requestApi = new RequestApi();
    private User user;

    @Если("получить и изменить файл json")
    public void getFileUser() throws IOException {
        user = objectMapper.readValue(file, User.class);
        user.setName("Tomato");
        user.setJob("Eat maket");
    }

    @Тогда("передать его в запрос создания пользователя и проверить name, job")
    public void createUser() throws IOException {
        requestApi.postRequest(CommonProperties.getProperty("reqresUrl"), CommonProperties.getProperty("reqresPostUri"), user)
                .assertThat()
                .statusCode(Integer.parseInt(CommonProperties.getProperty("reqresStatusCode")))
                .and()
                .body("name", equalTo("Tomato"))
                .and()
                .body("job", equalTo("Eat maket"));
    }
}
