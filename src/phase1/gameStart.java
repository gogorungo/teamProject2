package phase1;

public class gameStart extends Thread {
	int num;
	public gameStart(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		while(true) {
			if(gameServer.readyCount==num) {
				//게임 스타트!
			}
		}
	}
}
