package cafe2;

public class TextSpeed {
	
	public void text() throws InterruptedException {
	// 表示したい文章
	String text = "吾輩は猫である。名前はまだないよ〜〜〜。";

	// 文章の表示スピード(ミリ秒)
	int dispSpeedMsec = 100;

	// 文章表示実行
	showText(text, dispSpeedMsec);
	}
	
	public static void showText(String text, int dispSpeedMsec) throws InterruptedException {
		String[] textArray = text.split("");

		for (int i = 0; i < textArray.length; i++) {
			// 文字を表示
			System.out.print(textArray[i]);

			// dispSpeedMsecの時間だけ処理を停止
			Thread.sleep(dispSpeedMsec);
		}

	}
}
