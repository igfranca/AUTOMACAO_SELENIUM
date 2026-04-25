package br.com.vivo.pageObject.pages;

import br.com.vivo.pageObject.attributes.AttributesHome;
import org.openqa.selenium.WebDriver;

public class PageHome extends AttributesHome {
  private WebDriver driver;

  public PageHome(WebDriver pdriver) {
    this.driver = pdriver;
  }

  public void acessarOSite(){
    driver.get("https://store.vivo.com.br/");
  }

  public void aceitarTermosDeConsentimento(){
    driver.findElement(consentButton).click();
  }

  public void clicarNoMenuCelulares(){
    driver.findElement(menuCelulares).click();

  }
}
