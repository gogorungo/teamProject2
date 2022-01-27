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
				System.out.println(serverMsg);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
