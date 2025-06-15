package ApiUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Utils {

	// https://reqres.in/api/users
	private final String BASE_URL = "https://reqres.in/";
	String apiKey = "reqres-free-v1";

	public Response postRequest(String endpoint, Object body) {
		return RestAssured.given().baseUri(BASE_URL).header("x-api-key", apiKey).contentType(ContentType.JSON)
				.body(body).post(endpoint);
	}

	public Response getRequest(String endpoint) {
		return RestAssured.given().baseUri(BASE_URL).header("x-api-key", apiKey).get(endpoint);
	}

	public Response putRequest(String endpoint, Object body) {
		return RestAssured.given().baseUri(BASE_URL).header("x-api-key", apiKey).contentType(ContentType.JSON)
				.body(body).put(endpoint);
	}

	public Response deleteRequest(String endpoint) {
		return RestAssured.given().baseUri(BASE_URL).header("x-api-key", apiKey).delete(endpoint);
	}
}
