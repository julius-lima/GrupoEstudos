import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteAlert {
	
	@Test
	public void deveInteragirComAlertaSimples(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
		
}

	@Test
	public void deveInteragirComAlertaConfirm(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert confirm = driver.switchTo().alert();
		String texto = confirm.getText();
		Assert.assertEquals("Confirm Simples", texto);
		confirm.accept();
		Assert.assertEquals("Confirmado", confirm.getText());
		confirm.accept();
		
		driver.findElement(By.id("confirm")).click();
		confirm = driver.switchTo().alert();
		String texto1 = confirm.getText();
		Assert.assertEquals("Confirm Simples", texto1);
		confirm.dismiss();
		Assert.assertEquals("Negado", confirm.getText());
		confirm.dismiss();
		
		driver.close();
				
	}
	
	@Test
	public void deveInteragirComAlertaPrompt(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		
		driver.close();
		
	}	
	
}