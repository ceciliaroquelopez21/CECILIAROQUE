package pe.com.bcp.techcases.testautomation.api.actors;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiClient {

    private Response response;
    private static final String contentType = "application/json";

   /* @Step */
    public void searchPageBy(String url, int pageNumber) {
        SerenityRest.useRelaxedHTTPSValidation();
        Logger.getLogger(this.getClass().getName())
                .log(Level.INFO, "Page number >>> {0}", pageNumber);
        Serenity.setSessionVariable("expectedPage").to(pageNumber);
        /*
            1) Agregar lo necesario para ver en el log de la petición (request)
            2) Agregar el parametro de consulta segun el contrato del servicio
        */
        response = SerenityRest
                .given()
                .contentType(contentType)
                .pathParam("page", pageNumber)
                .when().log().all()
                .get(url);
    }

 /* @Step */
    public void validateStatusCode(int statusCode) {
        Logger.getLogger(this.getClass().getName())
                .log(Level.INFO, "Expected status code >>> {0}", statusCode);
        /*
            3) Agregar lo necesario para ver en el log de la respuesta (response)
        */
        response.then().log().all()
                .assertThat().statusCode(statusCode);
    }

  /* @Step */
    public void validatePageValue() {
        int expectedPage = Serenity.sessionVariableCalled("expectedPage");
        Logger.getLogger(this.getClass().getName())
                .log(Level.INFO, "Número de página esperada >>> {0}", expectedPage);
        /*
            4) Indicar el jsonPath necesario para obtener el valor de la respuesta
        */

        int currentPage = response.getBody().jsonPath().getInt("page");
        Logger.getLogger(this.getClass().getName())
                .log(Level.INFO, "Número de página en la respuesta >>> {0}", currentPage);

        Assertions.assertEquals(expectedPage, currentPage,
                "El valor de la pagina esperado no es igual al obtenido.");
    }
}
