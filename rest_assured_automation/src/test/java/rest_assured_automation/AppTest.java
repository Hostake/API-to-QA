package rest_assured_automation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class AppTest 
{
    @Test 
    public void testing()
    {
        //https://api.spacexdata.com/v3/rockets
        RequestSpecification request = given()
            .baseUri("https://api.spacexdata.com")
            .basePath("/v3/rockets/falcon9");

        // Выполняем GET-запрос
        Response response = request.when().get();

        // Проверяем статус кода
        response.then().statusCode(200);

        // Читаем JSON-ответ
        String jsonResponse = response.getBody().asString();
        System.out.println(jsonResponse);
        
    }
}
