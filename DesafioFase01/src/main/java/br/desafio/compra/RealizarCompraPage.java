package br.desafio.compra;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealizarCompraPage {

	public WebDriver driver;

	public RealizarCompraPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ordenarPor(String valor) {
		WebElement element = driver.findElement(By.id("selectProductSort"));
		Select select = new Select(element);

		select.selectByValue(valor);
	}

	public void clicarImagem() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		element.click();
	}

	public void passarMouseNoElemento() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void fecharJanela() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
		element.click();
	}

	public String validarQuantidade() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/div[2]/div[1]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String valor = element.getText();
		return valor;
	}

	public void clicarBotaoAdicionarAoCarrinho() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		element.click();
	}

	public void clicarBotaofazerCheckOut() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		element.click();
	}

	public void clicarBotaofazerCheckOutTelaResumoDoCarrinho() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		element.click();
	}

	public void clicarBotaoEntrar() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		element.click();
	}

	public void clicarBotaofazerCheckOutTelaEndereco() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		element.click();
	}

	public void clicarBotaoCheckOutTelaEnvio() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		element.click();
	}

	public void clicarBotaoPagarPorTransferenciaBancaria() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		element.click();
	}

	public void clicarBotaoEuConfirmoMeuPedido() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		element.click();
	}

	public void clicarListaDeDesejos() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"buy_block\"]/div/div[3]/p"));
		element.click();
	}

	public void fecharJanelaDalistaDeDesejos() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a"));
		element.click();
	}

	public void selecionarckeckBox() {
		WebElement element = driver.findElement(By.id("cgv"));
		element.click();
	}

	public String validarCorETamanho() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = driver.findElement(By.id("layer_cart_product_attributes"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String valor = element.getText();
		return valor;
	}

	public String validarValor() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.id("layer_cart_product_price"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String valor = element.getText();
		return valor;
	}

	public String validarMensagemPedidoConcluido() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String msg = element.getText();
		return msg;
	}

	public String validarMensagemAddListaDedesejos() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/div/p"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String msg = element.getText();
		return msg;
	}

	public String validarMensagemAceitarTermosDeServicos() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/div/div/p"));
		wait.until(ExpectedConditions.visibilityOf(element));
		String msg = element.getText();
		return msg;
	}

	public void escreverEmail(String valor) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		element.sendKeys(valor);
	}

	public void escreverPassword(String valor) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		element.sendKeys(valor);
	}
}
