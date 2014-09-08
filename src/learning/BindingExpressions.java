package learning;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by uqiu on 9/7/14.
 */
public class BindingExpressions {
  public static void main(String[] args) {
    System.out.println("Binding Expressions");

    Contact contact = new Contact("John");
    StringProperty fname = new SimpleStringProperty();
    fname.bindBidirectional(contact.firstNameProperty());

    System.out.println(fname);
    contact.setFirstName("Not John");
    System.out.println(fname);

    final IntegerProperty width = new SimpleIntegerProperty(10);
    final IntegerProperty height = new SimpleIntegerProperty(10);
    NumberBinding area = width.multiply(height);

    width.set(6);
    height.set(20);
    System.out.println(area.getValue());

    final DoubleProperty radius = new SimpleDoubleProperty(2);

    DoubleBinding volumeOfSphere = new DoubleBinding() {
      {
        super.bind(radius);
      }
      @Override
      protected double computeValue() {
        return (4/3 * Math.PI * Math.pow(radius.get(), 3));
      }
    };

    radius.set(20);
    System.out.println(volumeOfSphere.get());
  }

  static class Contact {

    private SimpleStringProperty firstName = new SimpleStringProperty();

    public Contact(String fn) {
      firstName.setValue(fn);
    }

    public String getFirstName() {
      return firstName.getValue();
    }

    public StringProperty firstNameProperty() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName.setValue(firstName);
    }
  }
}
