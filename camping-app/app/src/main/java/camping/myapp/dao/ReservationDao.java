package camping.myapp.dao;

import camping.myapp.vo.Reservation;
import java.util.List;

public interface ReservationDao {

  void add(Reservation reservation);

  int delete(int no);

  List<Reservation> findAll();

  Reservation findBy(int no);

  int update(Reservation reservation);

}
