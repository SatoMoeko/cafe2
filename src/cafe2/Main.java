package cafe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(":::カフェ:::\n");
		Scanner scan = new Scanner(System.in);
		File file = new File("save.csv");
		List<Player> list = new ArrayList<>();

		// メニュー画面
		while (true) {
			System.out.println("\n~start menu~");
			System.out.print("new cafe open:1\nつづきから:2\nおわり:3\n>");
			int select = new Scanner(System.in).nextInt() - 1;

			switch (select) {
			case 0: //新しいカフェを開く
				System.out.print("\ncafeの名前を決めてね>>");
				String name = new Scanner(System.in).nextLine();
				Player player = new Player(name, 0, 0, 10);
				list.add(player);
				System.out.println(player.getName() + " cafeがオープンしたよ\n");

				work(player);
				save(file, list);
				break;

			case 1: //つづきからはじめる
				if (file.exists()) {
					list = load(file);
				} else {
					list = new ArrayList<>();
				}
				if (list.size() == 0) {
					System.out.println("データがありません");
				} else {
					displayList(list);
				}
				System.out.printf("\n遊ぶデータを選んでね\n>");
				int no = new Scanner(System.in).nextInt();
				Player player1 = list.get(no);
				System.out.println(player1.getName() + " cafeに出勤したよ\n");

				work(player1);
				save(file, list);
				break;

			case 2: //終了する
				System.out.println("アプリを終了します。");
				return;
			default:
				System.out.println("1～3から選んでね");
			}
		}
	}

	//仕事する
	public static void work(Player player) {

		while (true) {
			if (player.getHp() > 0) {
				System.out.println("なにする?");
				System.out.print("掃除する:1\nさぼる:2\nSNSをチェックする:3\n>");
				int jobSelect = new Scanner(System.in).nextInt() - 1;
				int random = new Random().nextInt(4);
				if (random == 2) {
					player.serve(player);//接客する
				} else {
					switch (jobSelect) {
					case 0://掃除する
						player.clean();
						break;
					case 1://さぼる
						player.skip();
						break;
					case 2://SNSを更新する
						player.sns();
						break;
					default:
						System.out.println("1～3どれかから選んでね\n");
					}
				}
			} else {
				System.out.println("\n閉店の時間です！おつかれさま");
				player.showLevel();
				System.out.println("《今日のひとこと》");
				player.showRank();

				//続けるか否か
				System.out.print("\n明日も働く?\nはい:1 おやすみする:2\n>");
				int select = new Scanner(System.in).nextInt() - 1;

				switch (select) {
				case 0:
					System.out.println("あたらしい朝が来た！");
					System.out.println(player.getName() + " cafeに出勤したよ\n");
					player.setHp(10);
					break;
				case 1:
					return;
				default:
					System.out.println("1と2から選んでね\n");
				}

			}
		}
	}

	//保存リスト表示
	static void displayList(List<Player> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("No.%d≫%s", i, list.get(i).showLevel());
		}
	}

	//保存
	public static void save(File file, List<Player> list) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
			for (Player player : list) {
				bw.write(player.toCSV());
				bw.newLine(); //セーブしたい情報の書き込み
			}
		} catch (IOException e) {
			;
		}
	}

	//読み込み
	public static List<Player> load(File file) {
		List<Player> list = new ArrayList<Player>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] param = line.split(",");
				String name = param[0];
				int cafeLevel = Integer.parseInt(param[1]);
				int personalLevel = Integer.parseInt(param[2]);
				int hp = 10;
				Player player = new Player(name, cafeLevel, personalLevel, hp);
				list.add(player);
			}
		} catch (IOException e) {
			;
		}
		return list; //インスタンスを作って返す

	}

}
