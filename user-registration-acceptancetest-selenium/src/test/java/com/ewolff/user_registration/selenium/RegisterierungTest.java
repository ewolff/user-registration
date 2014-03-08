package com.ewolff.user_registration.selenium;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import com.ewolff.user_registration.RegistrationApplication;

public class RegisterierungTest {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public static void startWebApplication() {
		SpringApplication.run(RegistrationApplication.class);
	}

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://localhost:8080/";
		driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAnlegenLoeschen() throws Exception {
		kundeExistiertNicht();
		kundeAnlegenTestCase();
		kundeAnlegenNochEinmal();
		kundeExistiert();
		kundeLoeschen();
		kundeExistiertNicht();
	}

	@Test
	public void testInvalideEMail() throws Exception {
		kundeAnlegen("HURZ!");
		assertTrue(driver.findElement(By.cssSelector(".alert.alert-error"))
				.getText().matches("^[\\s\\S]*nicht[\\s\\S]*valide[\\s\\S]*$"));
	}

	public void kundeLoeschen() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(
				"eberhard.wolff@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.findElement(By.cssSelector("input.btn.btn-link")).click();
	}

	public void kundeExistiertNicht() throws Exception {
		kundeSuchen();
		assertTrue(driver.findElement(By.cssSelector(".container>.container"))
				.getText().matches("^[\\s\\S]*Kein[\\s\\S]*Kunde[\\s\\S]*$"));

	}

	public void kundeExistiert() throws Exception {
		kundeSuchen();
		List<WebElement> divs = driver.findElements(By.cssSelector("div"));
		boolean found = false;
		for (WebElement div : divs) {
			if (div.getText().matches("^[\\s\\S]*Vorname[\\s\\S]*$")) {
				found = true;
			}
		}
		assertTrue(found);
	}

	private void kundeSuchen() {
		driver.get(baseUrl + "/");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(
				"eberhard.wolff@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	public void kundeAnlegenTestCase() throws Exception {
		kundeAnlegen("eberhard.wolff@gmail.com");
		assertTrue(isElementPresent(By.cssSelector("input.btn.btn-link")));
	}

	public void kundeAnlegenNochEinmal() throws Exception {
		kundeAnlegen("eberhard.wolff@gmail.com");
		assertTrue(driver.findElement(By.cssSelector(".alert.alert-error"))
				.getText().matches("^[\\s\\S]*schon verwendet[\\s\\S]*$"));
	}

	private void kundeAnlegen(String email) {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Kunde registrieren")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Eberhard");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Wolff");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
