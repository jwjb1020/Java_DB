package mission;

import java.util.ArrayList;
import java.util.Scanner;

public class MissonQuery {

	class QueryExe {
		int num;
		String text;

		QueryExe(int num, String text) {
			this.num = num;
			this.text = text;
		}

		int getNum() {
			return num;
		}

		String getText() {
			return text;
		}
	}

	public static void main(String[] args) {
		ArrayList<QueryExe> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		while (true) {
			for (QueryExe qe : list) {
				System.out.println(String.format("%d,%s", qe.getNum(), qe.getText()));

			}

			System.out.println("선택<0:나가기>:");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("종료합니다.");
				break;
			}

			for (QueryExe qe : list) {
				if (qe.getNum() == sel) {

				}
			}
		}

	}

}
