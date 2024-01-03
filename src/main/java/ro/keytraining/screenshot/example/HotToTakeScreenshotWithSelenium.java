package ro.keytraining.screenshot.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotToTakeScreenshotWithSelenium {

	
	 public static void main(String[] args) {

	        // Inițializează un obiect WebDriver pentru Chrome
	        WebDriver driver = new ChromeDriver();

	        // Deschide o pagină web
	        driver.get("https://www.keybooks.ro");

	        // Realizează un screenshot și salvează-l într-un fișier
	        try {
	            // Utilizează metoda getScreenshotAs pentru a realiza captura de ecran
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            
	            // Salvează captura de ecran într-un fișier
	            FileUtils.copyFile(screenshotFile, new File("poze/screenshot.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Închide browser-ul
	        driver.quit();
	    }
	
}
