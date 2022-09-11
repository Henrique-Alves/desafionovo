package br.desafio.compra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealizarCompraTest {

	private WebDriver driver;
	private RealizarCompraPage realizarCompraPage;

	@Before
	public void executarBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\desafio\\DesafioFase01\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?id_category=9&controller=category#/");
		realizarCompraPage = new RealizarCompraPage(driver);
	}

	@After
	public void quit() {
		driver.quit();
	}

	// id-1 Realizar compra do vestido casual
	@Test
	public void realizarCompraVestidoCasual() {
		realizarCompraPage.ordenarPor("price:asc");
		realizarCompraPage.clicarImagem();
		realizarCompraPage.clicarBotaoAdicionarAoCarrinho();
		assertEquals("Orange, S", realizarCompraPage.validarCorETamanho());
		assertEquals("Quantity 1", realizarCompraPage.validarQuantidade());
		assertEquals("$26.00", realizarCompraPage.validarValor());

		realizarCompraPage.clicarBotaofazerCheckOut();
		realizarCompraPage.clicarBotaofazerCheckOutTelaResumoDoCarrinho();
		realizarCompraPage.escreverEmail("desafiodet3est3@gmail.com");
		realizarCompraPage.escreverPassword("desafio/33/");
		realizarCompraPage.clicarBotaoEntrar();
		realizarCompraPage.clicarBotaofazerCheckOutTelaEndereco();
		realizarCompraPage.selecionarckeckBox();
		realizarCompraPage.clicarBotaoCheckOutTelaEnvio();
		realizarCompraPage.clicarBotaoPagarPorTransferenciaBancaria();
		realizarCompraPage.clicarBotaoEuConfirmoMeuPedido();

		assertEquals("Your order on My Store is complete.", realizarCompraPage.validarMensagemPedidoConcluido());
	}

	// id-2 Validar que só pode adicionar a lista de desejos quando logado.
	@Test
	public void adicionarProdutoNalistaDeDesejos() throws InterruptedException {
		realizarCompraPage.ordenarPor("price:asc");
		realizarCompraPage.clicarImagem();
		realizarCompraPage.clicarListaDeDesejos();

		Thread.sleep(5000);
		assertEquals("You must be logged in to manage your wishlist.",
				realizarCompraPage.validarMensagemAddListaDedesejos());

		realizarCompraPage.fecharJanelaDalistaDeDesejos();
	}

	// id-3 Validar que só poderá prosseguir com a compra se aceitar termos de
	// serviços.
	@Test
	public void aceitarTermosDeServicosParaProceguirComACompra() {
		realizarCompraPage.ordenarPor("price:asc");
		realizarCompraPage.clicarImagem();
		realizarCompraPage.clicarBotaoAdicionarAoCarrinho();
		assertEquals("Orange, S", realizarCompraPage.validarCorETamanho());
		assertEquals("Quantity 1", realizarCompraPage.validarQuantidade());
		assertEquals("$26.00", realizarCompraPage.validarValor());

		realizarCompraPage.clicarBotaofazerCheckOut();
		realizarCompraPage.clicarBotaofazerCheckOutTelaResumoDoCarrinho();
		realizarCompraPage.escreverEmail("desafiodet3est3@gmail.com");
		realizarCompraPage.escreverPassword("desafio/33/");
		realizarCompraPage.clicarBotaoEntrar();
		realizarCompraPage.clicarBotaofazerCheckOutTelaEndereco();
		realizarCompraPage.clicarBotaoCheckOutTelaEnvio();

		assertEquals("You must agree to the terms of service before continuing.",
				realizarCompraPage.validarMensagemAceitarTermosDeServicos());
	}
}
