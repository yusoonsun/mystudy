package global.myapp.handler.tripspot;

import global.menu.AbstractMenuHandler;

import global.util.Prompt;
import global.myapp.dao.TripspotDao;
import global.myapp.vo.Tripspot;

import java.util.Date;

public class TripspotAddHandler extends AbstractMenuHandler {

  private TripspotDao tripspotDao;

  public TripspotAddHandler(TripspotDao tripspotDao, Prompt prompt) {
    super(prompt);
    this.tripspotDao = tripspotDao;
  }

  @Override
  protected void action() {
    Tripspot tripspot = new Tripspot();
    tripspot.setNation(this.prompt.input("국가? "));
    tripspot.setRegion(this.prompt.input("지역? "));
    tripspot.setDescription(this.prompt.input("설명? "));
    tripspot.setRating(this.prompt.inputInt("평점? "));
    tripspot.setCreatedDate(new Date());

    tripspotDao.add(tripspot);
  }
}
