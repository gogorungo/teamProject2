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
				bw.write(msg + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
