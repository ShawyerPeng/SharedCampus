package chat.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chat.bean.TranObject;
import chat.bean.Type;
import chat.bean.User;
import chat.bean.chatcontent;

public class startclient {
    static final Log logger = LogFactory.getLog(startclient.class);

    public static void main(String[] args) {
        try {
            Socket client;
            client = new Socket("127.0.0.1", 6666);
            System.out.println("连接成功");
            final ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            final ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            TranObject tran = new TranObject();
            tran.setType(Type.LOGIN);
            User user = new User();
            user.setUname("小明");
            user.setUid("6666666");
            tran.setObject(user);
            out.writeObject(tran);
            out.flush();
            try {
                Scanner send = new Scanner(System.in);
                String content = send.nextLine();
                chatcontent chat = new chatcontent();
                TranObject tran2 = new TranObject();
                chat.setContent(content);
                chat.setToid("189eace8084b4903");
                chat.setSendid("6666666");
                tran2.setObject(chat);
                tran2.setType(Type.SENDMESSAGE);
                out.writeObject(tran2);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//			new Thread(new Runnable() {
//
//				public void run() {
//					while (true) {
//						try {
//							chatcontent chat = (chatcontent)in.readObject();
//							System.out.println(chat.getSendid()+":"+chat.getContent());
//						} catch (IOException e) {
//							e.printStackTrace();
//						} catch (ClassNotFoundException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
