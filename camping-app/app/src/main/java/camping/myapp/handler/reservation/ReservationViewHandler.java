package camping.myapp.handler.reservation;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.ReservationDao;
import camping.myapp.vo.Reservation;
import camping.util.Prompt;

public class ReservationViewHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationViewHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Reservation reservation = reservationDao.findBy(no);
    if (reservation == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", reservation.getNo());
    System.out.printf("예약일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", reservation.getCheckin());
    System.out.printf("퇴실일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", reservation.getCheckout());
    System.out.printf("인원: %d\n", reservation.getPeople());
    System.out.printf("가격: %d\n", reservation.getPrice());
  }
}
