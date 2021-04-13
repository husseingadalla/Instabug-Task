package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FB_HomePage;
import pages.GenericMethods;
import pages.LoginOrSignupPage;
import test_data.JsonReader;

public class UserLoginTest extends TestBase {

	LoginOrSignupPage login_obj;
	FB_HomePage fbhome_obj;

	@Test(priority = 1, enabled = true)
	public void verify_user_cantlogin_invalid_invalid_emailformat() throws IOException, ParseException {
		JsonReader jsonreaderobj = new JsonReader();
		jsonreaderobj.JsonFileReader("TestDataLogin.json");
		login_obj = new LoginOrSignupPage(driver);
		boolean login_fail = login_obj.login_with_wrong_email_format(jsonreaderobj.email, jsonreaderobj.password);
		Assert.assertEquals(login_fail, true);
	}

	@Test(priority = 2, enabled = true)
	public void verify_user_cantlogin__wrong_password() throws IOException, ParseException {
		JsonReader jsonreaderobj = new JsonReader();
		jsonreaderobj.JsonFileReader("TestDataLogin.json");

		login_obj = new LoginOrSignupPage(driver);
		boolean login_fail = login_obj.login_with_wrong_password(jsonreaderobj.email, jsonreaderobj.password);
		Assert.assertEquals(login_fail, true);
	}

	@Test(priority = 3, enabled = true)
	public void verify_user_canlogin_valid_credentials() throws IOException, ParseException {
		JsonReader jsonreaderobj = new JsonReader();
		jsonreaderobj.JsonFileReader("TestDataLogin.json");
		login_obj = new LoginOrSignupPage(driver);
		login_obj.login_steps(jsonreaderobj.email, jsonreaderobj.password);

		fbhome_obj = new FB_HomePage(driver);
		boolean account_is_logged = fbhome_obj.account_is_loggedin();

		Assert.assertEquals(account_is_logged, true);

		fbhome_obj.account_signout();

	}

}
