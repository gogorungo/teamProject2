package phase1;

import java.util.HashMap;

public class gameStart extends Thread {
	int num;
	private HashMap<String, gameUser> user;
	public gameStart(int num, HashMap<String, gameUser> user) {
		this.num = num;
		this.user = user;
	}
	
	@Override
	public void run() {
		while(true) {
			if(gameServer.readyCount==num) {
				new broadcast("start",user);
				gameServer.readyCount = 0; // 게임이 실행되면 카운트 초기화
			}
			
		}
	}
}
