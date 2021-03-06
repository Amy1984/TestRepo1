package testProjectPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshotOnFailure2 {

	TakeScreenshotOnFailure1 t1 = new TakeScreenshotOnFailure1();

	@Test(priority = 1)
	public void doLogin() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\Software\\javaWorkspace\\chromedriver.exe");
		t1.driver = new ChromeDriver();

		t1.driver.manage().window().maximize();
		t1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		t1.driver.get("https://www.facebook.com/");
		Thread.sleep(3000);

		t1.driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abc@gmail.com");
		t1.driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("12345");

		// Passing wrong id so that our test case will fail
		t1.driver.findElement(By.xpath("//*[@id='login_button_test']")).click();

	}

	@Test(priority = 2)
	public void assertionCheck() {

		System.out.println("Assertion Check");
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) throws Exception {

		t1.captureScreenshot(result);
	}

}
