package chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chat.bean.TranObject;
import chat.bean.Type;
import chat.bean.User;
import chat.bean.chatcontent;

public class listen implements Runnable {
    static final Log logger = LogFactory.getLog(listen.class);
    private Socket client;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Boolean isrunning = false;
    private String uid;

    public listen(ObjectInputStream in, ObjectOutputStream out, Socket client) {
        this.in = in;
        this.out = out;
        this.client = client;
        this.isrunning = true;
    }


    public void run() {
        while (isrunning) {
            getmsg();
        }
    }

    public void getmsg() {
        try {
            TranObject tran = (TranObject) in.readObject();
            Type type = tran.getType();
            switch (type) {
                case LOGIN:
                    User user = (User) tran.getObject();
                    uid = user.getUid();
                    user.setClient(client);
                    user.setOut(out);
                    logger.info(user.getUid() + "连入服务器");
                    startserver.userlist.add(user);
                    break;
                case SENDMESSAGE:
                    chatcontent chat = (chatcontent) tran.getObject();
                    new send(tran);
                    break;
                case SENDPICTURE:
                    chatcontent picture = (chatcontent) tran.getObject();
                    logger.info(picture.getSendid() + "对" + picture.getToid() + "发送图片");
                    new send(tran);
                    break;
                default:
                    break;
            }
            in.reset();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("获取数据失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block0
            for (int i = 1; i < startserver.userlist.size(); i++) {
                if (startserver.userlist.get(i).getUid().equals(uid)) {
                    startserver.userlist.remove(i);
                    logger.info(uid + "下线了");
                    isrunning = false;
                }
            }
        }
    }
}
