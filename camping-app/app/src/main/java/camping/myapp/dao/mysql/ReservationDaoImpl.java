package camping.myapp.dao.mysql;

import camping.myapp.dao.DaoException;
import camping.myapp.dao.ReservationDao;
import camping.myapp.vo.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

  Connection con;

  public ReservationDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Reservation reservation) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into reservations(people,price) values(?,?)")) {

      pstmt.setInt(1, reservation.getPeople());
      pstmt.setInt(2, reservation.getPrice());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from reservations where board_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Reservation> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select reservation_no, checkin, checkout, people, price from reservations order by reservation_no desc");
        ResultSet rs = pstmt.executeQuery()){

      ArrayList<Reservation> list = new ArrayList<>();

      while (rs.next()) {
        Reservation reservation = new Reservation();
        reservation.setNo(rs.getInt("reservation_no"));
        reservation.setCheckin(rs.getDate("checkin"));
        reservation.setCheckout(rs.getDate("checkout"));
        reservation.setPeople(rs.getInt("people"));
        reservation.setPrice(rs.getInt("price"));

        list.add(reservation);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Reservation findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from reservations where reservation_no =?")){

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Reservation reservation = new Reservation();
          reservation.setNo(rs.getInt("reservation_no"));
          reservation.setCheckin(rs.getDate("checkin"));
          reservation.setCheckout(rs.getDate("checkout"));
          reservation.setPeople(rs.getInt("people"));
          reservation.setPrice(rs.getInt("price"));

          return reservation;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Reservation reservation) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update reservations set people=? where reservation_no=?")) {

      pstmt.setInt(1, reservation.getPeople());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
