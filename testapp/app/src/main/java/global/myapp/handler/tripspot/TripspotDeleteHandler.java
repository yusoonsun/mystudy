package global.myapp.handler.tripspot;

import global.menu.AbstractMenuHandler;
import global.myapp.dao.TripspotDao;
import global.util.Prompt;

public class TripspotDeleteHandler extends AbstractMenuHandler {

  private TripspotDao tripspotDao;

  public TripspotDeleteHandler(TripspotDao tripspotDao, Prompt prompt) {
    super(prompt);
    this.tripspotDao = tripspotDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (tripspotDao.delete(no) == 0) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다!");
    }
  }
}
