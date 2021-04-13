package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrSignupPage extends PageBase {

	public LoginOrSignupPage(WebDriver driver_) {
		super(driver_);
		this.driver_page = driver_;
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement email_input_for_login;

	@FindBy(xpath = "//input[@id='pass' and @name='pass']")
	WebElement pass_input_for_login;

	@FindBy(xpath = "//button[@name='login']")
	public static WebElement login_btn;

	@FindBy(xpath = "//*[contains(text(),'Wrong credentials')]")
	WebElement wrong_credentials_msg;

	@FindBy(xpath = "//*[contains(text(),'The email address or mobile number you entered')]")
	WebElement wrong_credentials_msg_2;

	@FindBy(xpath = "//*[contains(text(),'The password that you')]")
	WebElement wrong_password_msg;

	@FindBy(xpath = "//a[@role='button' and  @data-testid='open-registration-form-button']")
	WebElement CreateNewAccount_btn;

	public void open_registeration_page() {

		GenericMethods.click_element(CreateNewAccount_btn);

	}

	public void login_steps(String email, String password) {
		GenericMethods.clear_text_box(email_input_for_login);
		GenericMethods.clear_text_box(pass_input_for_login);
		GenericMethods.click_element(email_input_for_login);
		GenericMethods.write_text_box(email_input_for_login, email);
		GenericMethods.click_element(pass_input_for_login);
		GenericMethods.write_text_box(pass_input_for_login, password);
		GenericMethods.click_element(login_btn);
	}

	public boolean login_with_wrong_password(String email, String password) {
		String wrongpassword = password + "123";

		try {

			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.write_text_box(email_input_for_login, email);
			GenericMethods.click_element(pass_input_for_login);
			GenericMethods.write_text_box(pass_input_for_login, wrongpassword);
			GenericMethods.click_element(login_btn);

			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 3,
					wrong_credentials_msg);
			boolean wrong_cred = GenericMethods.Check_element_is_present(wrong_credentials_msg);
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			return wrong_cred;

		} catch (org.openqa.selenium.TimeoutException e) {
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.write_text_box(email_input_for_login, email);
			GenericMethods.click_element(pass_input_for_login);
			GenericMethods.write_text_box(pass_input_for_login, wrongpassword);
			GenericMethods.click_element(login_btn);
			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 3, wrong_password_msg);
			boolean wrong_cred = GenericMethods.Check_element_is_present(wrong_password_msg);
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			return wrong_cred;
		}

	}

	public boolean login_with_wrong_email_format(String email, String password) {
		// String random_char1 = GenericMethods.generateRandomCharacter();
		// String random_char2 = GenericMethods.generateRandomCharacter();
		String modifiedemail = email.replace("@", ".");

		try {
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.write_text_box(email_input_for_login, modifiedemail);
			GenericMethods.click_element(pass_input_for_login);
			GenericMethods.write_text_box(pass_input_for_login, password);
			GenericMethods.click_element(login_btn);
			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 3,
					wrong_credentials_msg);
			boolean wrong_cred = GenericMethods.Check_element_is_present(wrong_credentials_msg);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			return wrong_cred;

		} catch (org.openqa.selenium.TimeoutException e) {
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.write_text_box(email_input_for_login, modifiedemail);
			GenericMethods.click_element(pass_input_for_login);
			GenericMethods.write_text_box(pass_input_for_login, password);
			GenericMethods.click_element(login_btn);
			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 3,
					wrong_credentials_msg_2);
			boolean wrong_cred = GenericMethods.Check_element_is_present(wrong_credentials_msg_2);
			GenericMethods.click_element(email_input_for_login);
			GenericMethods.clear_text_box(email_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			GenericMethods.clear_text_box(pass_input_for_login);
			return wrong_cred;
		}

	}

}
