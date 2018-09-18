/**
 * 
 */
package com.ftd.catalogservice.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Swagger is a tool, a specification and a complete framework implementation
 * for producing the visual representation of RESTful Web Services. It enables
 * documentation to be updated at the same pace as the server.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@Configuration
@EnableSwagger2 //To enable the Swagger 2 we use the annotation @EnableSwagger2.
@PropertySource("classpath:swaggerConfiguration.properties")
public class SwaggerConfig {
	
	@Value("${swagger.basePackage}")
	private String basePackage;

	@Value("${swagger.apiInfo.title}")
	private String apiInfoTitle;

	@Value("${swagger.apiInfo.description}")
	private String apiInfoDescription;

	@Value("${swagger.apiInfo.version}")
	private String apiInfoVersion;

	@Value("${swagger.apiInfo.termsOfServiceUrl}")
	private String apiInfoTermsOfServiceUrl;

	@Value("${swagger.apiInfo.contact.name}")
	private String apiInfoContactName;

	@Value("${swagger.apiInfo.contact.url}")
	private String apiInfoContactUrl;

	@Value("${swagger.apiInfo.contact.email}")
	private String apiInfoContactEmail;

	@Value("${swagger.apiInfo.license}")
	private String apiInfoLicense;

	@Value("${swagger.apiInfo.licenseUrl}")
	private String apiInfoLicenseUrl;
	

	/**
	 * A Docket bean is defined and using its select() method we get an instance
	 * of ApiSelectorBuilder. ApiSelectorBuilder we configure the endpoints
	 * exposed by Swagger.After the Docket bean is defined, its select() method
	 * returns an instance of ApiSelectorBuilder, which provides a way to
	 * control the endpoints exposed by Swagger.
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors// RequestHandlerSelectors allows
												// using the any or none
												// predicates, but can also be
												// used to filter the API
												// according to the base
												// package, class annotation,
												// and method annotations.
						.basePackage(basePackage))
				.paths(PathSelectors.any())// PathSelectors provides additional
											// filtering with predicates which
											// scan the request paths of your
											// application. You can use any(),
											// none(), regex(), or ant().

				.build().apiInfo(apiInfo());
	}

	/**
	 * Information displayed on the swagger UI.
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo(
				apiInfoTitle ,// title
				apiInfoDescription ,// description
				apiInfoVersion ,// version
				apiInfoTermsOfServiceUrl ,// termsOfServiceUrl
				new Contact(apiInfoContactName , apiInfoContactUrl , apiInfoContactEmail),// contact
				apiInfoLicense ,// license
				apiInfoLicenseUrl);// license url
		
		return apiInfo;

	}
	
}
