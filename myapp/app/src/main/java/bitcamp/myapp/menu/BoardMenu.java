package bitcamp.myapp.menu;
//

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardMenu {
  //public:접근제어자, 다른 클래스에서 접근가능
  //BoardMenu 클래스를 정의한다.

  Prompt prompt;
  String title;
  Board[] boards = new Board[3];
  // static:정적변수, Board:배열타입, []:배열선언
  // Board[]:Board클래스의 객체를 저장하는 배열
  // boards:배열에 대한 레퍼런스 변수,
  // new:배열생성, Board:타입, [3]:원소개수
  // Board클래스의 객체를 담을수 잇는 크키가 3인 정적배열을 선언하고,
  // 초기화 하는것.
  int length = 0;
  // = 0; 초기화 하는것 생략해도 문제없음
  // 정적으로 선언된 정수형 변수인 length를 '0'으로 초기화하는것.

  public BoardMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }
  // BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요한다.
  // 생성자란(constructor)?
  // => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드

  void printMenu() {
    // void:메서드가 반환하는 값의 데이터형식
    // printMenu(): 메서드
    // 아무런 매개변수를 받지않고, 아무값도 반환하지 않는 정적메서드 선언
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }
  // System.out:표준출력스트림,콘솔에 텍스트 출력
  // println: 문자열출력 후 자동으로 줄바꿈
  // " ": 출력하고자 하는 문자열

  void execute() {

    // execute(): 수행결과로 boolean타입의 값을 반환
    this.printMenu();
    // printMenu() 메서드 호출

    while (true) {
      // while반복문, 조건이 true이면, 무한실행
      String input = this.prompt.input("메인/%s> ", this.title);
      // Prompt 클래스의 String input으로부터
      // "메인/게시글>"을 호출하여 입력받고, 출력한다.

      switch (input) {
        // switch 조건문
        // input 변수값에 따라 다른 코드블록을 실행
        case "1":
          this.add();
          break;
        // case="1"일때, add() 메서드를 호출하고 break;
        case "2":
          this.view();
          break;
        // case="2"일때, view() 메서드를 호출하고 break;
        case "3":
          this.modify();
          break;
        // case="3"일때, modify() 메서드를 호출하고 break;
        case "4":
          this.delete();
          break;
        // case="4"일때, delete() 메서드를 호출하고 break;
        case "5":
          this.list();
          break;
        // case="5"일때, list() 메서드를 호출하고 break;
        case "0":
          return;
        // case="0"일때, 현재 메서드를 종료하고 return;
        case "menu":
          printMenu();
          break;
        // case="menu"일때, printMenu()메서드를 호출하고 break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
          // default: 어떤 case도 해당하지 않을때, "메뉴 번호가 옮지않습니다." 출력
      }
    }
  }

  //1.
  void add() {
    System.out.println("게시글 등록:"); // add() 메서드 실행 시 "게시글 등록"을 출력한다.

    if (this.length == this.boards.length) { // if 조건문, length:게시물수, boards.length: 배열의 게시물 수
      int oldSize = this.boards.length;  // oldSize: 기존크기를 나타내는 변수
      int newSize = oldSize + (oldSize >> 1);
      // (oldSize >> 1 = oldSize / 2)
      // oldSize 를 오른쪽으로 1bit 이동

      Board[] arr = new Board[newSize];
      // Board[]: Board 클래스의 객체를 저장하는 배열
      // new Board[newSize]: Board클래스의 객체를 저장할 수 있는 크기가 newSize 인 배열을 생성
      // 배열은 초기화 되어 각 요소가 'null' 상태이다.
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }
      // for 조건문, i=0일때,i<oldSize면 arr[i]=boards[i] 되고, i를 1씩 증가한다.

      this.boards = arr; // 배열 참조변수 boards 가 배열 arr을 참조하도록 변경
    }

    Board board = new Board();
    // Board클래스의 새로운 인스턴스 생성, new:객체를 동적으로 생성하는데 사용
    // Board(): 클래스의 생성자를 호출
    board.title = this.prompt.input("제목? ");
    // 사용자로부터 제목을 입력받아 board 객체의 title 속성에 입력값 할당
    // 사용자에게 "제목? "이라는 메시지를 표시하고, 사용자의 입력을 받아오는 메서드 호출
    board.content = this.prompt.input("내용? ");
    // 사용자로부터 내용을 입력받아 board 객체의 content 속성에 할당
    // 사용자에게 "내용? "이라는 메시지표시, 사용자의 입력을 받아오는 메서드 호출
    board.writer = this.prompt.input("작성자? ");
    // 사용자로부터 작성자를 입력받아 board 객체의 writer 속성에 입력값 할당
    // 사용자에게 "작성자? "라는 메시지를 표시하고, 사용자의 입력을 받아오는 메서드 호출
    board.createdDate = this.prompt.input("작성일? ");
    // 사용자로부터 작성일을 입력받아 board 객체의 createDate 속성에 입력값 할당
    // 사용자에게 "작성일? "이라는 메시지를 표시하고, 사용자의 입력을 받아오는 메서드 호출

    this.boards[this.length++] = board;
    // length++;
    // 배열 boards의 인덱스 length에 board 객체를 할당하고, 그 후에 length 값을 1증가한다.
  }

  //2.
  void list() { // non-static method = instance method
    System.out.println("게시글 목록:");
    // list() 메서드 실행 시 "게시글 목록:"을 출력한다.
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");
    // %s: 문자열을 나타낸다, \t: 탭문자로 간격을 나타낸다, \n: 줄바꿈한다.
    // %-20s:문자열을 왼쪽으로 정렬하고 20자리 공간을 할당
    // %10s:문자열을 오른쪽으로 정렬하고 10자리 공간 할당
    // Title, Writer, Date 라는 헤더를 가진 테이블 형식의 문자열을 출력

    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      // 현재 반복해서 처리할 Board객체를 배열boards에서 가져와서 board변수에 할당한다.
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
      // board객체의 title,writer,createdDate 속성을 형식화된 문자열로 출력한다.
    }
  }

  //3.
  void view() {
    System.out.println("게시글 조회:");
    // view() 메서드 실행 시 "게시글 조회:"을 출력한다.
    int index = this.prompt.inputInt("번호? ");
    // 사용자로부터 숫자를 입력받아 정수로 변환하고 그 값을 index에 할당
    // 사용자에게 "번호? "라는 메시지를 표시하고, 사용자의 입력을 문자열로 받아온다.
    // Integer.parseInt : 문자열을 정수로 변환하는 메서드
    if (index < 0 || index >= this.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
      // 사용자로부터 입력받은 게시글 번호(index)가 유효한 범위에 속하는지 검사하는 부분
      // index가 0 미만이거나 length보다 크거나 같으면 게시글 번호가 유효하지 않다는 메시지를 출력하고
      // 메서드를 종료한다.
    }

    Board board = this.boards[index];
    // 배열boards에서 지정된 index에 해당하는 Board객체를 가져와서 변수board에 할당
    // index: 사용자가 입력한 게시글 번호
    System.out.printf("제목: %s\n", board.title);
    // 형식화된 문자열을 사용하여 board객체의 title속성을 출력
    System.out.printf("내용: %s\n", board.content);
    // 형식화된 문자열을 사용하여 board객체의 content속성을 출력
    System.out.printf("작성자: %s\n", board.writer);
    // 형식화된 문자열을 사용하여 board객체의 writer속성을 출력
    System.out.printf("작성일: %s\n", board.createdDate);
    // 형식화된 문자열을 사용하여 board객체의 createDate속성을 출력

  }

  //4.
  void modify() {
    System.out.println("게시글 변경:");
    // mdify() 메서드 실행 시 "게시글 변경:"을 출력한다.
    int index = this.prompt.inputInt("번호? ");
    // 사용자로부터 숫자를 입력받아 정수로 변환하고 그값을 index에 할당
    // 사용자에게 "번호?"라는 메시지를 표시하고, 사용자의 입력을 문자열로 받아온다.
    if (index < 0 || index >= this.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
      // 사용자로부터 입력받은 게시글번호(index)가 유효한 범위에 속하는지 검사
    }

    Board board = this.boards[index];
    // 배열boards에 지정된 index에 해당하는 Board객체를 가져와서 변수board에 할당
    board.title = this.prompt.input("제목(%s)? ", board.title);
    // 사용자에게 "제목?"을 표시하고, 사용자가 입력한 값으로 board객체의 title속성을 업데이트한다.
    // Prompt.input: 사용자에게 메시지를 표시하고 사용자의 입력을 받아오는 역할
    board.content = this.prompt.input("내용(%s)? ", board.content);
    // 사용자에게 "내용?"을 표시하고, 사용자가 입력한 값으로 board객체의 content속성을 업데이트한다
    board.writer = this.prompt.input("작성자(%s)? ", board.writer);
    // 사용자에게 "작성자?"을 표시하고, 사용자가 입력한 값으로 board객체의 writer속성을 업데이트한다.
    board.createdDate = this.prompt.input("작성일(%s)? ", board.createdDate);
    // 사용자에게 "작성일?"을 표시하고, 사용자가 입력한 값으로 board객체의 createDate속성을 업데이트한다.

  }

  //5.
  void delete() {
    System.out.println("게시글 삭제:");

    int index = this.prompt.inputInt("번호? ");
    // 사용자로부터 숫자를 입력받아 정수로 변환하고 그값을 index에 할당
    // 사용자에게 "번호?"라는 메시지를 표시하고, 사용자의 입력을 문자열로 받아온다.
    if (index < 0 || index >= this.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
      // 사용자로부터 입력받은 게시글번호(index)가 유효한 범위에 속하는지 검사
    }

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
      // for반복문 사용하여 삭제된 위치 index 이후의 모든 요소를 한칸씩 앞으로 이동시킨다.
      // i가 index부터 시작하여 (length-1)까지 반복한다.
      // 현재 인덱스 i의 요소 바로 뒤의 i+1의 값을 대입하여 이동시킨다.
    }
    // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
    // 배열board에서 특정인덱스index에 위치한 요소를 삭제하는 과정을 수행
    // 삭제된 요소 뒤의 요소들은 앞으로 한 칸씩 이동시키고,
    // 배열의 마지막 요소를 null로 설정하여 배열의 길이를 감소시킨다.
    // length--;
    this.boards[--this.length] = null;
    // 배열의 마지막 요소를 null로 설정하고 length를 통해 배열의 길이를 하나 줄인다.
  }
}
