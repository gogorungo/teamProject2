package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class inputMsg extends Thread {
	HashMap<String, gameUser> user;
	BufferedReader br;
	String userId;
	String msg;
	
	public inputMsg(String userId, BufferedReader br, HashMap<String, gameUser> user) {
		this.userId = userId;
		this.br = br;
		this.user = user;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				msg = br.readLine();
				new broadcast(userId + " >>> "+ msg+"\n",user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
