package chat.bean;

import java.io.Serializable;

public enum Type implements Serializable{
	LOGIN,
	SENDMESSAGE,
	GETMESSAGE,
	REGISTER,
	SENDPICTURE,
	GETPICTURE,
	LEAVE
}
