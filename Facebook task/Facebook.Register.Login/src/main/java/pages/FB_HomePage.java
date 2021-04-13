package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FB_HomePage extends PageBase {

	public FB_HomePage(WebDriver driver_) {
		super(driver_);
		this.driver_page = driver_;

	}

	@FindBy(xpath = "(//img[@width ='40' and@height ='40'])[1]")
	WebElement Account_image_top_right;

	@FindBy(xpath = "//*[contains(text(),'Log Out')]")
	WebElement signout_link;

	public boolean account_is_loggedin() {
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, Account_image_top_right);
		boolean account_image_present = GenericMethods.Check_element_is_present(Account_image_top_right);
		return account_image_present;
	}

	public void account_signout() {

		GenericMethods.click_element(Account_image_top_right);
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, signout_link);
		GenericMethods.click_element(signout_link);
	}

}
