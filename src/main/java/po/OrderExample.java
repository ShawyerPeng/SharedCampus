package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(Integer value) {
            addCriterion("receiver_id =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(Integer value) {
            addCriterion("receiver_id <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(Integer value) {
            addCriterion("receiver_id >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_id >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(Integer value) {
            addCriterion("receiver_id <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_id <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<Integer> values) {
            addCriterion("receiver_id in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<Integer> values) {
            addCriterion("receiver_id not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(Integer value1, Integer value2) {
            addCriterion("receiver_id between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_id not between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Byte value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Byte value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Byte> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Byte value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Byte value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Byte value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Byte value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Byte> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Byte> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Byte value1, Byte value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerIsNull() {
            addCriterion("comment_buyer is null");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerIsNotNull() {
            addCriterion("comment_buyer is not null");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerEqualTo(String value) {
            addCriterion("comment_buyer =", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerNotEqualTo(String value) {
            addCriterion("comment_buyer <>", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerGreaterThan(String value) {
            addCriterion("comment_buyer >", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerGreaterThanOrEqualTo(String value) {
            addCriterion("comment_buyer >=", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerLessThan(String value) {
            addCriterion("comment_buyer <", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerLessThanOrEqualTo(String value) {
            addCriterion("comment_buyer <=", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerLike(String value) {
            addCriterion("comment_buyer like", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerNotLike(String value) {
            addCriterion("comment_buyer not like", value, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerIn(List<String> values) {
            addCriterion("comment_buyer in", values, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerNotIn(List<String> values) {
            addCriterion("comment_buyer not in", values, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerBetween(String value1, String value2) {
            addCriterion("comment_buyer between", value1, value2, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentBuyerNotBetween(String value1, String value2) {
            addCriterion("comment_buyer not between", value1, value2, "commentBuyer");
            return (Criteria) this;
        }

        public Criteria andCommentSellerIsNull() {
            addCriterion("comment_seller is null");
            return (Criteria) this;
        }

        public Criteria andCommentSellerIsNotNull() {
            addCriterion("comment_seller is not null");
            return (Criteria) this;
        }

        public Criteria andCommentSellerEqualTo(String value) {
            addCriterion("comment_seller =", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerNotEqualTo(String value) {
            addCriterion("comment_seller <>", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerGreaterThan(String value) {
            addCriterion("comment_seller >", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerGreaterThanOrEqualTo(String value) {
            addCriterion("comment_seller >=", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerLessThan(String value) {
            addCriterion("comment_seller <", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerLessThanOrEqualTo(String value) {
            addCriterion("comment_seller <=", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerLike(String value) {
            addCriterion("comment_seller like", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerNotLike(String value) {
            addCriterion("comment_seller not like", value, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerIn(List<String> values) {
            addCriterion("comment_seller in", values, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerNotIn(List<String> values) {
            addCriterion("comment_seller not in", values, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerBetween(String value1, String value2) {
            addCriterion("comment_seller between", value1, value2, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andCommentSellerNotBetween(String value1, String value2) {
            addCriterion("comment_seller not between", value1, value2, "commentSeller");
            return (Criteria) this;
        }

        public Criteria andRateStatusIsNull() {
            addCriterion("rate_status is null");
            return (Criteria) this;
        }

        public Criteria andRateStatusIsNotNull() {
            addCriterion("rate_status is not null");
            return (Criteria) this;
        }

        public Criteria andRateStatusEqualTo(Byte value) {
            addCriterion("rate_status =", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusNotEqualTo(Byte value) {
            addCriterion("rate_status <>", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusGreaterThan(Byte value) {
            addCriterion("rate_status >", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("rate_status >=", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusLessThan(Byte value) {
            addCriterion("rate_status <", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusLessThanOrEqualTo(Byte value) {
            addCriterion("rate_status <=", value, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusIn(List<Byte> values) {
            addCriterion("rate_status in", values, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusNotIn(List<Byte> values) {
            addCriterion("rate_status not in", values, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusBetween(Byte value1, Byte value2) {
            addCriterion("rate_status between", value1, value2, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("rate_status not between", value1, value2, "rateStatus");
            return (Criteria) this;
        }

        public Criteria andRateBuyerIsNull() {
            addCriterion("rate_buyer is null");
            return (Criteria) this;
        }

        public Criteria andRateBuyerIsNotNull() {
            addCriterion("rate_buyer is not null");
            return (Criteria) this;
        }

        public Criteria andRateBuyerEqualTo(Byte value) {
            addCriterion("rate_buyer =", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerNotEqualTo(Byte value) {
            addCriterion("rate_buyer <>", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerGreaterThan(Byte value) {
            addCriterion("rate_buyer >", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerGreaterThanOrEqualTo(Byte value) {
            addCriterion("rate_buyer >=", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerLessThan(Byte value) {
            addCriterion("rate_buyer <", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerLessThanOrEqualTo(Byte value) {
            addCriterion("rate_buyer <=", value, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerIn(List<Byte> values) {
            addCriterion("rate_buyer in", values, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerNotIn(List<Byte> values) {
            addCriterion("rate_buyer not in", values, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerBetween(Byte value1, Byte value2) {
            addCriterion("rate_buyer between", value1, value2, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateBuyerNotBetween(Byte value1, Byte value2) {
            addCriterion("rate_buyer not between", value1, value2, "rateBuyer");
            return (Criteria) this;
        }

        public Criteria andRateSellerIsNull() {
            addCriterion("rate_seller is null");
            return (Criteria) this;
        }

        public Criteria andRateSellerIsNotNull() {
            addCriterion("rate_seller is not null");
            return (Criteria) this;
        }

        public Criteria andRateSellerEqualTo(Byte value) {
            addCriterion("rate_seller =", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerNotEqualTo(Byte value) {
            addCriterion("rate_seller <>", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerGreaterThan(Byte value) {
            addCriterion("rate_seller >", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerGreaterThanOrEqualTo(Byte value) {
            addCriterion("rate_seller >=", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerLessThan(Byte value) {
            addCriterion("rate_seller <", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerLessThanOrEqualTo(Byte value) {
            addCriterion("rate_seller <=", value, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerIn(List<Byte> values) {
            addCriterion("rate_seller in", values, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerNotIn(List<Byte> values) {
            addCriterion("rate_seller not in", values, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerBetween(Byte value1, Byte value2) {
            addCriterion("rate_seller between", value1, value2, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andRateSellerNotBetween(Byte value1, Byte value2) {
            addCriterion("rate_seller not between", value1, value2, "rateSeller");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
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