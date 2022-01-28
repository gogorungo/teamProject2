package phase1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class gameClientWriteMsg extends Thread {
	BufferedWriter bw;
	Scanner scan = new Scanner(System.in);

	public gameClientWriteMsg(BufferedWriter bw) {
		this.bw = bw;
		start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("메세지를 입력하세요");
			String msg = scan.nextLine();
			try {
				bw.write(msg+" "+"\n"); // 명령어를 사용 못하게 하기 위한 " " 추가
				bw.flush();
			} catch (IOException e) {
				if(bw != null) {
					scan.close();
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			}
		}
	}
}
