package br.desafio.erros;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluxoDeErrosPage {

	public WebDriver driver;

	public FluxoDeErrosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void barraDeRolamentoParabaixo() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,2250)", "");
	}
	
	public void barraDeRolamentoParaCima() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -2250);");
	}
	
	public void escreverEmailBoletinDeNoticias(String valor) {
		WebElement element = driver.findElement(By.id("newsletter-input"));
		element.sendKeys(valor);
		element.sendKeys(Keys.ENTER);
	}
	
	public String validarErroNoCampoDeNoticias() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"columns\"]/p"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String msg = element.getText();
		System.out.println(msg);
		return msg;
	}
}
