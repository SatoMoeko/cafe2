package cafe2;

import java.util.Random;
import java.util.Scanner;

public class Player {
	String name;
	int cafeLevel;
	int personalLevel;
	int hp;

	public Player(String name, int cafeLevel, int personalLevel, int hp) {
		this.name = name;
		this.cafeLevel = cafeLevel;
		this.personalLevel = personalLevel;
		this.hp = hp;

	}

	//レベル操作
	public void countLevel(int giveCL, int givePL, int giveHp) {
		//現在のレベルから任意CLを増減する
		setCafeLevel(getCafeLevel() + giveCL);
		System.out.print("お店の評判：" + giveCL + "level ");
		System.out.println(giveCL < 0 ? "down!" : "up!");
		//現在のレベルから任意PLを増減する
		setPersonalLevel(getPersonalLevel() + givePL);
		System.out.print("店員レベル：" + givePL + "level ");
		System.out.println(givePL < 0 ? "down!" : "up!");
		//体力を引く
		setHp(getHp() + giveHp);
		System.out.println("残りの体力は" + this.hp + "！\n");
	}

	//掃除する
	public void clean() {
		int random = new Random().nextInt(5);
		switch (random) {
		case 0:
			System.out.println("\nシンクをぴかぴかに磨いた。集中しすぎて3時間経っていた");
			countLevel(5, -5, -2);
			break;
		case 1:
			System.out.println("\n床の掃き掃除をした。気持ちがいい");
			countLevel(5, 5, -1);
			break;
		case 2:
			System.out.println("\n冷蔵庫を整頓した。仕事のスピードがあがった");
			countLevel(5, 5, 1);
			break;
		case 3:
			System.out.println("\n机と椅子を拭いた。飲食店に清潔感は大切");
			countLevel(10, 5, -1);
			break;
		default:
			System.out.println("\n食器を洗った。うっかりカップを落として割った");
			countLevel(-5, -5, -1);

		}
	}

	//SNSを更新する
	public void sns() {
		int random = new Random().nextInt(5);
		switch (random) {
		case 0:
			System.out.println("\n新作メニューを宣伝した。結構みてもらえた");
			countLevel(30, 10, -1);
			break;
		case 1:
			System.out.println("\n店内を撮影してのせてみた。あんまり反応はない");
			countLevel(5, 5, -1);
			break;
		case 2:
			System.out.println("\nおいしかったと言ってくれてる人がいる！いいね");
			countLevel(20, 10, -1);
			break;
		case 3:
			System.out.println("\n店員に愛想がないと口コミされてた……。反省");
			countLevel(-10, -20, -1);
			break;
		default:
			System.out.println("\nプライベート用のSNSと間違えて投稿したけどなんかうけた。");
			countLevel(10, -5, -1);
		}
	}

	

	//さぼる
	public void skip() {
		int random = new Random().nextInt(5);
		switch (random) {
		case 0:
			System.out.println("\nマインスイーパーたのしすぎる");
			countLevel(-5, -10, 1);
			break;
		case 1:
			System.out.println("\nひたすら猫ミームを見てた");
			countLevel(-5, -5, 1);
			break;
		case 2:
			System.out.println("\n昼休みに仮眠をとったら30分寝過ごした");
			countLevel(-5, -10, -1);
			break;
		case 3:
			System.out.println("\n外を眺めてぼんやりした。お客さんこないかな……");
			countLevel(-1, -1, 1);
		default:
			System.out.println("\n偵察と称して隣町のカフェにいった。ケーキおいしい");
			countLevel(5, -5, -2);
		}
	}

	//接客する
	public void serve() {
		System.out.println("\nお客さんがきた！");
		System.out.printf("接客する:1\n無視する:2\n>");
		int select = new Scanner(System.in).nextInt();
		

		switch (select) {
		case 0://接客する
			System.out.println("\nいらっしゃいませ！ご注文は？");
			int random = new Random().nextInt(3);
			switch(random) {
			case 0:
			
				break;
			case 1:
			
				break;
			default:
			
			}
			break;
		case 2://無視する
			System.out.println("\n最低のcafeだね");
			countLevel(-50, -50, -5);
			break;
		default:
			System.out.println("1と2から選んでね\n");
		}

	}

	//レベル表示
	String showLevel() {
		return String.format("%s cafe\nお店の評判：%dlevel\n店員レベル：%dlevel\n", this.name, this.cafeLevel, this.personalLevel);
	}

	//カフェ評価
	public void showRank() {
		//お店の評判
		if (this.cafeLevel <= 0) {
			System.out.println("閑古鳥ないてる。このままじゃやばい。");
		} else if (this.cafeLevel <= 30 && this.cafeLevel > 0) {
			System.out.println("ふつうのcafe。あればはいるくらい。");
		} else if (this.cafeLevel <= 50 && this.cafeLevel > 30) {
			System.out.println("町で人気のcafe。常連さんもいるね。");
		} else if (this.cafeLevel <= 80 && this.cafeLevel > 50) {
			System.out.println("話題のcafe。ランチタイムは行列！");
		} else if (this.cafeLevel > 80) {
			System.out.println("ミシュランにのった！予約しなきゃはいれない！");
		}

		//店員レベル
		if (this.personalLevel <= 0) {
			System.out.println("店員としてもっとがんばれることがあるはず。");
		} else if (this.personalLevel <= 30 && this.personalLevel > 0) {
			System.out.println("きちんと働いててえらい。");
		} else if (this.personalLevel <= 50 && this.personalLevel > 30) {
			System.out.println("仕事に一生懸命な姿が評価されてる。");
		} else if (this.personalLevel <= 80 && this.personalLevel > 50) {
			System.out.println("事業拡大を視野にいれる。店長から社長へ。");
		} else if (this.personalLevel > 80) {
			System.out.println("メディアでもひっぱりだこ。ここまでよくがんばりました。");
		}
	}

	//データをcsv形式の文字列に変換
	public String toCSV() {
		return String.format("%s,%d,%d", this.name, this.cafeLevel, this.personalLevel);
	}

	//カプセル化
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonalLevel() {
		return this.personalLevel;
	}

	public void setPersonalLevel(int persosnalLevel) {
		this.personalLevel = persosnalLevel;
	}

	public int getCafeLevel() {
		return this.cafeLevel;
	}

	public void setCafeLevel(int cafeLevel) {
		this.cafeLevel = cafeLevel;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
