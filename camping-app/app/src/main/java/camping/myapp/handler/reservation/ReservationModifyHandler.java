package camping.myapp.handler.reservation;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.ReservationDao;
import camping.myapp.vo.Reservation;
import camping.util.Prompt;

public class ReservationModifyHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationModifyHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    camping.myapp.vo.Reservation oldBoard = reservationDao.findBy(no);
    if (oldBoard == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Reservation reservation = new Reservation();
    reservation.setNo(oldBoard.getNo());
    reservation.setCheckin(oldBoard.getCheckin());
    reservation.setCheckout(oldBoard.getCheckout());
    reservation.setPeople(this.prompt.inputInt("인원(%d)? ", oldBoard.getPeople()));
    reservation.setPrice(this.prompt.inputInt("가격(%d)? ", oldBoard.getPrice()));

    reservationDao.update(reservation);
    System.out.println("예약을 변경했습니다.");
  }
}
