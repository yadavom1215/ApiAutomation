package CRUDOperation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postReq {
	public static void main(String[] args) {
		String body = "{\r\n" + "    \"name\": \"sunil\",\r\n" + "    \"job\": \"QA\"\r\n" + "}";
		String BASE_URL = "https://reqres.in/";
		String endPoint = "api/users";
		Response res = RestAssured.given().contentType(ContentType.JSON).body(body).post(BASE_URL + endPoint);

		System.out.println(res.getStatusCode());
	}
}
