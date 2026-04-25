package br.com.vivo.pageObject.attributes;

import org.openqa.selenium.By;

public class AttributesCarrinho {
  public By produtoNoCarrinho = By.xpath("//div[@class='item-description']");
  public By valorTotalDoCarrinho = By.id("total-value");
}
