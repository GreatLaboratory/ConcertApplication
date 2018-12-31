import java.util.Scanner;

public class Group {
   private char type; // 'S', 'A', 'B' 석을 나타내는 문자 
   private Seat[] seats; // 현재 등급의 좌석 객체 배열
   private Scanner scanner = new Scanner(System.in);
   
   public Group(char type, int num) {
	   this.type = type;
	   seats = new Seat[num];
	   for (int i=0; i<seats.length; i++)
		   seats[i] = new Seat();
   }
   public boolean reserve() { // 현재 등급의 좌석 예약
	   int no;
	   String name;
	   show();
	   System.out.print("이름>>");
	   name = scanner.next();
	   System.out.print("번호>>");
	   no = scanner.nextInt();
	   if (no < 1 || no >= seats.length) {
		   System.out.println("잘못된 좌석번호입니다.");
		   return false;
	   }
	   if (seats[no-1].isOccupied()) { // 이미 예약된 좌석 번호
		   System.out.println("이미 예약된 좌석입니다.");
		   return false;
	   }
	   seats[no-1].reserve(name);
	   return true;
   }
   public boolean cancel() { // 현재 등급의 좌석 취소
	   show();
	   System.out.print("이름>>"); // 취소할 예약자 이름 입력
	   String name = scanner.next();
	   if (name != null) {
		   for (int i=0;i<seats.length; i++) {
			   if (seats[i].match(name)) {
				   seats[i].cancel();
				   return true;
			   }
		   }
		   System.out.println("예약자 이름을 찾을 수 없습니다.");
	   }
	   return false; // 예약자 이름을 찾지 못함
   }
   
   public void show() { // 현재 등급의 좌석 출력
	   System.out.print(type + ">> ");
	   for (int i=0; i<seats.length; i++) {
		   if (seats[i].isOccupied())
			   System.out.print(seats[i].getName());
		   else
			   System.out.print("---");
		   System.out.print(" ");
	   }
	   System.out.println();
   }
}
