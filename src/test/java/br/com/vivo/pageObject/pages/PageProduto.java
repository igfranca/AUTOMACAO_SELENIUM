package br.com.vivo.pageObject.pages;

import br.com.vivo.pageObject.attributes.AttributesProduto;
import org.openqa.selenium.WebDriver;

public class PageProduto extends AttributesProduto {
  private WebDriver driver;

  public PageProduto(WebDriver pdriver) {
    this.driver = pdriver;
  }

  public String retornarPrecoDoProduto(){
    String precoProduto = driver.findElement(precoDoProduto).getText();
    System.out.println("Preço do produto: " + precoProduto);
    return precoProduto;
  }

  public void clicarEmColocarNoCarrinho(){
    driver.findElement(botaoAdicionarAoCarrinho).click();
  }
}
