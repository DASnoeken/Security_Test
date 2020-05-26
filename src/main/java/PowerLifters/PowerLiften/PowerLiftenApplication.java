package PowerLifters.PowerLiften;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class PowerLiftenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerLiftenApplication.class, args);
	}
	
//	@Bean
//	public Docket swaggerConfiguration() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("PowerLifters"))
//				.build()
//				.apiInfo(apiDetails());
//	}
//	
//	private ApiInfo apiDetails() {
//		return new ApiInfo(
//				"PowerLifters", 
//				"API of PowerLifters", 
//				"1.0", 
//				null, 
//				null, 
//				null, 
//				null, 
//				Collections.emptyList());
//	}
}
