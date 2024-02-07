package camping.myapp.handler.member;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.MemberDao;
import camping.myapp.vo.Member;
import camping.util.Prompt;
import java.util.List;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%-4s\t%-15s\t%30s\t%s\n", "번호", "이름", "성별", "전화번호", "이메일", "가입일");

    List<Member> list = memberDao.findAll();

    for (Member member : list) {
      System.out.printf("%-4d\t%-10s\t%-4s\t%-15d\t%30s\t%6$tY-%6$tm-%6$td\n",
          member.getNo(),
          member.getName(),
          member.getGender(),
          member.getTel(),
          member.getEmail(),
          member.getCreatedDate());
    }
  }
}
