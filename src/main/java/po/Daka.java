package po;

public class Daka {
    private Integer dakaId;

    private Integer userId;

    private String info;

    private String honor;

    private String achievement;

    public Daka() {
    }

    public Daka(Integer userId, String info, String honor, String achievement) {
        this.userId = userId;
        this.info = info;
        this.honor = honor;
        this.achievement = achievement;
    }

    public Integer getDakaId() {
        return dakaId;
    }

    public void setDakaId(Integer dakaId) {
        this.dakaId = dakaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor == null ? null : honor.trim();
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

    @Override
    public String toString() {
        return "Daka{" +
                "dakaId=" + dakaId +
                ", userId=" + userId +
                ", info='" + info + '\'' +
                ", honor='" + honor + '\'' +
                ", achievement='" + achievement + '\'' +
                '}';
    }
}