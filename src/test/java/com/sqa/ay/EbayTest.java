package com.sqa.ay;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.opera.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class EbayTest {
	private boolean acceptNextAlert = true;
	private String baseUrl = "http://www.ebay.com/";
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(enabled = true)
	public void setUpChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(enabled = false)
	public void setUpFirefox() throws Exception {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(enabled = false)
	public void setUpOpera() throws Exception {
		System.setProperty("webdriver.opera.driver", "drivers/operadriver");
		this.driver = new OperaDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass(enabled = false)
	public void setUpSafari() throws Exception {

		this.driver = new SafariDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testEbay() throws Exception {

		// System.setProperty("webdriver.chrome.driver",
		// "drivers/chromedriver");
		// this.driver = new ChromeDriver();

		// System.setProperty("webdriver.safari.driver",
		// "drivers/SafariDriver.safariextz");
		// this.driver = new SafariDriver();

		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input"))
				.sendKeys("bourne_jackson@yahoo.com");
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).sendKeys("Godgodgod01");
		this.driver.findElement(By.id("sgnBt")).click();
		this.driver.findElement(By.id("gh-ac")).click();
		this.driver.findElement(By.id("gh-ac")).clear();
		this.driver.findElement(By.id("gh-ac")).sendKeys("burberry brit");
		this.driver.findElement(By.id("gh-btn")).click();
		this.driver.findElement(By.linkText("BURBERRY BRIT for Men * Cologne * 3.3 / 3.4 oz * BRAND NEW TESTER"))
				.click();
		this.driver.findElement(By.id("isCartBtn_btn")).click();

		// Verification
		// Todo insert Alert

		this.driver.findElement(By.linkText("Remove")).click();

		// Signout

		this.driver.findElement(By.cssSelector("b.gh-eb-arw.gh-sprRetina")).click();
		this.driver.findElement(By.linkText("Sign out")).click();
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	/**
	 * @param verificationErrorString
	 */
	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

@AfterTest
private void afterTest()
{this.driver.close();
 this.driver.quite();

}
}
