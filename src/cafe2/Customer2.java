package cafe2;

import java.util.Scanner;

public class Customer2 extends Customer {

	public Customer2(String name, int love) {
		super("ポメ", love);
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
		System.out.println(this.name + "「ねむいから目が覚めるやつください！」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("ハンバーガー") && drinkSelect.equals("ホットコーヒー")) {
			System.out.println("「ガツンときた！やるぞやるぞ」");
			player.countLevel(20, 20, -5);
			super.countLove(40);
		} else if (foodSelect.equals("ハンバーガー") || drinkSelect.equals("ホットコーヒー")) {
			System.out.println("「わるくないね～」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「これじゃないかも……」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ２
	public void customerQuiz2(Player player) {
		System.out.println(this.name + "「今日はちょっと急いでるんだけどいけるかな」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("") && drinkSelect.equals("")) {
			System.out.println("「ありがとう！たすかる！」");
			player.countLevel(20, 20, -5);
			super.countLove(45);
		} else if (foodSelect.equals("") || drinkSelect.equals("")) {
			System.out.println("「ギリギリ！」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「おそいよ～」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ３
	public void customerQuiz3(Player player) {
		System.out.println(this.name + "「のんびり散歩ついでにおやつたべにきたよ」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(this.name + "に" + foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("カップケーキ") && drinkSelect.equals("いぬフラッペ")) {
			System.out.println(this.name + "「" + player.name + " cafeってつい毎日来たくなる」");
			player.countLevel(30, 30, -5);
			super.countLove(-100);
		} else if (foodSelect.equals("カップケーキ") || drinkSelect.equals("いぬフラッペ")) {
			System.out.println(this.name + "「いつも安定のよさある！」");
			player.countLevel(20, 20, -3);
			super.countLove(40);
		} else {
			System.out.println(this.name + "「あきてきたかも～メニューかえたほうがいいんじゃない」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//フードメニュー表示
	public String foodMenu() {
		System.out.println("食べ物は何を提供する？");
		String[] foods = { "カップケーキ", "ワッフル", "ハンバーガー", "ほねガム" };
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
		String[] drinks = { "ホットコーヒー", "いぬフラッペ", "ポタージュ", "いちご水" };
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i] + ":" + (i + 1));
		}
		System.out.print(">");
		int num = new Scanner(System.in).nextInt() - 1;
		String drinkSelect = drinks[num];
		return drinkSelect;
	}

}
