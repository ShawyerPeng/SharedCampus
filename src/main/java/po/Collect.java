package po;

import java.util.Date;

public class Collect {
    private Integer collectId;

    private Integer collectorId;

    private Integer taskId;

    private Date collectTime;

    public Collect() {
    }

    public Collect(Integer collectorId, Integer taskId) {
        this.collectorId = collectorId;
        this.taskId = taskId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}