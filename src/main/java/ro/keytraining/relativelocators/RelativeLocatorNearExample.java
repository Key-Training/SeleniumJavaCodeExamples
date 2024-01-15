package ro.keytraining.relativelocators;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.locators.RelativeLocator;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class RelativeLocatorNearExample {

	

    private WebDriver driver;



	

	@BeforeClass

	public void setup() {

		

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://keyfood.ro/");

		

	}

	

	@Test

    public void nearLocatorTest() {

        // Identificarea elementului de referință (de exemplu, un label)

        WebElement referenceElement = driver.findElement(By.cssSelector("img[class*='desktop-logo']"));

		

        // Identificarea elementului de referință (de exemplu, un label)

        WebElement referenceElement2 = driver.findElement(By.cssSelector("div[class='button-icon']"));

       

        // Utilizarea Relative Locator `near()` pentru a găsi un câmp de introducere în apropierea elementului de referință

		WebElement inputField = driver.findElement(RelativeLocator.with(By.xpath("//input")).near(referenceElement, 300).near(referenceElement2, 300));

		

        // Interacțiunea cu elementul găsit

        inputField.sendKeys("Hello, Near Locator!");

        //Stergerea textului din input

        inputField.clear();

        

        //Aceasi interactiune de data aceasta cu Relative Locator toRightOf si toLeftOf

		WebElement newInputField = driver.findElement(RelativeLocator.with(By.xpath("//input")).toRightOf(referenceElement).toLeftOf(referenceElement2));

		// Interacțiunea cu elementul găsit

		newInputField.sendKeys("Hello, toLeftOf and toRightOf Locators!");

    }

	

	

   @AfterClass

    public void tearDown() throws InterruptedException {

	   Thread.sleep(5000);

        // Închiderea browser-ului

        if (driver != null) {

            driver.quit();

        }

    }



}