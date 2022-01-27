package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class gameUser {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
		
	public gameUser() {	}
	
	public gameUser(Socket socket, BufferedReader br, BufferedWriter bw) {
		this.socket = socket;
		this.br = br;
		this.bw = bw;
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getBr() {
		return br;
	}

	public BufferedWriter getBw() {
		return bw;
	}
	
	
	
}
