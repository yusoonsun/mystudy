package camping.myapp.handler.member;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.MemberDao;
import camping.myapp.vo.Member;
import camping.util.Prompt;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setName(this.prompt.input("이름? "));
    member.setGender(this.prompt.input("성별? "));
    member.setTel(this.prompt.inputInt("전화번호? "));
    member.setEmail(this.prompt.input("이메일? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
