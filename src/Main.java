import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//題名
		System.out.println("～～たからさがしゲーム～～");
		ArrayList<Treasure> treasures = new ArrayList<Treasure>();

		//宝の種類

			Treasure t1;//硬貨のインスタンス
			t1 = new Treasure();
			t1.name ="硬貨";
			t1.rare = 1;
			t1.price = 100;

			Treasure t2;//指輪のインスタンス
			t2 = new Treasure();
			t2.name ="指輪";
			t2.rare = 2;
			t2.price = 5000;

			Treasure t3;//伝説の宝石のインスタンス
			t3 = new Treasure();
			t3.name ="伝説の宝石";
			t3.rare = 3;
			t3.price = 10000;
		
			Treasure[] types = {t1,t2,t3};

			
			//財布とその中身
			Wallet main;
			main =new Wallet();
			main.name = "財布";
			main.money = 0;
			
			
			
		//選択画面
		while(true) {
			System.out.print("1:探検に出る　2:宝を売る　3:終了");
			int select =new Scanner(System.in).nextInt();

			switch(select) {
			case 1://探検にでる
				//見つけられる宝を作成
					int rand = new Random().nextInt(types.length);
					String treasureName = types[rand].name;
					int treasureRare = types[rand].rare;
					int treasurePrice = types[rand].price;
					System.out.println(treasureName + "を見つけた！レア度：" + treasureRare);
				//見つけた宝物を所持する
					
					Treasure treasure =new Treasure();
					treasure.name =treasureName;
					treasure.rare = treasureRare;
					treasure.price = treasurePrice;
					treasures.add(treasure);
					break;

			case 2://宝を売る
				if(treasures.size() == 0) {//宝物を持っていないとき
					System.out.println("まだ宝物を見つけてないよ！");
				}else {//宝物を持っているとき
					while(true) {
						for (int i = 0; i < treasures.size(); i++) {
							System.out.printf("%d・・・%s[%s](%d)\n", i, treasures.get(i).name, treasures.get(i).rare, treasures.get(i).price);
						}
						//どの宝物にするか選択
						System.out.println("どの宝物を売る？");
						select = new Scanner(System.in).nextInt();
						//売れたものを表示 財布に売ったモノの値段をいれる
						treasures.remove(select);
						
						//”～～円で売れた！　所持金　～～円と出力
						System.out.println(treasures.get(select).price +"円で売れた！所持金" + main.money);
						System.out.println("ほかのものも売る？");//続けるかどうかの確認
						System.out.println("1:はい　2:いいえ");
						int reply =new Scanner(System.in).nextInt();
						if(reply == 2) {
							break;
						}
					}

				}
				break;
			case 3:
				System.out.println("!!!結果発表!!!");
				//お宝の表示
				System.out.print("～見つけた宝物～");
				for(Treasure t:treasures ) {//持っている宝物を表示
					System.out.printf("%s[%s](%d)\n", t.name, t.rare, t.price);
				}
				//お金の表示
				System.out.print("～持っているお金～");
				System.out.println(main.money + "円");
				System.out.println("また遊んでね(^▽^)/");
				return;
			default:
				System.out.println("1～3で選んでね！");
			}
		}

}

}
