package camping.myapp.handler.member;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.MemberDao;
import camping.myapp.vo.Member;
import camping.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Member old = memberDao.findBy(no);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    Member member = new Member();
    member.setNo(old.getNo());
    member.setName(this.prompt.input("이름(%s)? ", old.getName()));
    member.setGender(this.prompt.input("성별(%s)? ", old.getGender()));
    member.setTel(this.prompt.inputInt("전화번호(%d)? ", old.getTel()));
    member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(old.getCreatedDate());

    memberDao.update(member);
    System.out.println("회원을 변경했습니다.");
  }
}
