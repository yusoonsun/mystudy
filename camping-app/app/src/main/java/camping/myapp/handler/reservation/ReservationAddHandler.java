package camping.myapp.handler.reservation;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.ReservationDao;
import camping.myapp.vo.Reservation;
import camping.util.Prompt;

public class ReservationAddHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationAddHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    Reservation reservation = new Reservation();
    reservation.setPeople(this.prompt.inputInt("인원? "));
    reservation.setPrice(this.prompt.inputInt("가격? "));

    reservationDao.add(reservation);
  }
}
