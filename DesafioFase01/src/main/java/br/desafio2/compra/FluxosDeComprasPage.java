package br.desafio2.compra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluxosDeComprasPage {

	public WebDriver driver;

	public FluxosDeComprasPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarImagem() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img"));
		element.click();
	}
	
	public void clicarNaCorDesejada() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"color_8\"]"));
		element.click();
	}
	//valor 1 remover e valor 2 adicionar
	public void adicionarOuRemoverProduto(int valor) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a["+valor+"]"));
		element.click();
	}
	
		public void selecionarTamanho(String valor) {
			WebElement element = driver.findElement(By.id("group_1"));
			Select select = new Select(element);

			select.selectByVisibleText(valor);
		}
		
		public String validarSeOProdutoEcasual() {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/section[1]/table/tbody/tr[2]"));
			wait.until(ExpectedConditions.visibilityOf(element));
			String msg = element.getText();
			return msg;
		}
	
}
