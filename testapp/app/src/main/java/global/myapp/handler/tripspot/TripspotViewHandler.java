package global.myapp.handler.tripspot;

import global.menu.AbstractMenuHandler;

import global.myapp.dao.TripspotDao;
import global.myapp.vo.Tripspot;
import global.util.Prompt;

public class TripspotViewHandler extends AbstractMenuHandler {

  private TripspotDao tripspotDao;

  public TripspotViewHandler(TripspotDao tripspotDao, Prompt prompt) {
    super(prompt);
    this.tripspotDao = tripspotDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Tripspot tripspot = tripspotDao.findBy(no);
    if (tripspot == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", tripspot.getNo());
    System.out.printf("국가: %s\n", tripspot.getNation());
    System.out.printf("지역: %s\n", tripspot.getRegion());
    System.out.printf("설명: %s\n", tripspot.getDescription());
    System.out.printf("평점: %d\n", tripspot.getRating());
    System.out.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", tripspot.getCreatedDate());
  }
}
