import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.CreateUserRequest;
import java.util.Arrays;
import java.util.UUID;
import static io.restassured.RestAssured.given;


public class RestTestSber {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("http://users.bugred.ru/tasks/rest")
                    .setBasePath("/createuser")
                    .setContentType(ContentType.JSON)
                    .build();


    @DataProvider(name = "data-provider")
    public Object[][] createUsers() {
        return new Object[][] { { createUser() }, { createUser() }, { createUser() } };
    }

    @Test(dataProvider = "data-provider", description = "Создание пользователя")
    @Step("Проверка создания пользователя")
    public void  testResponse(CreateUserRequest rq) {
        ValidatableResponse resp =  given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().filter(new AllureRestAssured()).log().all().post()
                .then().log().all();
                testRequest(resp,rq);
    }

    @Step("Проверка ответа пользователя")
    public void testRequest(ValidatableResponse resp, CreateUserRequest rq){
                resp
                .body("name", Matchers.equalTo(rq.getName()))
                .body("email", Matchers.equalTo(rq.getEmail()))
                .body("hobby", Matchers.equalTo(rq.getHobby()))
                .body("phone", Matchers.equalTo(rq.getPhone()))
                .body("inn", Matchers.blankOrNullString());
    }


    public String createUide(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String text = uuidAsString.replace('-', 'a');
        return text;
    }


    public CreateUserRequest createUser() {
        CreateUserRequest rq = new CreateUserRequest();
        rq.setName(createUide());
        String email = "r" + createUide() + "@mail.ru";
        rq.setEmail(email);
        rq.setHobby(createUide());
        rq.setPhone("333 22 11");
        rq.setCompanies(Arrays.asList(36, 37));
        rq.setTasks(Arrays.asList(12));
        return  rq;
    }

}
