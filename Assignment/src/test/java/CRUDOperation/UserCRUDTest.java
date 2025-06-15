package CRUDOperation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ApiUtils.ExtentReportManager;
import ApiUtils.Utils;
import PojoClasses.User;
import io.restassured.response.Response;

public class UserCRUDTest {
	Utils api = new Utils();
	String userId;

	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance(); // get report setup
	}

	@AfterTest
	public void tearDownReport() {
		extent.flush();
	}

	@Test(priority = 1)
	public void createUser() {
		// https://reqres.in//api/users
		// https://reqres.in/api/users
		test = extent.createTest("verify createUser");
		test.info("Starting createUser test");
		String name = "om yadav";
		String designation = "Qa Tester";
		// Your test steps here

		User user = new User(name, designation);

		Response res = api.postRequest("api/users", user);
		String resBody = res.asPrettyString();
		System.out.println(resBody);
		Assert.assertEquals(res.statusCode(), 201);

		userId = res.jsonPath().getString("id");
		System.out.println(userId);

		test.info("Found this user Id:" + userId);
		test.pass("createUser test passed");
	}

	@Test(priority = 2, dependsOnMethods = "createUser")
	public void getUser() {
		test = extent.createTest("verify getUser");
		test.info("Starting getUser test");
		Response res = api.getRequest("api/users/" + "1");
		Assert.assertEquals(res.statusCode(), 200);
		test.pass("getUser test passed");
	}

	@Test(priority = 3, dependsOnMethods = "getUser")
	public void updateUser() {
		test = extent.createTest("updateUser getUser");
		test.info("Starting updateUser test");
		User user = new User("morpheus", "zion leader");
		Response res = api.putRequest("/api/users/" + userId, user);
		Assert.assertEquals(res.statusCode(), 200);
		test.pass("updateUser test passed");
	}

	@Test(priority = 4, dependsOnMethods = "updateUser")
	public void deleteUser() {
		test = extent.createTest("deleteUser getUser");
		test.info("Starting deleteUser test");
		Response res = api.deleteRequest("/api/users/" + userId);
		Assert.assertEquals(res.statusCode(), 204);
		test.pass("deleteUser test passed");
	}

	// @Test(priority = 5)
	public void getInvalidUser() {
		test = extent.createTest("getInvalidUser getUser");
		test.info("Starting getInvalidUser test");
		Response res = api.getRequest("/api/users/9999");
		Assert.assertEquals(res.statusCode(), 404);
		System.out.println("getInvalidUser pass");
		test.pass("getInvalidUser test passed");
	}
}
