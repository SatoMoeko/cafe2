package cafe2;

import java.util.Scanner;

public class Customer1 extends Customer {

	public Customer1() {
		super("しばいぬ", 0);
	}

	//クイズ選択
	public void choiceQuiz(Player player) {

		if (this.love <= 35) {
			customerQuiz1(player);
		} else if (this.love < 80) {
			customerQuiz2(player);
		} else if (this.love >= 80) {
			customerQuiz3(player);
		}

	}

	//クイズ１
	public void customerQuiz1(Player player) {
		System.out.println(this.name + "「甘くてぽかぽかするのがいいな」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect == "チョコドーナツ" && drinkSelect == "ホットミルク") {
			System.out.println("「最高！またくるね」");
			player.countLevel(20, 20, -5);
			super.countLove(40);
		} else if (foodSelect == "チョコドーナツ" || drinkSelect == "ホットミルク") {
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

		if (foodSelect == "豆ミートパイ" && drinkSelect == "サイダー") {
			System.out.println("「これこれ！午後も仕事がんばれそう！」");
			player.countLevel(20, 20, -5);
			super.countLove(45);
		} else if (foodSelect == "豆ミートパイ" || drinkSelect == "サイダー") {
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
	public void customerQuiz3(Player player) {
		System.out.println(this.name + "「ちわ！今日は同僚もつれてきたよ。おしゃれなのおねがい」\n");
		System.out.println("かいけん「すごくいいらしいって聞いてきちゃった！かるいやつほしいな」\n");
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

		if ((foodSelect == "スコーン" && drinkSelect == "アイスティー") && (foodSelect1 == "いぬグミ" && drinkSelect1 == "レモン水")) {
			System.out.println(this.name + "「すっかり" + player.name + " cafeがお気に入りだよ！」");
			System.out.println("かいけん「" + player.name + "さんのセレクトいけてるね」");
			player.countLevel(30, 30, -5);
			super.countLove(-100);
		} else if ((foodSelect == "スコーン" || drinkSelect == "アイスティー")
				&& (foodSelect1 == "いぬグミ" || drinkSelect1 == "レモン水")) {
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
