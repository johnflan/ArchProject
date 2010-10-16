package ie.ul.csis.cs4135.pcshop.factory;

import java.util.Observer;
import java.util.List;

public abstract class ComponentComposite implements ComponentInterface {

  public Observer observers;

  public void addComponent(ComponentInterface component) {
  }

  public void removeComponent(ComponentInterface component) {
  }

  public List getChildren() {
  return null;
  }

  private void notifyObservers() {
  }

}