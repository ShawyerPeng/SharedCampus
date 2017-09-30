package po;

public class Order {
    private Integer orderId;

    private Integer taskId;

    private Integer receiverId;

    private Double price;

    private Byte taskStatus;

    private Short commentStatus;

    private String commentBuyer;

    private String commentSeller;

    private Byte rateBuyer;

    private Byte rateSeller;

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

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Short getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Short commentStatus) {
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
}