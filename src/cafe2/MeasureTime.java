package cafe2;

public class MeasureTime {
	static long startTime; // 開始時間
	static long endTime; // 終了時間

	// 計測開始
	public static void start() {
		MeasureTime.startTime = System.currentTimeMillis();
	}

	// 計測終了
	public static void end() {
		MeasureTime.endTime = System.currentTimeMillis();
	}

	// 計測時間の取得
	public static long getTime() {
		if (endTime < startTime) {
			return 0L;
		}
		return MeasureTime.endTime - MeasureTime.startTime;
	}
}
