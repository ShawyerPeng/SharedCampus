//package mqtt;
//
//import org.fusesource.mqtt.client.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class MQTTFutureClient {
//    private static final Logger LOG = LoggerFactory.getLogger(MQTTFutureClient.class);
//    private final static String CONNECTION_STRING = "tcp://127.0.0.1:1883";
//    private final static boolean CLEAN_START = true;
//    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
//    private final static String CLIENT_ID = "client";
//    private static Topic[] topics = {
//            new Topic("china/beijing", QoS.EXACTLY_ONCE),
//            new Topic("china/tianjin", QoS.AT_LEAST_ONCE),
//            new Topic("china/henan", QoS.AT_MOST_ONCE)};
//    private final static long RECONNECTION_ATTEMPT_MAX = 6;
//    private final static long RECONNECTION_DELAY = 2000;
//
//    private final static int SEND_BUFFER_SIZE = 2 * 1024 * 1024;// 发送最大缓冲为 2M
//
//
//    public static void main(String[] args) {
//        // 创建 MQTT 对象
//        MQTT mqtt = new MQTT();
//        try {
//            // 设置 mqtt broker 的 ip 和端口
//            mqtt.setHost(CONNECTION_STRING);
//            // 连接前清空会话信息
//            mqtt.setCleanSession(CLEAN_START);
//            // 设置重新连接的次数
//            mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
//            // 设置重连的间隔时间
//            mqtt.setReconnectDelay(RECONNECTION_DELAY);
//            // 设置心跳时间
//            mqtt.setKeepAlive(KEEP_ALIVE);
//            // 设置缓冲的大小
//            mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
//            mqtt.setClientId(CLIENT_ID);
//
//            // 获取 mqtt 的连接对象 BlockingConnection
//            final FutureConnection connection = mqtt.futureConnection();
//            connection.connect();
//            connection.subscribe(topics);
//            while (true) {
//                Future<Message> futrueMessage = connection.receive();
//                Message message = futrueMessage.await();
//
//                System.out.println("MQTTFutureClient.Receive Message" + "Topic Title :" + message.getTopic() + "context :" + String.valueOf(message.getPayloadBuffer()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
