package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {

  static Scanner keyIn = new Scanner(System.in);

  static String input(String title, Object... args) {
    // String 스태틱의 format 메서드
    // 문자열의 형식을 설정
    System.out.printf(String.format(title, args));
    return keyIn.nextLine();
  }

  static void close() {
    keyIn.close();
  }
}
