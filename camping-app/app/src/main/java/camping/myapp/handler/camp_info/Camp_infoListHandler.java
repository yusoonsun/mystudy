package camping.myapp.handler.camp_info;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.Camp_infoDao;
import camping.util.Prompt;
import java.util.List;

public class Camp_infoListHandler extends AbstractMenuHandler {

  private Camp_infoDao camp_infoDao;

  public Camp_infoListHandler(Camp_infoDao camp_infoDao, Prompt prompt) {
    super(prompt);
    this.camp_infoDao = camp_infoDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "번호", "과제", "제출마감일");

    List<camping.myapp.vo.Camp_info> list = camp_infoDao.findAll();

    for (camping.myapp.vo.Camp_info camp_info : list) {
      System.out.printf("%-4d\t%-20s\t%s\n",
          camp_info.getNo(),
          camp_info.getTitle(),
          camp_info.getDeadline());
    }
  }
}
