package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFollowIdIsNull() {
            addCriterion("follow_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowIdIsNotNull() {
            addCriterion("follow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowIdEqualTo(Integer value) {
            addCriterion("follow_id =", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotEqualTo(Integer value) {
            addCriterion("follow_id <>", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThan(Integer value) {
            addCriterion("follow_id >", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_id >=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThan(Integer value) {
            addCriterion("follow_id <", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdLessThanOrEqualTo(Integer value) {
            addCriterion("follow_id <=", value, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdIn(List<Integer> values) {
            addCriterion("follow_id in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotIn(List<Integer> values) {
            addCriterion("follow_id not in", values, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdBetween(Integer value1, Integer value2) {
            addCriterion("follow_id between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_id not between", value1, value2, "followId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdIsNull() {
            addCriterion("follower_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowerIdIsNotNull() {
            addCriterion("follower_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowerIdEqualTo(Integer value) {
            addCriterion("follower_id =", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdNotEqualTo(Integer value) {
            addCriterion("follower_id <>", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdGreaterThan(Integer value) {
            addCriterion("follower_id >", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("follower_id >=", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdLessThan(Integer value) {
            addCriterion("follower_id <", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("follower_id <=", value, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdIn(List<Integer> values) {
            addCriterion("follower_id in", values, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdNotIn(List<Integer> values) {
            addCriterion("follower_id not in", values, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdBetween(Integer value1, Integer value2) {
            addCriterion("follower_id between", value1, value2, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("follower_id not between", value1, value2, "followerId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdIsNull() {
            addCriterion("followed_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowedIdIsNotNull() {
            addCriterion("followed_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowedIdEqualTo(Integer value) {
            addCriterion("followed_id =", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdNotEqualTo(Integer value) {
            addCriterion("followed_id <>", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdGreaterThan(Integer value) {
            addCriterion("followed_id >", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("followed_id >=", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdLessThan(Integer value) {
            addCriterion("followed_id <", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdLessThanOrEqualTo(Integer value) {
            addCriterion("followed_id <=", value, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdIn(List<Integer> values) {
            addCriterion("followed_id in", values, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdNotIn(List<Integer> values) {
            addCriterion("followed_id not in", values, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdBetween(Integer value1, Integer value2) {
            addCriterion("followed_id between", value1, value2, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("followed_id not between", value1, value2, "followedId");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNull() {
            addCriterion("follow_time is null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIsNotNull() {
            addCriterion("follow_time is not null");
            return (Criteria) this;
        }

        public Criteria andFollowTimeEqualTo(Date value) {
            addCriterion("follow_time =", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotEqualTo(Date value) {
            addCriterion("follow_time <>", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThan(Date value) {
            addCriterion("follow_time >", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("follow_time >=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThan(Date value) {
            addCriterion("follow_time <", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeLessThanOrEqualTo(Date value) {
            addCriterion("follow_time <=", value, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeIn(List<Date> values) {
            addCriterion("follow_time in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotIn(List<Date> values) {
            addCriterion("follow_time not in", values, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeBetween(Date value1, Date value2) {
            addCriterion("follow_time between", value1, value2, "followTime");
            return (Criteria) this;
        }

        public Criteria andFollowTimeNotBetween(Date value1, Date value2) {
            addCriterion("follow_time not between", value1, value2, "followTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}