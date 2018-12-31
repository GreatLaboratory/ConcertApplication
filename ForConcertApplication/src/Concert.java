import java.util.Scanner;

public class Concert {
	private String hallName;
	private Group[] group = new Group[3];
	private Scanner scanner = new Scanner(System.in);

	public Concert(String hallName) {
		this.hallName = hallName;
		group[0] = new Group('S', 10); // S 타입 좌석 생성
		group[1] = new Group('A', 10); // A 타입 좌석 생성
		group[2] = new Group('B', 10); // B 타입 좌석 생성

	}

	private void reserve() { // 콘서트 예약
		System.out.print("좌석구분 S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("잘못된 좌석 타입입니다.");
			return;
		}
		group[type - 1].reserve();

	}

	private void search() { // 콘서트 예약 검색
		for (int i = 0; i < group.length; i++)
			group[i].show();
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}

	private void cancel() { // 콘서트 예약 취소
		System.out.print("좌석 S:1, A:2, B:3>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("잘못된 좌석 타입입니다.");
			return;
		}
		group[type - 1].cancel();
	}

	public void run() { // 콘서트 예약/취소/검색 등
		System.out.println(hallName + " 예약 시스템입니다.");
		int choice = 0;
		while (choice != 4) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // 예약
				reserve();
				break;
			case 2: // 조회
				search();
				break;
			case 3: // 취소
				cancel();
				break;
			case 4: // 끝내기
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
