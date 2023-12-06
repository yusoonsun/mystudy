package bitcamp.myapp;
//

public class BoardMenu {
  //public:접근제어자, 다른 클래스에서 접근가능
  //BoardMenu 클래스를 정의한다.

  static Board[] boards = new Board[3];
  // static:정적변수, Board:배열타입, []:배열선언
  // Board[]:Board클래스의 객체를 저장하는 배열
  // boards:배열에 대한 레퍼런스 변수,
  // new:배열생성, Board:타입, [3]:원소개수
  // Board클래스의 객체를 담을수 잇는 크키가 3인 정적배열을 선언하고,
  // 초기화 하는것.
  static int length = 0;
  // 정적으로 선언된 정수형 변수인 length를 '0'으로 초기화하는것.
  // = 0; 초기화 하는것 생략해도 문제없음

  static void printMenu() {
    // void:메서드가 반환하는 값의 데이터형식
    // printMenu(): 메서드
    // 아무런 매개변수를 받지않고, 아무값도 반환하지 않는
    // 정적메서드 선언
    System.out.println("[게시글]");
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

  static void execute() {
    // execute(): 수행결과로 boolean타입의 값을 반환
    printMenu();
    // printMenu() 메서드 호출
    while (true) {
      // while반복문, 조건이 true이면, 무한실행
      String input = Prompt.input("메인/게시글> ");
      // Prompt 클래스의 String input으로부터
      // "메인/게시글>"을 호출하여 입력받고,
      // 출력한다.

      switch (input) {
        // switch 조건문
        // input 변수값에 따라 다른 코드블록을 실행
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }
  // case="1"일때, add() 메서드를 호출하고 break;
  // case="2"일때, view() 메서드를 호출하고 break;
  // case="3"일때, modify() 메서드를 호출하고 break;
  // case="4"일때, delete() 메서드를 호출하고 break;
  // case="5"일때, list() 메서드를 호출하고 break;
  // case="0"일때, 현재 메서드를 종료하고 return;
  // case="menu"일때, printMenu()메서드를 호출하고 break;
  // default: 어떤 case도 해당하지 않을때, "메뉴 번호가 옮지않습니다." 출력


  static void add() {
    System.out.println("게시글 등록:");

    if (length == boards.length) {
      int oldSize = boards.length;
      int newSize = oldSize + (oldSize >> 1);
      // oldSize 를 오른쪽으로 1bit 이동

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = boards[i];
      }

      boards = arr;
    }

    Board board = new Board();
    board.title = Prompt.input("제목? ");
    board.content = Prompt.input("내용? ");
    board.writer = Prompt.input("작성자? ");
    board.createdDate = Prompt.input("작성일? ");

    boards[length++] = board;
    // length++;
  }

  static void list() {
    System.out.println("게시글 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }

  static void view() {
    System.out.println("게시글 조회:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
      // 메서드를 멈춘다.
    }

    Board board = boards[index];
    // boards 메서드의 index 값을 가져온다.
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);

  }

  static void modify() {
    System.out.println("게시글 변경:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = boards[index];
    board.title = Prompt.input("제목(%s)? ", board.title);
    board.content = Prompt.input("내용(%s)? ", board.content);
    board.writer = Prompt.input("작성자(%s)? ", board.writer);
    board.createdDate = Prompt.input("작성일(%s)? ", board.createdDate);

  }

  static void delete() {
    System.out.println("게시글 삭제:");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      boards[i] = boards[i + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
    }
//    length--;
    boards[--length] = null;

  }
}
