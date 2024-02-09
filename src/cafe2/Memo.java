package cafe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Memo {

	int hp;

	public Memo() {
		this.hp = hp;
	}

	public void memory() {
		File file = new File("save1.csv");
		//リストをつくる
		Map<String,Integer> dogs=new HashMap<String,Integer>();
		
		
//		//いぬインスタンス化
//		Customer1 c1 = new Customer1();
//		Customer2 c2 = new Customer2();
//		Customer3 c3= new Customer3();
//		//それぞれリストに格納
//		dogs.add(c1);
//		dogs.add(c2);
//		dogs.add(c3);

	}
	
	//保存
		public static void save(File file, Map<String,Integer> dogs) {
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
		public static Map<String,Integer> load(File file) {
			Map<String,Integer> dogs=new HashMap<String,Integer>();

			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] param = line.split(",");
					String name = param[0];
					int love = Integer.parseInt(param[1]);
					
					// 名前が一致している場合は加算、そうじゃなければ新規追加
					if (dogs.containsKey(name)) {
						dogs.put(name, dogs.get(name) + love);
					} else {
						dogs.put(name, love);
					}
					
					
					
					
				}
			} catch (IOException e) {
				;
			}
			return dogs; //インスタンスを作って返す

		}
	

}
