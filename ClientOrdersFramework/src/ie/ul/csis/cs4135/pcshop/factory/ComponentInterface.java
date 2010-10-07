package ie.ul.csis.cs4135.pcshop.factory;

public interface ComponentInterface {

  public Float getPrice();

  public String getBrandName();

  public String getProductName();

  public void notifyUpdate();

}