package chat.bean;

import java.io.Serializable;

public class chatcontent implements Serializable {
	String sendid;
	String toid;
	String content;
	byte[] picture;
	boolean ispicture;
	boolean isFile;
	String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}

	String picturepath;

	public boolean isIspicture() {
		return ispicture;
	}

	public void setIspicture(boolean ispicture) {
		this.ispicture = ispicture;
	}

	public byte[] getPicture() {
		return picture;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getSendid() {
		return sendid;
	}

	public void setSendid(String sendid) {
		this.sendid = sendid;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
