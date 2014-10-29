package NewMission;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcuteClass {
  static String command;

  public static void main(String[] args) throws Exception, Error{
    ArrayList<String[]> list = new ArrayList();
    FileInputStream in = null;
    DataInputStream in2 = null;
    try{

      in = new FileInputStream("score.dat");
      in2 = new DataInputStream(in);

      String b = "";
      try{
        while(!(b = in2.readUTF()).equals("")) {
          list.add(b.split(","));
          
          in2.close();
          in.close();
        }//while readUTF
      }//try
      catch(EOFException ex){

      }//catch
      
    }catch(FileNotFoundException ex){
      System.out.println("파일이 없습니다");
    }




    

    System.out.print("명령> ");
    Scanner scanner = new Scanner(System.in);
    try{
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
            System.out.println(i +" "+ list.get(i)[0] 
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
          int total = Integer.parseInt(list.get(i)[1])
              +Integer.parseInt(list.get(i)[2])
              +Integer.parseInt(list.get(i)[3]);
          float aver = total / 3f ;
          System.out.println("인덱스: " + i);
          System.out.println("이름: " + list.get(i)[0]);
          System.out.println("국어: " + list.get(i)[1]);
          System.out.println("영어: " + list.get(i)[2]);
          System.out.println("수학: " + list.get(i)[3]);
          System.out.println("합계: " + total);
          System.out.println("평균: " + aver);
        }//if view

        else if(command
            .substring(0, 6)
            .equalsIgnoreCase("delete")) {


          int i = Integer.parseInt(command.substring(7, 8));
          if (list.size() <= i){

            System.out.println("존재하지 않는 인덱스입니다.");
          }else{
            System.out.println(list.get(i)[0] +"의 성적을 삭제하시겠습니까?(y/n)");
            if (scanner.nextLine().equalsIgnoreCase("y")){
              System.out.println("삭제하였습니다.");
              list.remove(i);
            } else {
              System.out.println("삭제 취소하였습니다");
            }
          }

        }//if delete

        else if(command
            .substring(0, 6)
            .equalsIgnoreCase("update")) {

          int i = Integer.parseInt(command.substring(7, 8));

          String name;
          String kor;
          String math;
          String eng;

          System.out.print("이름 "+list.get(i)[0]+" ");
          if((name = scanner.nextLine()).equals("")) {
            name = list.get(i)[0];
          } else;

          System.out.print("국어 "+list.get(i)[1]+" ");
          if((kor = scanner.nextLine()).equals("")) {
            kor = list.get(i)[1];
          } else;

          System.out.print("수학 "+list.get(i)[2]+" ");
          if((math = scanner.nextLine()).equals("")) {
            math = list.get(i)[2];
          } else;

          System.out.print("영어 "+list.get(i)[3]+" ");
          if((eng = scanner.nextLine()).equals("")) {
            eng = list.get(i)[3];
          } else;

          System.out.println("정말 변경하시겠습니까?(y/n)");
          if(scanner.nextLine().equalsIgnoreCase("y")) {
            list.get(i)[0] = name;
            list.get(i)[1] = kor;
            list.get(i)[2] = math;
            list.get(i)[3] = eng;
            System.out.println("변경하였습니다.");
          } else {
            System.out.println("변경 취소하였습니다.");
          }


        }//if update

        System.out.print("\n명령> ");
      }//while


      FileOutputStream out = new FileOutputStream("score.dat");
      DataOutputStream out2 = new DataOutputStream(out);
      for (int i = 0; i < list.size(); i++){
        out2.writeUTF(list.get(i)[0]+","
            +list.get(i)[1]+","
            +list.get(i)[2]+","
            +list.get(i)[3]);
      }
      out2.close();
      out.close();
    }catch (RuntimeException ex){
      main(args);
    } // 아무것도 입력안하거나 글자수 짧거나 
    //등등 에러 캐치하고 main메소드 다시 실행

  }//main()
}//class










