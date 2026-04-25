package br.com.vivo.pageObject;

import br.com.vivo.pageObject.pages.PageCarrinho;
import br.com.vivo.pageObject.pages.PageCelulares;
import br.com.vivo.pageObject.pages.PageHome;
import br.com.vivo.pageObject.pages.PageProduto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageObjectTests {

  private static WebDriver driver;

  @BeforeClass
  public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testCreateCart(){
    //Instancias
    PageHome paginaHome = new PageHome(driver);
    PageCelulares paginaCelulares = new PageCelulares(driver);
    PageProduto paginaProduto = new PageProduto(driver);
    PageCarrinho paginaCarrinho = new PageCarrinho(driver);

    //PageHome
    paginaHome.acessarOSite();
    paginaHome.aceitarTermosDeConsentimento();
    paginaHome.clicarNoMenuCelulares();

    //PageCelulares
    paginaCelulares.PopUpPaginaCelulares();
    paginaCelulares.escolherOSegundoAparelho();

    //PageProduto
    String precoProduto = paginaProduto.retornarPrecoDoProduto();
    paginaProduto.clicarEmColocarNoCarrinho();

    //PageCarrinho
    boolean estaNoCarrinho = paginaCarrinho.verificaProdutoNoCarrinho();
    assertTrue("O produto deve estar visível no carrinho", estaNoCarrinho);
    String valorTotal = paginaCarrinho.capturarValorTotalDoCarrinho();
    assertEquals("Valor total do carrinho deve ser igual ao preço do produto", precoProduto, valorTotal);
  }

  @AfterClass
  public static void tearDown(){
    driver.quit();
  }
}
