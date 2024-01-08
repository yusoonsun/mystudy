package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam001 {

  static void printSpaces(int spaceLen) {
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) { // argument
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int starLen) {
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  } // 변수 호출 끝나면 사라짐

  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }

  static int promptInt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();

    return len;
  }

  public static void main(String[] args) {
    int len = promptInt("밑변의 길이? ");

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaceLength(len, starLen)); // 메서드 호출 (len - starLen) / 2); // argument 값을
                                                     // 가져오는 파라미터
      printStars(starLen);
      System.out.println();
    }
  }
}
