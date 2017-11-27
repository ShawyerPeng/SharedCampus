package po;

import java.util.Date;

public class DakaFollow {
    private Integer id;

    private Integer dakaId;

    private Integer followerId;

    private Date followTime;

    public DakaFollow() {
    }

    public DakaFollow(Integer dakaId, Integer followerId) {
        this.dakaId = dakaId;
        this.followerId = followerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDakaId() {
        return dakaId;
    }

    public void setDakaId(Integer dakaId) {
        this.dakaId = dakaId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    @Override
    public String toString() {
        return "DakaFollow{" +
                "id=" + id +
                ", dakaId=" + dakaId +
                ", followerId=" + followerId +
                ", followTime=" + followTime +
                '}';
    }
}