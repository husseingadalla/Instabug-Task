package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver_page;
	protected WebDriverWait driver_wait_page;

	public PageBase(WebDriver driver_) {

		PageFactory.initElements(driver_, this);
	}

}
