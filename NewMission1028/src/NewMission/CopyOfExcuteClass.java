package NewMission;

import java.util.ArrayList;
import java.util.Scanner;

public class CopyOfExcuteClass {
  static String command;
  public static void main(String[] args) {
    ArrayList<String[]> list = new ArrayList<String[]>();
    Scanner scanner = new Scanner(System.in);
    System.out.print("명령> ");
    while(!(command = scanner.nextLine())
        .substring(0, 4)
        .equals("exit")){
      if(command.substring(0, 3).equals("add")){
        list.add(command.substring(4).split(" "));
      } else if(command.substring(0, 4).equals("list")){
        for(int i = 0; i < list.size(); i++){
          System.out.println(i + " " 
              + " " + list.get(i)[0] 
                  + " " + list.get(i)[1] 
                      + " " + list.get(i)[2] 
                          + " " + list.get(i)[3]);
        }
      } else if(command.substring(0, 4).equals("help")){
        System.out.println("list");
        System.out.println("view 인덱스");
        System.out.println("add 이름 국어 영어 수학");
        System.out.println("delete 인덱스");
        System.out.println("update 인덱스");
        System.out.println("exit");


      } else if(command.substring(0, 4).equals("view")){


        int i = Integer.parseInt(command.substring(5, 6));
        int total = Integer.parseInt(list.get(i)[1]) 
            + Integer.parseInt(list.get(i)[2])
            + Integer.parseInt(list.get(i)[3]);
        float aver = total / 3f;
        System.out.println("인덱스: " + i);
        System.out.println("이름: " + list.get(i)[0]);
        System.out.println("국어: " + list.get(i)[1]);
        System.out.println("영어: " + list.get(i)[2]);
        System.out.println("수학: " + list.get(i)[3]);
        System.out.println("합계: " + total);
        System.out.println("평균: " + aver);
      } else if(command.substring(0, 6).equals("delete")){
        int i = Integer.parseInt(command.substring(7, 8));
        String ss;
        System.out.print(list.get(i)[0] + "의 성적을 삭제하시겠습니까?(y/n) ");
        if((ss = scanner.nextLine()).equals("y")){
          System.out.println("삭제하였습니다.");
          list.remove(i);
        }else if(ss.equals("n")){
          System.out.println("삭제 취소하였습니다.");
        }
      } else if(command.substring(0, 6).equals("update")){
        int i = Integer.parseInt(command.substring(7, 8));
        String name;
        String kor;
        String eng;
        String math;
        System.out.print("이름("+ list.get(i)[0] + ")? ");
        if((name = scanner.nextLine()).equals("")){
          name = list.get(i)[0];
        }
        
      }
       
      System.out.print("\n명령> ");
    }//while


  }//main()



}//class










