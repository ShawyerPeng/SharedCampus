package chat.bean;

import java.io.Serializable;

public class TranObject implements Serializable{
	private Object object;
	private Type type;
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
