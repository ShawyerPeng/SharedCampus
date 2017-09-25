package po;

public class Image {
    private Integer imageId;

    private String filename;

    private String url;

    private String description;

    public Image() {
    }

    public Image(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

    public Image(String filename, String url, String description) {
        this.filename = filename;
        this.url = url;
        this.description = description;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}