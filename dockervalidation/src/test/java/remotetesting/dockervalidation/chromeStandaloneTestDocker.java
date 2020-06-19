package remotetesting.dockervalidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class chromeStandaloneTestDocker {
	@Test
	public  void main() throws MalformedURLException {
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		URL u =new URL("http://192.168.99.100:4545/wd/hub");
		RemoteWebDriver driver= new RemoteWebDriver(u,cap);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		driver.findElementById("txtUsername").sendKeys("Admin");
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElementById("txtPassword").sendKeys("admin123");
		driver.findElementById("btnLogin").click();
		WebElement admin =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'Admin')]")));
		admin.click();
		WebElement pim =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));
		pim.click();
		driver.findElementById("welcome").click();
		WebElement logout =wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		logout.click();
		driver.close();

}
}