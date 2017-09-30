package test;

import api.account.Login;
import api.account.Logout;
import api.account.Register;
import api.friend.AllFriend;
import api.friend.FriendAdd;
import api.friend.FriendRemove;
import api.future.*;
import api.group.GroupCreate;
import api.group.GroupDisband;
import api.group.MemberAdd;
import api.group.MemberRemove;
import api.info.FriendInfo;
import api.info.InfoGroup;
import api.info.InfoUpdate;
import api.info.SelfInfo;
import api.message.GroupMessage;
import api.message.PersonMessage;
import com.sun.deploy.util.StringUtils;
import pojo.Message;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 启动命令行.
 *
 * @author Yohann.
 */
public class ClientStrap {
    private CommandLine commandLine;

    public ClientStrap() {
        commandLine = new CommandLine();
        // 初始化命令
        commandLine.init();
        //
    }

    public static void main(String[] args) {

    }

    /**
     * 启动
     */
    public void startCommandLine() {
        int commandId, optionId;
        System.out.println("=========== 客户端启动成功 ===========");
        System.out.print(ClientInfo.username + " > ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextLine()) {
                String line = StringUtils.trimWhitespace(sc.nextLine());
                String[] keywords = line.split(" ");
                try {
                    commandId = commandLine.getCommands().get(keywords[0]);
                } catch (Exception e) {
                    System.out.println("不支持此命令");
                    System.out.print(ClientInfo.username + " > ");
                    continue;
                }
                switch (commandId) {
                    case 0:
                        if (Checker.check(0, keywords.length)) {
                            help();
                        }
                        break;

                    case 1:
                        if (Checker.check(1, keywords.length)) {
                            login(keywords[1], keywords[2]);
                        }
                        break;

                    case 2:
                        if (Checker.check(2, keywords.length)) {
                            logout();
                        }
                        break;

                    case 3:
                        if (Checker.check(3, keywords.length)) {
                            register(keywords[1], keywords[2]);
                        }
                        break;

                    case 4:
                        if (Checker.check(4, keywords.length)) {
                            try {
                                optionId = commandLine.getMessageOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    personMessage(keywords[2], keywords[3]);
                                    break;
                                case 2:
                                    groupMessage(keywords[2], keywords[3]);
                                    break;
                            }
                        }
                        break;

                    case 5:
                        if (Checker.check(5, keywords.length)) {
                            try {
                                optionId = commandLine.getGroupOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    createGroup(keywords[2]);
                                    break;
                                case 2:
                                    disbandGroup(keywords[2]);
                                    break;
                            }
                        }
                        break;

                    case 6:
                        if (Checker.check(6, keywords.length)) {
                            try {
                                optionId = commandLine.getAddOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    addFriend(keywords[2]);
                                    break;
                                case 2:
                                    addMember(keywords[2], keywords[3]);
                                    break;
                            }
                        }
                        break;

                    case 7:
                        if (Checker.check(7, keywords.length)) {
                            try {
                                optionId = commandLine.getRemoveOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    removeFriend(keywords[2]);
                                    break;
                                case 2:
                                    removeMember(keywords[2], keywords[3]);
                                    break;
                            }
                        }
                        break;

                    case 8:
                        if (Checker.check(8, keywords.length)) {
                            try {
                                optionId = commandLine.getUpadteOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    updatePassword(keywords[2]);
                                    break;
                                case 2:
                                    updateName(keywords[2]);
                                    break;
                                case 3:
                                    updateSex(keywords[2]);
                                    break;
                                case 4:
                                    updateAge(keywords[2]);
                                    break;
                                case 5:
                                    updatePhone(keywords[2]);
                                    break;
                                case 6:
                                    updateAddress(keywords[2]);
                                    break;
                                case 7:
                                    updateIntroduction(keywords[2]);
                                    break;
                            }
                        }
                        break;

                    case 9:
                        if (Checker.check(9, keywords.length)) {
                            try {
                                optionId = commandLine.getShowOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    showSelf();
                                    break;
                                case 2:
                                    showFriend(keywords[2]);
                                    break;
                            }
                        }
                        break;

                    case 10:
                        if (Checker.check(10, keywords.length)) {
                            try {
                                optionId = commandLine.getDisplayOptions().get(keywords[1]);
                            } catch (Exception e) {
                                System.out.println("不支持此选项");
                                System.out.print(ClientInfo.username + " > ");
                                continue;
                            }
                            switch (optionId) {
                                case 1:
                                    displayFriend();
                                    break;
                                case 2:
                                    displayGroup();
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }

    /**
     * command help
     */
    public static void help() {
        System.out.println(" 1. help  命令帮助");
        System.out.println(" 2. login <username> <password>  登录");
        System.out.println(" 3. register <username> <password>  注册");
        System.out.println(" 4. message");
        System.out.println("    message [-p] <receiver> <content>  发送个人消息");
        System.out.println("    message [-g] <receiver> <content>  发送个人消息");
        System.out.println(" 5. group");
        System.out.println("    group [-c] <groupName>  创建讨论组");
        System.out.println("    group [-d] <groupName>  解散讨论组");
        System.out.println(" 6. add");
        System.out.println("    add [-f] <username>  添加好友");
        System.out.println("    add [-m] <groupName> <username>  讨论组添加成员");
        System.out.println(" 7. remove");
        System.out.println("    remove [-f] <username>  删除好友");
        System.out.println("    remove [-m] <groupName> <username>  讨论组删除成员");
        System.out.println(" 8. update");
        System.out.println("    update [-p] <content> 修改密码");
        System.out.println("    update [-n] <content> 修改姓名");
        System.out.println("    update [-s] <content> 修改性别");
        System.out.println("    update [-a] <content> 修改年龄");
        System.out.println("    update [-P] <content> 修改联系电话");
        System.out.println("    update [-A] <content> 修改家庭住址");
        System.out.println("    update [-i] <content> 修改自我介绍");
        System.out.println(" 9. show");
        System.out.println("    show [-m]  查看自己的个人信息");
        System.out.println("    show [-f]  查看好友的个人信息");
        System.out.println("10. display");
        System.out.println("    display [-f]  列出已添加的好友");
        System.out.println("    display [-g]  列出已加入的讨论组");
        System.out.print(ClientInfo.username + " > ");
    }

    public static String login(String username, String password) {
        Future future = Login.login(new MyReceiver(), username, password);
        final String[] result = new String[1];
        final CountDownLatch latch = new CountDownLatch(1);
        future.addListener(new LoginFutureListener() {
            @Override
            public void onSuccess(String username) {
                // 保存信息
                ClientInfo.username = username;
                System.out.print(ClientInfo.username + " > ");
                latch.countDown();
                result[0] = "success";
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("登录失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
                latch.countDown();
                result[0] = "failure";
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result[0];
    }

    public static void logout() {
        Logout.logout();
        ClientInfo.username = "";
    }

    public static void register(String username, String password) {
        Future future = Register.register(username, password);
        future.addListener(new RegisterFutureListener() {
            @Override
            public void onSuccess(String username) {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("注册失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public static Message personMessage(String receiver, String content) {
        Message result = new Message();
        Future future = PersonMessage.send(receiver, content);
        future.addListener(new PersonMessageFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("消息发送失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
        return result;
    }

    public void addFriend(String friend) {
        Future future = FriendAdd.add(friend);
        future.addListener(new FriendAddFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void removeFriend(String friend) {
        Future future = FriendRemove.remove(friend);
        future.addListener(new FriendRemoveFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void displayFriend() {
        Future future = AllFriend.query();
        future.addListener(new AllFriendFutureListener() {
            @Override
            public void onSuccess(Map<String, Boolean> friends) {
                Set<Map.Entry<String, Boolean>> entries = friends.entrySet();
                Iterator<Map.Entry<String, Boolean>> ite = entries.iterator();
                while (ite.hasNext()) {
                    Map.Entry<String, Boolean> entry = ite.next();
                    String username = entry.getKey();
                    Boolean isOnline = entry.getValue();
                    if (isOnline) {
                        System.out.println(username + "  在线");
                    } else {
                        System.out.println(username + "  离线");
                    }
                }
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updatePassword(String password) {
        Future future = InfoUpdate.setPassword(password);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updateName(String name) {
        Future future = InfoUpdate.setName(name);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updateSex(String sex) {
        Future future = InfoUpdate.setSex(sex);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updateAge(String age) {
        Future future = InfoUpdate.setAge(age);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updatePhone(String phone) {
        Future future = InfoUpdate.setPhone(phone);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updateAddress(String address) {
        Future future = InfoUpdate.setAddress(address);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void updateIntroduction(String introduction) {
        Future future = InfoUpdate.setIntroduction(introduction);
        future.addListener(new InfoUpdateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("添加好友失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void showSelf() {
        Future future = SelfInfo.query();
        future.addListener(new SelfInfoFutureListener() {
            @Override
            public void onSuccess(String username, String name, String sex,
                                  String age, String phone, String address, String introduction) {
                System.out.println("用户名：" + username);
                System.out.println("姓名：" + name);
                System.out.println("性别：" + sex);
                System.out.println("年龄：" + age);
                System.out.println("联系电话：" + phone);
                System.out.println("家庭住址：" + address);
                System.out.println("个人介绍：" + introduction);
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("信息查询失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void showFriend(String friend) {
        Future future = FriendInfo.query(friend);
        future.addListener(new FriendInfoFutureListener() {
            @Override
            public void onSuccess(String username, String name, String sex,
                                  String age, String phone, String address, String introduction) {
                System.out.println("用户名：" + username);
                System.out.println("姓名：" + name);
                System.out.println("性别：" + sex);
                System.out.println("年龄：" + age);
                System.out.println("联系电话：" + phone);
                System.out.println("家庭住址：" + address);
                System.out.println("个人介绍：" + introduction);
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("信息查询失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void createGroup(String groupName) {
        Future future = GroupCreate.create(groupName);
        future.addListener(new GroupCreateFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("讨论组创建失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void disbandGroup(String groupName) {
        Future future = GroupDisband.disband(groupName);
        future.addListener(new GroupDisbandFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("讨论组解散失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void addMember(String groupName, String username) {
        Future future = MemberAdd.add(groupName, username);
        future.addListener(new MemberAddFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("讨论组添加成员失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void removeMember(String groupName, String username) {
        Future future = MemberRemove.remove(groupName, username);
        future.addListener(new MemberRemoveFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("讨论组删除成员失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void groupMessage(String groupName, String content) {
        Future future = GroupMessage.send(groupName, content);
        future.addListener(new GroupMessageFutureListener() {
            @Override
            public void onSuccess() {
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("消息发送失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }

    public void displayGroup() {
        Future future = InfoGroup.query();
        future.addListener(new InfoGroupFutureListener() {
            @Override
            public void onSuccess(Map<String, List<String>> groups) {
                if (groups.size() != 0) {
                    Set<Map.Entry<String, List<String>>> entries = groups.entrySet();
                    Iterator<Map.Entry<String, List<String>>> ite = entries.iterator();
                    while (ite.hasNext()) {
                        Map.Entry<String, List<String>> group = ite.next();
                        String groupName = group.getKey();
                        List<String> members = group.getValue();
                        System.out.println(groupName + " " + members);
                    }
                } else {
                    System.out.println("没有加入任何讨论组");
                }
                System.out.print(ClientInfo.username + " > ");
            }

            @Override
            public void onFailure(int errorCode) {
                System.out.println("查询失败 errorCode: " + errorCode);
                System.out.print(ClientInfo.username + " > ");
            }
        });
    }
}
