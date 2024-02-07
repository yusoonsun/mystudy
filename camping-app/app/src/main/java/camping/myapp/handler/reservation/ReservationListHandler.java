package camping.myapp.handler.reservation;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.ReservationDao;
import camping.util.Prompt;
import java.util.List;

public class ReservationListHandler extends AbstractMenuHandler {

  private ReservationDao reservationDao;

  public ReservationListHandler(ReservationDao reservationDao, Prompt prompt) {
    super(prompt);
    this.reservationDao = reservationDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%s\t%s\t%-4s\t%-10s\n", "번호", "예약일", "퇴실일", "인원", "가격");

    List<camping.myapp.vo.Reservation> list = reservationDao.findAll();

    for (camping.myapp.vo.Reservation reservation : list) {
      System.out.printf("%-4d\t%2$tY-%2$tm-%2$td\t%3$tY-%3$tm-%3$td\t%4$-4d\t%5$-10d\n",
          reservation.getNo(),
          reservation.getCheckin(),
          reservation.getCheckout(),
          reservation.getPeople(),
          reservation.getPrice());
    }
  }
}
