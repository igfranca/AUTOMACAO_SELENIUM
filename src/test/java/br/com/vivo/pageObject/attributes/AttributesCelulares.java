package br.com.vivo.pageObject.attributes;

import org.openqa.selenium.By;

public class AttributesCelulares {
  public By segundoCelularDaLista = By.xpath("(//a[@class='product-card product-card--grid'])[2]");
  public By fecharPopUpPaginaCelulares = By.xpath("//button[@class='popup-offer-close']");
}
