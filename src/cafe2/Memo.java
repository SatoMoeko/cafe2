package cafe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Memo {

	int hp;

	public Memo() {
		this.hp = hp;
	}

	public void memory() {
		File file = new File("save1.csv");
		//リストをつくる
		List<Customer> dogs = new ArrayList<>();
		//リストに格納
		dogs.add(new Customer1("しばいぬ", 0));
		dogs.add(new Customer2("ポメ", 0));
		dogs.add(new Customer3("サモエド", 0));
	}

	//保存
	public static void save(File file, List<Customer> dogs) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
			for (Customer customer : dogs) {
				bw.write(customer.toCSV());
				bw.newLine(); //セーブしたい情報の書き込み
			}
		} catch (IOException e) {
			;
		}
	}

	//読み込み
	public static List<Customer> load(File file) {
		List<Customer> dogs = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] param = line.split(",");
				String name = param[0];
				int love = Integer.parseInt(param[1]);

				if (name == "しばいぬ") {
					Customer1 dog = new Customer1(name, love);
					dogs.add(dog);
				} else if (name == "ポメ") {
					Customer2 dog = new Customer2(name, love);
					dogs.add(dog);
				} else if (name == "サモエド") {
					Customer3 dog = new Customer3(name, love);
					dogs.add(dog);
				}
			}
		} catch (IOException e) {
			;
		}
		return dogs; //インスタンスを作って返す

	}

}
