package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class RegisterationPage extends PageBase {

	public RegisterationPage(WebDriver driver_) {

		super(driver_);
		this.driver_page = driver_;

	}

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstname_input;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname_input;

	@FindBy(xpath = "//input[@name='reg_email__']")
	WebElement email_input;

	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
	WebElement confirmemail_input;

	@FindBy(xpath = "//input[@type='password' and @name='reg_passwd__']")
	WebElement password_input;

	@FindBy(xpath = "//select[@id='day']")
	WebElement birthday_input;

	@FindBy(xpath = "//select[@id='month']")
	WebElement birthmonth_input;

	@FindBy(xpath = "//select[@id='year']")
	WebElement birthyear_input;

	@FindBy(xpath = "//input[@type='radio' and @name='sex']")
	WebElement random_gender_selection;

	@FindBy(xpath = "//button[@type='submit' and @name='websubmit']")
	public WebElement signup_button;

	@FindBy(xpath = "//input[@id='recovery_code_entry']")
	WebElement recoverycode_input;

	@FindBy(xpath = "//*[contains(text(),'real date of birth')]")
	WebElement enter_real_date_of_birth_msg;

	@FindBy(xpath = "//*[contains(text(),'What')]")
	WebElement missing_name_msg;;

	@FindBy(xpath = "//*[contains(text(),'when you log in and if you ever need to reset your password.')]")
	WebElement missing_email_msg;;

	@FindBy(xpath = "//*[contains(text(),'Please enter a valid mobile number or email address')]")
	WebElement invalid_email_msg;;

	@FindBy(xpath = "//*[contains(text(),'Please re-enter your email address')]")
	WebElement confirmation_email_missing_msg;;

	@FindBy(xpath = "//*[contains(text(),'Your emails do not match. Please try again')]")
	WebElement mismatch_emails__msg;;

	@FindBy(xpath = "//*[contains(text(),'Enter a combination of at least six numbers')]")
	WebElement missing_password__msg;;

	@FindBy(xpath = "//*[contains(text(),'Your password must be at least 6 characters long. Please try another.')]")
	WebElement invalid_password__msg;;

	@FindBy(xpath = "//*[contains(text(),'Please choose a gender')]")
	WebElement missing_gender_msg;;

	String Firstname = "Hussein";
	String Lastname = "Gadalla";
	String Random_character = GenericMethods.generateRandomCharacter();
	String Email = Firstname + "." + Lastname + Random_character + "@gmail.com";
	String password = "Test1234";

	private void select_year_of_birth(String year) {
		Select birthyear = new Select(birthyear_input);
		birthyear.selectByValue(year);
	}

	public void user_can_register_steps() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.implicit_wait_for_seconds(driver_page, 3);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, password);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);

	}

	public boolean user_succssfully_registered_verification() {

		GenericMethods.explicit_wait_for_seconds_invisibility(driver_page, driver_wait_page, 120, signup_button);

		boolean result = GenericMethods.Check_element_is_present(signup_button);

		return result;
	}

	public boolean register_with_empty_first_name() {

		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.implicit_wait_for_seconds(driver_page, 3);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, password);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean missing_first_name_msg = GenericMethods.Check_element_is_present(missing_name_msg);
		return missing_first_name_msg;

	}

	public boolean register_with_empty_second_name() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.implicit_wait_for_seconds(driver_page, 3);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, password);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean missing_last_name_msg = GenericMethods.Check_element_is_present(missing_name_msg);
		return missing_last_name_msg;

	}

	public boolean register_with_empty_email() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(password_input, password);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean missing_email = GenericMethods.Check_element_is_present(missing_email_msg);
		return missing_email;

	}

	public boolean register_with_invalid_email_format() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(password_input, password);
		GenericMethods.write_text_box(email_input, "hussein");

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean invalid_email = GenericMethods.Check_element_is_present(invalid_email_msg);
		return invalid_email;

	}

	public boolean register_with_confirm_email_empty() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(password_input, password);
		GenericMethods.write_text_box(email_input, Email);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean confirm_Email_msg = GenericMethods.Check_element_is_present(confirmation_email_missing_msg);
		return confirm_Email_msg;

	}

	public boolean register_with_mismatching_mails() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(password_input, password);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.write_text_box(confirmemail_input, "hussein.gadalla@gmail.com");

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean mismatch_email_msg = GenericMethods.Check_element_is_present(mismatch_emails__msg);
		return mismatch_email_msg;

	}

	public boolean register_with_mising_password() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.write_text_box(confirmemail_input, Email);

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean missing_password_msg = GenericMethods.Check_element_is_present(missing_password__msg);
		return missing_password_msg;

	}

	public boolean register_with_invalid_password() {

		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, "23");

		select_year_of_birth("1991"); /* Select a valid year */

		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, invalid_password__msg);
		boolean missing_password_msg = GenericMethods.Check_element_is_present(invalid_password__msg);
		return missing_password_msg;

	}

	public boolean register_with_empty_gender() {
		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.implicit_wait_for_seconds(driver_page, 3);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, password);
		select_year_of_birth("1991"); /* Select a valid year */
		GenericMethods.click_element(signup_button);
		boolean missing_gnder_msg_appear = GenericMethods.Check_element_is_present(missing_gender_msg);
		return missing_gnder_msg_appear;

	}

	public boolean register_with_recent_date_of_birth() {
		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.implicit_wait_for_seconds(driver_page, 3);
		GenericMethods.write_text_box(confirmemail_input, Email);
		GenericMethods.write_text_box(password_input, password);
		select_year_of_birth("2020");
		GenericMethods.click_element(random_gender_selection);
		GenericMethods.click_element(signup_button);
		boolean date_error_msg = GenericMethods.Check_element_is_present(enter_real_date_of_birth_msg);
		return date_error_msg;

	}

	public void return_to_LoginOrsignupPage() {

		driver_page.navigate().to("https://facebook.com");
	}
}
