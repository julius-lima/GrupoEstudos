import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteFrames {

	
	@Test
	public void deveInteragirComFrames(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.switchTo().frame("frame1");		
		driver.findElement(By.id("frameButton")).click();		
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		org.junit.Assert.assertEquals("Frame OK!", alert.getText());
		alert.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		driver.close();
		
		
	}
}
