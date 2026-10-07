package Day_10.config;

// Imports the OpenAPI class used to create API documentation.
import io.swagger.v3.oas.models.OpenAPI;

// Imports the Info class used to describe our API.
import io.swagger.v3.oas.models.info.Info;

// Imports Spring's @Bean annotation.
import org.springframework.context.annotation.Bean;

// Imports Spring's @Configuration annotation.
import org.springframework.context.annotation.Configuration;


/*
 * @Configuration tells Spring that this class
 * contains application configuration.
 *
 * Spring will automatically detect this class
 * because it is inside the Day_10 package.
 */
@Configuration
public class OpenApiConfig {


    /*
     * @Bean tells Spring:
     *
     * "Create and manage the object returned
     * by this method."
     *
     * Here we are creating an OpenAPI configuration object.
     */
    @Bean
    public OpenAPI customOpenAPI() {

        /*
         * Create a new OpenAPI object.
         *
         * This object contains information about
         * our REST API.
         */
        return new OpenAPI()

                /*
                 * Set the API information.
                 */
                .info(

                        /*
                         * Create the Info object.
                         */
                        new Info()

                                /*
                                 * Name displayed in Swagger UI.
                                 */
                                .title("Day 10 Book API")

                                /*
                                 * Description displayed in Swagger UI.
                                 */
                                .description(
                                        "REST API for managing books"
                                )

                                /*
                                 * Version of our API.
                                 */
                                .version("1.0.0")
                );
    }
}