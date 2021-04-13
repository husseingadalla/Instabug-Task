package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.GenericMethods;

import pages.LoginOrSignupPage;
import pages.RegisterationPage;

public class UserRegisterationTest extends TestBase {

	LoginOrSignupPage login_signup_obj;
	RegisterationPage registerpage_obj;

	@Test(priority = 1, enabled = true)
	public void verify_gender_selection_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_empty_gender();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 2, enabled = true)
	public void verify_firstname_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_empty_first_name();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 3, enabled = true)
	public void verify_lasttname_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_empty_second_name();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 4, enabled = true)
	public void verify_email_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_empty_email();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 5, enabled = true)
	public void verify_email_is_must_be_in_valid_format() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_invalid_email_format();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 6, enabled = true)
	public void verify_confirm_email_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_confirm_email_empty();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 7, enabled = true)
	public void verify_email_and_confirm_mail_must_match() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_mismatching_mails();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 8, enabled = true)
	public void verify_password_is_mandatory() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_mising_password();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 9, enabled = true)
	public void verify_password_must_be_atleast_6charachters() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_invalid_password();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 10, enabled = true)
	public void verify_recent_date_birth_is_notacceptable() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		boolean register_failed = registerpage_obj.register_with_recent_date_of_birth();
		Assert.assertEquals(register_failed, true);

		registerpage_obj.return_to_LoginOrsignupPage();

	}

	@Test(priority = 11) // In case tests are executed in order this test must be the last test to be
							// executed as it redirects to un expected confirm register process page
	public void verify_user_Can_Register_Successfully() {

		login_signup_obj = new LoginOrSignupPage(driver);
		login_signup_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		registerpage_obj.user_can_register_steps();

		boolean signup_button_still_present = registerpage_obj.user_succssfully_registered_verification();
		Assert.assertEquals(signup_button_still_present, false);
	}

}
