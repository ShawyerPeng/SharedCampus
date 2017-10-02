package po;

import java.util.Date;

public class Follow {
    private Integer followId;

    private Integer followerId;

    private Integer followedId;

    private Date followTime;

    public Follow() {
    }

    public Follow(Integer followerId, Integer followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}