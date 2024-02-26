package global.myapp.handler.tripspot;

import global.menu.AbstractMenuHandler;
import global.myapp.dao.TripspotDao;
import global.myapp.vo.Tripspot;
import global.util.Prompt;

import java.util.List;

public class TripspotListHandler extends AbstractMenuHandler {

  private TripspotDao tripspotDao;

  public TripspotListHandler(TripspotDao tripspotDao, Prompt prompt) {
    super(prompt);
    this.tripspotDao = tripspotDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%-20s\t%4s\t%s\n", "No", "Nation", "Region", "Rating", "Date");

    List<Tripspot> list = tripspotDao.findAll();

    for (Tripspot tripspot : list) {
      System.out.printf("%-4d\t%-20s\t%-20s\t%4d\t%5$tY-%5$tm-%5$td\n",
          tripspot.getNo(),
          tripspot.getNation(),
          tripspot.getRegion(),
          tripspot.getRating(),
          tripspot.getCreatedDate());
    }
  }
}
