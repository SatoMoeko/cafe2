package cafe2;

import java.util.Scanner;

public class Customer1 extends Customer {

	public Customer1(String name, int love) {
		super("しばいぬ", love);
	}

	//クイズ選択
	public void choiceQuiz(Player player)  {
		if (this.love <= 35) {
			customerQuiz1(player);
		} else if (this.love < 80) {
			customerQuiz2(player);
		} else if (this.love >= 80) {
			try {
				customerQuiz3(player);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	//クイズ１
	public void customerQuiz1(Player player) {
		System.out.println(this.name + "「甘くてぽかぽかするのがいいな」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("チョコドーナツ") && drinkSelect.equals("ホットミルク")) {
			System.out.println("「最高！またくるね」");
			player.countLevel(20, 20, -5);
			super.countLove(40);
		} else if (foodSelect.equals("チョコドーナツ") || drinkSelect.equals("ホットミルク")) {
			System.out.println("「まあまあだね～」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「やるきある？」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ２
	public void customerQuiz2(Player player) {
		System.out.println(this.name + "「またきたよ～！今日は元気になれる感じがいいな」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("豆ミートパイ") && drinkSelect.equals("サイダー")) {
			System.out.println("「これこれ！午後も仕事がんばれそう！」");
			player.countLevel(20, 20, -5);
			super.countLove(45);
		} else if (foodSelect.equals("豆ミートパイ") || drinkSelect.equals("サイダー")) {
			System.out.println("「ありがとね～」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「ふーん」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ３
	public void customerQuiz3(Player player) throws InterruptedException {
		String text =(this.name + "「ちわ！今日は同僚もつれてきたよ。おしゃれなのおねがい」\n");
		String text2 =("かいけん「すごくいいらしいって聞いてきちゃった！かるいやつほしいな」\n");
		int dispSpeedMsec = 10;
		TextSpeed.showText(text, dispSpeedMsec);
		TextSpeed.showText(text2, dispSpeedMsec);
		//しばいぬ
		System.out.print(this.name + "の");
		String foodSelect = foodMenu();
		System.out.print(this.name + "の");
		String drinkSelect = drinkMenu();
		//かいけん
		System.out.print("かいけんの");
		String foodSelect1 = foodMenu();
		System.out.println("かいけんの");
		String drinkSelect1 = drinkMenu();
		System.out.println(this.name + "に" + foodSelect + "と" + drinkSelect + "を提供した！");
		System.out.println("かいけんに" + foodSelect1 + "と" + drinkSelect1 + "を提供した！");

		if ((foodSelect.equals("スコーン")&& drinkSelect.equals("アイスティー")) && (foodSelect1.equals("いぬグミ") && drinkSelect1.equals("レモン水"))) {
			String text3 =(this.name + "「すっかり" + player.name + " cafeがお気に入りだよ！」\n");
			String text4 =("かいけん「" + player.name + "さんのセレクトいけてるね」");
			TextSpeed.showText(text3, dispSpeedMsec);
			TextSpeed.showText(text4, dispSpeedMsec);
			player.countLevel(30, 30, -5);
			super.countLove(-100);
		} else if ((foodSelect.equals("スコーン") || drinkSelect.equals("アイスティー"))
				&& (foodSelect1.equals("いぬグミ") || drinkSelect1.equals("レモン水"))) {
			System.out.println(this.name + "「ついつい長居したくなるんだよね」");
			System.out.println("かいけん「ほかのメニューもきになるな～」");
			player.countLevel(20, 20, -3);
			super.countLove(40);
		} else {
			System.out.println(this.name + "「このゆるさがいいよね」");
			System.out.println("かいけん「そうかも」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//フードメニュー表示
	public String foodMenu() {
		System.out.println("食べ物は何を提供する？");
		String[] foods = { "チョコドーナツ", "スコーン", "豆ミートパイ", "いぬグミ" };
		for (int i = 0; i < foods.length; i++) {
			System.out.println(foods[i] + ":" + (i + 1));
		}
		System.out.print(">");
		int num = new Scanner(System.in).nextInt() - 1;
		String foodSelect = foods[num];
		return foodSelect;
	}

	//ドリンクメニュー表示
	public String drinkMenu() {
		System.out.println("飲み物は何を提供する？");
		String[] drinks = { "ホットミルク", "アイスティー", "サイダー", "レモン水" };
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i] + ":" + (i + 1));
		}
		System.out.print(">");
		int num = new Scanner(System.in).nextInt() - 1;
		String drinkSelect = drinks[num];
		return drinkSelect;
	}

}
