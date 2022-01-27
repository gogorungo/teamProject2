package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class gameClient extends Thread {
	private Socket socket;
	protected BufferedWriter bw;
	protected BufferedReader br;
	
	Scanner scan = new Scanner(System.in);
	
	public gameClient() {
		try {
			// 클라이언트 실행시 서버와 접속.			
			socket = new Socket(InetAddress.getLocalHost(), 8888);
			System.out.println("접속 되었습니다");
			
			//서버와 통신할 br bw 설정
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println("닉네임을 입력하세요");
			String userId = scan.nextLine();
			
			bw.write(userId+"\n");
			bw.flush();
			
			//메세지를 받는다
			new gameClientReadMsg(br);
			
			//메세지를 입력한다
			new gameClientWriteMsg(bw);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new gameClient();
	}
}
