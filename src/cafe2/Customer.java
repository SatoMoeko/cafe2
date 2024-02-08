package cafe2;

public class Customer {
	String name;
	int love;

	public Customer() {
		this.name = name;
		this.love = love;
	}

	//クイズ部分
	public void customerQuiz() {

	}

	//親愛度操作
	public void countLove(Player player, int giveLove) {
		//現在のレベルから親愛度を増減する
		setLove(getLove() + giveLove);
	}

	//カプセル化
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLove() {
		return this.love;
	}

	public void setLove(int love) {
		this.love = love;
	}
}
