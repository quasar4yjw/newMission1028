package NewMission;

import java.util.ArrayList;
import java.util.Scanner;

public class ExcuteClass {
  static String command;
  static String[] studentInfo;

  public static void main(String[] args) throws RuntimeException{
    ArrayList<String[]> list = new ArrayList();
    System.out.print("명령> ");
    Scanner scanner = new Scanner(System.in);
    while (!(command = scanner.nextLine())
        .substring(0, 4)
        .equalsIgnoreCase("exit")) {
      
      
      if(command
          .substring(0, 3)
          .equalsIgnoreCase("add")) {

        list.add(command.substring(4).split(" "));
        System.out.println("저장되었습니다.");

      }//if add
      
      
      else if(command
          .substring(0, 4)
          .equalsIgnoreCase("list")) {


        for (int i = 0; i < list.size(); i++){
          System.out.print(i +" "+ list.get(i)[0] 
              +" "+ list.get(i)[1] 
                  +" "+ list.get(i)[2] 
                      +" "+ list.get(i)[3]);
        }
      }//if list
      
      else if(command
          .substring(0, 4)
          .equalsIgnoreCase("help")) {

        
        System.out.println("list");
        System.out.println("view 인덱스");
        System.out.println("add 이름 국어 영어 수학");
        System.out.println("delete 인덱스");
        System.out.println("update 인덱스");
        System.out.println("exit");
        
      }//if help
      
      else if(command
          .substring(0, 4)
          .equalsIgnoreCase("view")) {
       
 
        int i = Integer.parseInt(command.substring(5, 6));
        int total = Integer.parseInt(list.get(i)[0])
            +Integer.parseInt(list.get(i)[0])
            +Integer.parseInt(list.get(i)[0]);
        float aver = total / 3f ;
          System.out.println("인덱스: " + i);
          System.out.println("이름: " + list.get(i)[0]);
          System.out.println("국어: " + list.get(i)[1]);
          System.out.println("영어: " + list.get(i)[2]);
          System.out.println("수학: " + list.get(i)[3]);
          System.out.println("합계: " + total);
          System.out.println("평균: " + aver);
      }//if view

      System.out.print("\n명령> ");
    }//while

  }
}










