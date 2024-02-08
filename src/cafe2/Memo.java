package cafe2;

import java.util.ArrayList;
import java.util.List;

public class Memo {

	int hp;

	public Memo() {
		this.hp = hp;
	}

	public void memory() {
		//リストをつくる
		List<Customer> dogs = new ArrayList<>();
		//いぬたちを客012ととらえ、インスタンス化
		Customer[] customer = new Customer[3];
		customer[0] = new Customer1();
		customer[1] = new Customer2();
		customer[2] = new Customer3();
		//それぞれリストに格納
		dogs.add(customer[0]);
		dogs.add(customer[1]);
		dogs.add(customer[2]);

		for (Customer c : customer) {

		}

	}
}
