package phase1;

import java.io.BufferedReader;
import java.io.IOException;

public class gameClientReadMsg extends Thread {
	BufferedReader br;

	public gameClientReadMsg(BufferedReader br) {
		this.br = br;
		start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				String serverMsg = br.readLine();
				if("next".equals(serverMsg)) {
					// 넥스트 받으면 다음 문제로 넘어감
				}
				else if("start".equals(serverMsg)) {
					// 게임 스타트
				}
				else {
					serverMsg = serverMsg.substring(0, serverMsg.length()-1); // 임의로 넣은 " " 제거
					System.out.println(serverMsg);
				}
			} catch (IOException e) {
				if(br != null)
					try {
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}

	}
}
