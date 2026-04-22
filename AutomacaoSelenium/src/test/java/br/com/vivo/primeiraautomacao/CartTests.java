package br.com.vivo.primeiraautomacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CartTests {

  @Test
  public void testCreateCart(){

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new ChromeDriver();

    //Espera implícita, aguardar 20 segundos ou clicar se estiver disponível
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //Maximiza janela
    driver.manage().window().maximize();

    //Navegar para o site
    driver.get("https://store.vivo.com.br/");

    driver.findElement(By.xpath("//button[@id='consent']")).click();
    driver.findElement(By.xpath("//a[@title='Celulares']")).click();
    driver.findElement(By.xpath("(//a[@class='product-card product-card--grid'])[1]")).click();



    //Encerra o processo do chromeDriver no Windows
    driver.quit();
 }
}
