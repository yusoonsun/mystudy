package global.myapp.dao.mysql;

import global.myapp.dao.DaoException;
import global.myapp.dao.TripspotDao;
import global.myapp.vo.Tripspot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TripspotDaoImpl implements TripspotDao {

  Connection con;

  public TripspotDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Tripspot tripspot) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
              "insert into tripspots(nation,region,description,rating) values('%s','%s','%s','%d')",
              tripspot.getNation(), tripspot.getRegion(), tripspot.getDescription(), tripspot.getRating()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
              "delete from tripspots where tripspot_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Tripspot> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from tripspots");

      ArrayList<Tripspot> list = new ArrayList<>();

      while (rs.next()) {

        Tripspot tripspot = new Tripspot();
        tripspot.setNo(rs.getInt("tripspot_no"));
        tripspot.setNation(rs.getString("nation"));
        tripspot.setRegion(rs.getString("region"));
        tripspot.setDescription(rs.getString("description"));
        tripspot.setRating(rs.getInt("rating"));
        tripspot.setCreatedDate(rs.getDate("created_date"));

        list.add(tripspot);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Tripspot findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from tripspots where tripspot_no = " + no);

      if (rs.next()) {
        Tripspot tripspot = new Tripspot();
        tripspot.setNo(rs.getInt("tripspot_no"));
        tripspot.setNation(rs.getString("nation"));
        tripspot.setRegion(rs.getString("region"));
        tripspot.setDescription(rs.getString("description"));
        tripspot.setRating(rs.getInt("rating"));
        tripspot.setCreatedDate(rs.getDate("created_date"));

        return tripspot;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Tripspot tripspot) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
              "update tripspots set nation='%s', region='%s', description='%s', rating='%d' where tripspot_no=%d",
              tripspot.getNation(), tripspot.getRegion(), tripspot.getDescription(), tripspot.getRating(), tripspot.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}