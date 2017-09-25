package po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.CustomDateSerializer;

import java.util.Date;

public class Task {
    private Integer taskId;

    private Integer publisherId;

    private String title;

    private String description;

    private Integer category;

    private Double price;

    private Integer counts;

    private Date starttime;

    private Date endtime;

    private String pic;

    private Date pubtime;

    public Task() {
    }

    public Task(Integer taskId, Integer publisherId, String title, String description, Integer category, Double price, Integer counts, Date starttime, Date endtime) {
        this.taskId = taskId;
        this.publisherId = publisherId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.counts = counts;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Task(Integer publisherId, String title, String description, Integer category, Double price, Integer counts, Date starttime, Date endtime) {
        this.publisherId = publisherId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.counts = counts;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Task(Integer publisherId, String title, String description, Integer category, Double price, Integer counts, Date starttime, Date endtime, String pic) {
        this.publisherId = publisherId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.counts = counts;
        this.starttime = starttime;
        this.endtime = endtime;
        this.pic = pic;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }
}