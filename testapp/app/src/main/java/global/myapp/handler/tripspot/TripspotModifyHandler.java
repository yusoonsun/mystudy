package global.myapp.handler.tripspot;

import global.menu.AbstractMenuHandler;

import global.myapp.dao.TripspotDao;
import global.myapp.vo.Tripspot;
import global.util.Prompt;

public class TripspotModifyHandler extends AbstractMenuHandler {

  private TripspotDao tripspotDao;

  public TripspotModifyHandler(TripspotDao tripspotDao, Prompt prompt) {
    super(prompt);
    this.tripspotDao = tripspotDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Tripspot oldTripspot = tripspotDao.findBy(no);
    if (oldTripspot == null) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Tripspot tripspot = new Tripspot();
    tripspot.setNo(oldTripspot.getNo());
    tripspot.setNation(this.prompt.input("국가(%s)? ", oldTripspot.getNation()));
    tripspot.setRegion(this.prompt.input("지역(%s)? ", oldTripspot.getRegion()));
    tripspot.setDescription(this.prompt.input("설명(%s)? ", oldTripspot.getDescription()));
    tripspot.setRating(this.prompt.inputInt("평점(%d)? ", oldTripspot.getRating()));
    tripspot.setCreatedDate(oldTripspot.getCreatedDate());

    tripspotDao.update(tripspot);
    System.out.println("변경했습니다.");
  }
}
