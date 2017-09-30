package chat.server;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import chat.bean.TranObject;
import chat.bean.chatcontent;

public class send {
    static final Log logger = LogFactory.getLog(listen.class);
    private TranObject tran;

    public send(TranObject tran) throws IOException {
        this.tran = tran;
        sendmsg();
    }

    public void sendmsg() {
        chatcontent chat = (chatcontent) tran.getObject();
        String id = chat.getToid();
        for (int i = startserver.userlist.size() - 1; i >= 0; i--) {
            if (startserver.userlist.get(i).getUid().equals(id)) {
                try {
                    ObjectOutputStream out = startserver.userlist.get(i).getOut();
                    out.writeObject(tran);
                    out.flush();
                    out.reset();
                    logger.info(chat.getSendid() + "对" + chat.getToid() + "发送消息");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    logger.equals("发送消息失败");
                }
                break;
            }
        }
    }
}
