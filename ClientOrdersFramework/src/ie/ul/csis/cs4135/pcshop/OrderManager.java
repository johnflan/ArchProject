package ie.ul.csis.cs4135.pcshop;

import ie.ul.csis.cs4135.pcshop.componentDecorator.DecoratorInterface;
import java.util.Map;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class OrderManager {

  private Map order;

  public DecoratorInterface decorator;

  public Float subTotalPrice = 0.0f;

  public void OrderManager(Enum region) {
  }

  private void setTaxRegion(Enum region) {
  }

  public void changeTaxRegion(Enum region) {
  }

  public ComponentInterface addComputer(Enum type) {
  return null;
  }

  public Float getTotalPrice() {
  return subTotalPrice;
  }

  public void notifyObservers() {
  }

}