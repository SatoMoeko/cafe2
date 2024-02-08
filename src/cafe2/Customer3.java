package cafe2;

import java.util.Scanner;

public class Customer3 extends Customer {

	public Customer3() {
		setName("サモエド");
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
		System.out.println(this.name + "「お腹がすいて仕方ないからはやく！」\n");
		foodMenu();
		int foodSelect = new Scanner(System.in).nextInt();
		drinkMenu();
		int drinkSelect = new Scanner(System.in).nextInt();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect == 1 && drinkSelect == 1) {
			System.out.println("「最高！またくるね」");
			player.countLevel(20, 20, -5);
			super.countLove(player, 40);
		} else if (foodSelect == 1 || drinkSelect == 1) {
			System.out.println("「まあまあだね～」");
			player.countLevel(10, 10, -5);
			super.countLove(player, 30);
		} else {
			System.out.println("「やるきある？」");
			player.countLevel(-10, -10, -5);
			super.countLove(player, -10);
		}
	}

	//クイズ２
	public void customerQuiz2(Player player) {
		System.out.println(this.name + "「またきたよ～！今日は元気になれる感じがいいな」\n");
		foodMenu();
		int foodSelect = new Scanner(System.in).nextInt();
		drinkMenu();
		int drinkSelect = new Scanner(System.in).nextInt();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect == 3 && drinkSelect == 3) {
			System.out.println("「これこれ！午後も仕事がんばれそう！」");
			player.countLevel(20, 20, -5);
			super.countLove(player, 45);
		} else if (foodSelect == 3 || drinkSelect == 3) {
			System.out.println("「ありがとね～」");
			player.countLevel(10, 10, -5);
			super.countLove(player, 30);
		} else {
			System.out.println("「ふーん」");
			player.countLevel(-10, -10, -5);
			super.countLove(player, -10);
		}
	}

	//クイズ３
	public void customerQuiz3(Player player) {
		System.out.println(this.name + "「ちわ！今日は同僚もつれてきたよ」\n");
		System.out.println("かいけん「すごくいいらしいって聞いてきちゃった～」\n");
		//しばいぬ
		System.out.print(this.name + "の");
		foodMenu();
		int foodSelect = new Scanner(System.in).nextInt();
		System.out.print(this.name + "の");
		drinkMenu();
		int drinkSelect = new Scanner(System.in).nextInt();
		//かいけん
		System.out.print("かいけんの");
		foodMenu();
		int foodSelect1 = new Scanner(System.in).nextInt();
		System.out.println("かいけんの");
		drinkMenu();
		int drinkSelect1 = new Scanner(System.in).nextInt();
		System.out.println(this.name + "に" + foodSelect + "と" + drinkSelect + "を提供した！");
		System.out.println("かいけんに" + foodSelect1 + "と" + drinkSelect1 + "を提供した！");

		if ((foodSelect == 3 && drinkSelect == 3) && (foodSelect1 == 3 && drinkSelect1 == 3)) {
			System.out.println(this.name + "「すっかり" + player.name + " cafeがお気に入りだよ！」");
			System.out.println("かいけん「" + player.name + "さんのセレクトいけてるね」");
			player.countLevel(30, 30, -5);
			super.countLove(player, -100);
		} else if ((foodSelect == 3 || drinkSelect == 3) && (foodSelect1 == 3 || drinkSelect1 == 3)) {
			System.out.println(this.name + "「ついつい長居したくなるんだよね」");
			System.out.println("かいけん「ほかのメニューもきになるな～」");
			player.countLevel(20, 20, -3);
			super.countLove(player, 40);
		} else {
			System.out.println(this.name + "「このゆるさがいいよね」");
			System.out.println("かいけん「そうかも」");
			player.countLevel(-10, -10, -5);
			super.countLove(player, -10);
		}
	}

	//フードメニュー表示
	public void foodMenu() {
		System.out.println("食べ物は何を提供する？");
		System.out.print("アイスクリーム:1\n食パン:2\nピザ:3\nラムネ:4\n>");
	}

	//ドリンクメニュー表示
	public void drinkMenu() {
		System.out.println("飲み物は何を提供する？");
		System.out.print("ホットミルク:1\nアイスコーヒー:2\nニンジンジュース:3\n桃水:4\n>");
	}

}
