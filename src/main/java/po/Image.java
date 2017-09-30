package po;

public class Image {
    private Integer imageId;

    private String filename;

    private String picUrl;

    private String description;

    public Image() {
    }

    public Image(String filename, String picUrl) {
        this.filename = filename;
        this.picUrl = picUrl;
    }

    public Image(String filename, String picUrl, String description) {
        this.filename = filename;
        this.picUrl = picUrl;
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }


}