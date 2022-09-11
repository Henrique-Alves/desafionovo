package br.desafio.erros;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluxoDeErrosTest {

	private WebDriver driver;
	private FluxoDeErrosPage fluxodeerropage;
	
	@Before
	public void executarBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\desafio\\DesafioFase01\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?id_category=9&controller=category.");
		fluxodeerropage = new FluxoDeErrosPage(driver);
	}
	
	@After
	public void quit() {
//		driver.quit();
	}
	
	/*
	 * id-1 Validar mensagem de erro ao adicionar email não existente. (Obs:
	 * resultado esperado: o sistema deve exibir uma mensagem que ou email é
	 * invalido ou não está cadastrado.)
	 */
	@Test
	public void validarBoletinDeNoticias() {
		fluxodeerropage.barraDeRolamentoParabaixo();
		fluxodeerropage.escreverEmailBoletinDeNoticias("emailnaoexistentenemcadastrado@gmail.com");
		fluxodeerropage.barraDeRolamentoParaCima();

		assertEquals("Newsletter : This email address is already registered.",
				fluxodeerropage.validarErroNoCampoDeNoticias());
	}
}
