package br.com.vivo.pageObject.pages;

import br.com.vivo.pageObject.attributes.AttributesCelulares;
import org.openqa.selenium.WebDriver;

public class PageCelulares extends AttributesCelulares {
  private WebDriver driver;

  public PageCelulares(WebDriver pdriver) {
    this.driver = pdriver;
  }

  public void escolherOSegundoAparelho(){
    driver.findElement(segundoCelularDaLista).click();
  }

  public void PopUpPaginaCelulares(){
    driver.findElement(fecharPopUpPaginaCelulares).click();
  }
}
