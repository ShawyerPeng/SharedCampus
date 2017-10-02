package po;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer taskId;

    private Integer publisherId;

    private Integer receiverId;

    private Double price;

    private Byte orderStatus;

    private Byte commentStatus;

    private String commentBuyer;

    private String commentSeller;

    private Byte rateStatus;

    private Byte rateBuyer;

    private Byte rateSeller;

    private Date orderTime;

    public Order() {
    }

    public Order(Integer taskId, Integer receiverId, Double price) {
        this.taskId = taskId;
        this.receiverId = receiverId;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentBuyer() {
        return commentBuyer;
    }

    public void setCommentBuyer(String commentBuyer) {
        this.commentBuyer = commentBuyer == null ? null : commentBuyer.trim();
    }

    public String getCommentSeller() {
        return commentSeller;
    }

    public void setCommentSeller(String commentSeller) {
        this.commentSeller = commentSeller == null ? null : commentSeller.trim();
    }

    public Byte getRateStatus() {
        return rateStatus;
    }

    public void setRateStatus(Byte rateStatus) {
        this.rateStatus = rateStatus;
    }

    public Byte getRateBuyer() {
        return rateBuyer;
    }

    public void setRateBuyer(Byte rateBuyer) {
        this.rateBuyer = rateBuyer;
    }

    public Byte getRateSeller() {
        return rateSeller;
    }

    public void setRateSeller(Byte rateSeller) {
        this.rateSeller = rateSeller;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}