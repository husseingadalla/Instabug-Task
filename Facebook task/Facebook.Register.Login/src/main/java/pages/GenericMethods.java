package pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	public static boolean Check_element_is_present(WebElement element) {
		try {
			element.isDisplayed();
			return true;

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;

		}

	}

	public static void click_element(WebElement element) {

		element.click();

	}

	public static void clear_text_box(WebElement element) {
		element.clear();
	}

	public static void write_text_box(WebElement element, String text) {

		element.sendKeys(text);
	}

	public static void scroll_to_element(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static String get_element_text(WebElement element) {
		String txt;
		txt = element.getText();
		return txt;
	}

	public static String generateRandomCharacter() {
		int length = 6;
		boolean useLetters = true;
		boolean useNumbers = true;
		String randomName = RandomStringUtils.random(length, useLetters, useNumbers);
		randomName = randomName.toLowerCase();
		return randomName;
	}

	public static void implicit_wait_for_seconds(WebDriver driver, int sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void explicit_wait_for_seconds_visibility(WebDriver driver, WebDriverWait wait_driver, int sec,
			WebElement element) {

		// WebDriverWait wait_driver;

		wait_driver = new WebDriverWait(driver, sec);
		wait_driver.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicit_wait_for_seconds_invisibility(WebDriver driver, WebDriverWait wait_driver, int sec,
			WebElement element) {

		// WebDriverWait wait_driver;

		wait_driver = new WebDriverWait(driver, sec);
		wait_driver.until(ExpectedConditions.invisibilityOf(element));
	}

}
