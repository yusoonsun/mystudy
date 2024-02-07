package camping.myapp;

import camping.menu.MenuGroup;
import camping.myapp.dao.Camp_infoDao;
import camping.myapp.dao.MemberDao;
import camping.myapp.dao.ReservationDao;
import camping.myapp.dao.mysql.Camp_infoDaoImpl;
import camping.myapp.dao.mysql.MemberDaoImpl;
import camping.myapp.dao.mysql.ReservationDaoImpl;
import camping.myapp.handler.HelpHandler;
import camping.myapp.handler.camp_info.Camp_infoAddHandler;
import camping.myapp.handler.camp_info.Camp_infoDeleteHandler;
import camping.myapp.handler.camp_info.Camp_infoListHandler;
import camping.myapp.handler.camp_info.Camp_infoModifyHandler;
import camping.myapp.handler.camp_info.Camp_infoViewHandler;
import camping.myapp.handler.member.MemberAddHandler;
import camping.myapp.handler.member.MemberDeleteHandler;
import camping.myapp.handler.member.MemberListHandler;
import camping.myapp.handler.member.MemberModifyHandler;
import camping.myapp.handler.member.MemberViewHandler;
import camping.myapp.handler.reservation.ReservationAddHandler;
import camping.myapp.handler.reservation.ReservationDeleteHandler;
import camping.myapp.handler.reservation.ReservationListHandler;
import camping.myapp.handler.reservation.ReservationModifyHandler;
import camping.myapp.handler.reservation.ReservationViewHandler;
import camping.util.Prompt;
import java.sql.Connection;
import java.sql.DriverManager;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  Camp_infoDao camp_infoDao;
  MemberDao memberDao;
  ReservationDao reservationDao;

  MenuGroup mainMenu;

  ClientApp() {
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("[캠핑장 예약 시스템]");
    new ClientApp().run();
  }

  void prepareDatabase() {
    try {
      // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
//      Driver driver = new com.mysql.cj.jdbc.Driver();
//      DriverManager.registerDriver(driver);

      Connection con = DriverManager.getConnection(
          //"jdbc:mysql://localhost/studydb", "study", "camping!@#123");
          "jdbc:mysql://db-ld27b-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "camping!@#123");

      camp_infoDao = new Camp_infoDaoImpl(con);
      memberDao = new MemberDaoImpl(con);
      reservationDao = new ReservationDaoImpl(con);

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup camp_infoMenu = mainMenu.addGroup("캠핑장정보");
    camp_infoMenu.addItem("등록", new Camp_infoAddHandler(camp_infoDao, prompt));
    camp_infoMenu.addItem("조회", new Camp_infoViewHandler(camp_infoDao, prompt));
    camp_infoMenu.addItem("변경", new Camp_infoModifyHandler(camp_infoDao, prompt));
    camp_infoMenu.addItem("삭제", new Camp_infoDeleteHandler(camp_infoDao, prompt));
    camp_infoMenu.addItem("목록", new Camp_infoListHandler(camp_infoDao, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberDao, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberDao, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberDao, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberDao, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberDao, prompt));

    MenuGroup reservationMenu = mainMenu.addGroup("예약");
    reservationMenu.addItem("등록", new ReservationAddHandler(reservationDao, prompt));
    reservationMenu.addItem("조회", new ReservationViewHandler(reservationDao, prompt));
    reservationMenu.addItem("변경", new ReservationModifyHandler(reservationDao, prompt));
    reservationMenu.addItem("삭제", new ReservationDeleteHandler(reservationDao, prompt));
    reservationMenu.addItem("목록", new ReservationListHandler(reservationDao, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
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
