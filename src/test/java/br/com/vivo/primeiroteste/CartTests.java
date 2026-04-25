package br.com.vivo.primeiroteste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTests {

  public static WebDriver driver;

  @BeforeClass
  public static void setUp() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

  }

  @Test
  public void ct1testCreateCart(){

    //Navegar para o site
    driver.get("https://store.vivo.com.br/");

    //Clicar no botão 'Continuar e fechar'
    driver.findElement(By.xpath("//button[@id='consent']")).click();

    //Clicar no menu 'Celulares'
    driver.findElement(By.xpath("//a[@title='Celulares']")).click();

    driver.findElement(By.xpath("//button[@class='popup-offer-close']")).click();

    //Clicar no primeiro aparelho do menu 'Celulares'
    driver.findElement(By.xpath("(//a[@class='product-card product-card--grid'])[2]")).click();

    //Captura o preço do produto
    String precoProduto = driver.findElement(By.xpath("(//div[@aria-label='new item price']//p[contains(text(),'R$')])[1]")).getText();
    System.out.println("Preço do produto: " + precoProduto);

    //Clicar no botão colocar no carrinho
    driver.findElement(By.xpath("//span[normalize-space()='Colocar no carrinho']")).click();


    WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement itemNoCarrinho =  espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item-description']")));

    assertTrue("O produto deve estar visível no carrinho", itemNoCarrinho.isDisplayed());

    String precoCarrinho = driver.findElement(By.id("total-value")).getText();
    System.out.println("Valor total do carrinho: " + precoCarrinho);

    assertEquals("Valor total do carrinho deve ser igual ao preço do produto", precoProduto, precoCarrinho);

 }

  @Test
  public void ct2cadastrarCliente(){
    driver.get("https://www.google.com.br");
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }
}
