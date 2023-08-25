package pe.com.bcp.techcases.testautomation.api.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.NotImplementedException;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import pe.com.bcp.techcases.testautomation.api.actors.ApiClient;

import static org.assertj.core.api.Assertions.assertThat;

public class RestApiDefinition {
@Step
    ApiClient apiClient;
    String URL = "";

    @Dado("que la URL es: {string}")
    public void queLaURLEs(String urlProperty) {
        URL = getProperty(urlProperty);
        assertThat(URL).isNotEmpty();
    }

    @Cuando("consulto la pagina {int}")
    public void consultoLaPagina(int pageNumber) {
        throw new PendingException("Paso no implementado ...");
    }

    @Entonces("valido que el estado del servicio sea {int}")
    public void validoQueElEstadoDelServicioSea(int statusCode) {
        apiClient.validateStatusCode(statusCode);
    }

    @Y("que la respuesta contenga el numero de paginacion solicitado")
    public void queLaRespuestaContengaElNumeroDePaginacionSolicitado() {
        apiClient.validatePageValue();
    }

    /**
     * Obtiene el valor a partir del nombre de la propiedad enviada
     * @param property Propiedad inscrita en el archivo de configuracion de Serenity
     * @return el valor de la propiedad
     */
    private String getProperty(String property){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(variables).getProperty(property);
    }

}
