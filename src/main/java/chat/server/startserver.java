package chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chat.bean.User;

public class startserver {
	static final Log logger = LogFactory.getLog(startserver.class);
	private JTextField output;
	private JTextArea input;
	public static List<User> userlist = new ArrayList<>();

	public static void chatserver() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(6666);
			System.out.println("开启成功");
			while (true) {
				try {
					Socket client = server.accept();
					ObjectInputStream in = new ObjectInputStream(client.getInputStream());
					ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
					Thread listen = new Thread(new listen(in, out, client));
					listen.start();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("发生未知错误导致连接断开");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("发生未知错误导致服务器关闭");
		}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		chatserver();
	}

}
