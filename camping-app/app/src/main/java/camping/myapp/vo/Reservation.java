package camping.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private Date checkin;
  private Date checkout;
  private int people;
  private int price;
  
  @Override
  public String toString() {
    return "Reservation{" +
        "no=" + no +
        ", checkin='" + checkin + '\'' +
        ", checkout='" + checkout + '\'' +
        ", people='" + people + '\'' +
        ", price=" + price +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Date getCheckin() {
    return checkin;
  }

  public void setCheckin(Date checkin) {
    this.checkin = checkin;
  }

  public Date getCheckout() {
    return checkout;
  }

  public void setCheckout(Date checkout) {
    this.checkout = checkout;
  }

  public int getPeople() {
    return people;
  }

  public void setPeople(int people) {
    this.people = people;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
