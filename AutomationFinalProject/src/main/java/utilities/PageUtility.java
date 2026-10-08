package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WebDriver driver;

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropdownWithVisibleText(WebElement element, int value) {

		Select object = new Select(element);
		object.selectByIndex(value);

	}
	
	public void verifyKeyboardActions() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		
	}
	
	public void pageScrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;//control casting
		js.executeScript("window.scrollBy(0,-350)","");
	}

	public void pageScrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;//control casting
		js.executeScript("window.scrollBy(0,350)","");
	}
	
}
