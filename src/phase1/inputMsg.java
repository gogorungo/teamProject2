package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class inputMsg extends Thread {
	private final String next = "next"; // 정답을 맞췄을 시 발송해주는 암호
	private final String sendMsg = "/to"; // 귓속말 명령어
	private HashMap<String, gameUser> user;
	private BufferedReader br;
	private String userId, msg;
	
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
				
				if(msg.indexOf(sendMsg)==0) { // 귓속말
					new sendmsg(msg, userId, user);
				}				
				else if(msg.equals(next)) {
					// 다른 사람이 정답을 맞추면 모두에게 다음 문제로 넘어가라고 명령함
					new broadcast(next,user);
				}
				else { //채팅이라면 채팅발송
					new broadcast(userId + " >>> "+ msg+"\n",user);
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
