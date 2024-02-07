package camping.myapp.handler.camp_info;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.Camp_infoDao;
import camping.util.Prompt;

public class Camp_infoDeleteHandler extends AbstractMenuHandler {

  private Camp_infoDao camp_infoDao;

  public Camp_infoDeleteHandler(Camp_infoDao camp_infoDao, Prompt prompt) {
    super(prompt);
    this.camp_infoDao = camp_infoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      if (camp_infoDao.delete(no) == 0) {
        System.out.println("번호가 유효하지 않습니다!");
      } else {
        System.out.println("캠핑장정보를 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 오류!");
    }
  }
}
