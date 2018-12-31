import java.util.Scanner;

public class Concert {
	private String hallName;
	private Group[] group = new Group[3];
	private Scanner scanner = new Scanner(System.in);

	public Concert(String hallName) {
		this.hallName = hallName;
		group[0] = new Group('S', 10); // S Ÿ�� �¼� ����
		group[1] = new Group('A', 10); // A Ÿ�� �¼� ����
		group[2] = new Group('B', 10); // B Ÿ�� �¼� ����

	}

	private void reserve() { // �ܼ�Ʈ ����
		System.out.print("�¼����� S(1), A(2), B(3)>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
			return;
		}
		group[type - 1].reserve();

	}

	private void search() { // �ܼ�Ʈ ���� �˻�
		for (int i = 0; i < group.length; i++)
			group[i].show();
		System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
	}

	private void cancel() { // �ܼ�Ʈ ���� ���
		System.out.print("�¼� S:1, A:2, B:3>>");
		int type = scanner.nextInt();
		if (type < 1 || type > 3) {
			System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
			return;
		}
		group[type - 1].cancel();
	}

	public void run() { // �ܼ�Ʈ ����/���/�˻� ��
		System.out.println(hallName + " ���� �ý����Դϴ�.");
		int choice = 0;
		while (choice != 4) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // ����
				reserve();
				break;
			case 2: // ��ȸ
				search();
				break;
			case 3: // ���
				cancel();
				break;
			case 4: // ������
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
}
