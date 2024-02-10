package cafe2;

import java.util.Scanner;

public class Customer3 extends Customer {

	public Customer3(String name, int love) {
		super("サモエド", love);
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
		System.out.println(this.name + "「お腹がすいて仕方ない！」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("ピザ") && drinkSelect.equals("野菜ジュース")) {
			System.out.println("「おなかいっぱい！幸せだ～」");
			player.countLevel(20, 20, -5);
			super.countLove(40);
		} else if (foodSelect.equals("ピザ") || drinkSelect.equals("野菜ジュース")) {
			System.out.println("「ちょっとたりないんですが……」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「ぜんぜん満足できない」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ２
	public void customerQuiz2(Player player) {
		System.out.println(this.name + "「前回とおんなじので！」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("ピザ") && drinkSelect.equals("野菜ジュース")) {
			System.out.println("「わーい！これがおいしんだ！」");
			player.countLevel(20, 20, -5);
			super.countLove(45);
		} else if (foodSelect.equals("ピザ") || drinkSelect.equals("野菜ジュース")) {
			System.out.println("「なんかちがうけど、まいっか」");
			player.countLevel(10, 10, -5);
			super.countLove(30);
		} else {
			System.out.println("「わすれちゃったか……」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//クイズ３
	public void customerQuiz3(Player player) {
		System.out.println(this.name + "「じつは甘党なの！」\n");
		String foodSelect = foodMenu();
		String drinkSelect = drinkMenu();
		System.out.println(this.name + "に" + foodSelect + "と" + drinkSelect + "を提供した！");

		if (foodSelect.equals("アイスクリーム") && drinkSelect.equals("ホットココア")) {
			System.out.println(this.name + "「" + player.name + " cafeにくると心もお腹も大満足だよ」");
			player.countLevel(30, 30, -5);
			super.countLove(-100);
		} else if (foodSelect.equals("アイスクリーム") || drinkSelect.equals("ホットココア")) {
			System.out.println(this.name + "「こういう日もあり、たまにはね」");
			player.countLevel(20, 20, -3);
			super.countLove(40);
		} else {
			System.out.println(this.name + "「おいしいならなんでもいいか」");
			player.countLevel(-10, -10, -5);
			super.countLove(-10);
		}
	}

	//フードメニュー表示
	public String foodMenu() {
		System.out.println("食べ物は何を提供する？");
		String[] foods = { "アイスクリーム", "食パン", "ピザ", "ラムネ" };
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
		String[] drinks = { "ホットココア", "アイスコーヒー", "野菜ジュース", "桃水" };
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i] + ":" + (i + 1));
		}
		System.out.print(">");
		int num = new Scanner(System.in).nextInt() - 1;
		String drinkSelect = drinks[num];
		return drinkSelect;
	}

}
