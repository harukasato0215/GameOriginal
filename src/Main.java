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
			
			Treasure t4;//誰かの靴下のインスタンス
			t4 = new Treasure();
			t4.name ="誰かの靴下";
			t4.rare = 0;
			t4.price = 10;
			
		
			Treasure[] types = {t1,t2,t3,t4};

			
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
					System.out.println("");
					break;

			case 2://宝を売る
				if(treasures.size() == 0) {//宝物を持っていないとき
					System.out.println("まだ宝物を見つけてないよ！");
				}else {//宝物を持っているとき
					while(true) {
						for (int i = 0; i < treasures.size(); i++) {
							System.out.printf("%d・・・%s\n", i, treasures.get(i).name);
						}
						//どの宝物にするか選択
						System.out.println("どの宝物を売る？");
						select = new Scanner(System.in).nextInt();
						//財布に売ったモノの値段をいれる
						main.money += treasures.get(select).price;
						
						//”～～円で売れた！　所持金　～～円と出力
						System.out.println(treasures.get(select).price +"円で売れた！　【所持金" + main.money +"円】");
						System.out.println("");
						//売れたものをけす　 
						treasures.remove(select);
						System.out.println("ほかのものも売る？");//続けるかどうかの確認
						System.out.println("1:はい　2:いいえ");
						int reply =new Scanner(System.in).nextInt();
						if(reply == 2) {
							break;
						}else if(treasures.isEmpty() == true) {
							System.out.println("持っている宝物がないよ！");
							break;
						}
					}
					System.out.println("");
					
				}
				break;
			case 3:
				System.out.println("・・・");
				System.out.println("・・・");
				System.out.println("!!!結果発表!!!");
				//お宝の表示
				System.out.println("～持っている宝物～");
				for(Treasure t:treasures ) {//持っている宝物を表示
					System.out.printf("%s[%s]\n", t.name, t.rare);
				}
				//お金の表示
				System.out.println("～持っているお金～");
				System.out.println(main.money + "円");
				System.out.println("また遊んでね(^▽^)/");
				return;
			default:
				System.out.println("1～3で選んでね！");
			}
		}

}

}
