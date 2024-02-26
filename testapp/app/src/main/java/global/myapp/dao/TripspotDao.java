package global.myapp.dao;

import global.myapp.vo.Tripspot;

import java.util.List;

public interface TripspotDao {

  void add(Tripspot tripspot);

  int delete(int no);

  List<Tripspot> findAll();

  Tripspot findBy(int no);

  int update(Tripspot tripspot);
}
