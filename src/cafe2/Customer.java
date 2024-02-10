package cafe2;

public class Customer {
	String owner;
	String name;
	int love;

	public Customer(String owner,String name, int love) {
		this.owner = owner;
		this.name = name;
		this.love = love;
	}

	//クイズ選択
	public void choiceQuiz(Player player) {

	}

	//クイズ部分
	public void customerQuiz(Player player) {

	}

	//親愛度操作
	public void countLove(int giveLove)  {
		//現在のレベルから親愛度を増減する
		setLove(getLove() + giveLove);
	}

	//データをcsv形式の文字列に変換
	public String toCSV() {
		return String.format("%s,%d", this.name, this.love);
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
