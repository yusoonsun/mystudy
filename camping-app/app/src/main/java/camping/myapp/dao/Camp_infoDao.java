package camping.myapp.dao;

import camping.myapp.vo.Camp_info;
import java.util.List;

public interface Camp_infoDao {

  void add(Camp_info camp_info);

  int delete(int no);

  List<Camp_info> findAll();

  Camp_info findBy(int no);

  int update(Camp_info camp_info);

}
