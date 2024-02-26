package global.myapp;

import global.menu.MenuGroup;
import global.myapp.dao.TripspotDao;
import global.myapp.dao.mysql.TripspotDaoImpl;
import global.myapp.handler.tripspot.*;
import global.util.Prompt;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  TripspotDao tripspotDao;

  MenuGroup mainMenu;

  ClientApp() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[여행지 추천 시스템]");
    new ClientApp().run();
  }

  void prepareDatabase() {
    try {

      Connection con = DriverManager.getConnection(
              //"jdbc:mysql://localhost/testdb", "study", "Bitcamp!@#123");
               //   "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
              "jdbc:mysql://db-ld28t-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp123!@#");

      tripspotDao = new TripspotDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup boardMenu = mainMenu.addGroup("여행지");
    boardMenu.addItem("등록", new TripspotAddHandler(tripspotDao, prompt));
    boardMenu.addItem("조회", new TripspotViewHandler(tripspotDao, prompt));
    boardMenu.addItem("변경", new TripspotModifyHandler(tripspotDao, prompt));
    boardMenu.addItem("삭제", new TripspotDeleteHandler(tripspotDao, prompt));
    boardMenu.addItem("목록", new TripspotListHandler(tripspotDao, prompt));

  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
  }

}
