package com.web.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andNUserIdIsNull() {
            addCriterion("N_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andNUserIdIsNotNull() {
            addCriterion("N_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNUserIdEqualTo(Integer value) {
            addCriterion("N_USER_ID =", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdNotEqualTo(Integer value) {
            addCriterion("N_USER_ID <>", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdGreaterThan(Integer value) {
            addCriterion("N_USER_ID >", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_USER_ID >=", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdLessThan(Integer value) {
            addCriterion("N_USER_ID <", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("N_USER_ID <=", value, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdIn(List<Integer> values) {
            addCriterion("N_USER_ID in", values, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdNotIn(List<Integer> values) {
            addCriterion("N_USER_ID not in", values, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdBetween(Integer value1, Integer value2) {
            addCriterion("N_USER_ID between", value1, value2, "nUserId");
            return (Criteria) this;
        }

        public Criteria andNUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("N_USER_ID not between", value1, value2, "nUserId");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameIsNull() {
            addCriterion("VC_LOGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameIsNotNull() {
            addCriterion("VC_LOGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameEqualTo(String value) {
            addCriterion("VC_LOGIN_NAME =", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameNotEqualTo(String value) {
            addCriterion("VC_LOGIN_NAME <>", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameGreaterThan(String value) {
            addCriterion("VC_LOGIN_NAME >", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("VC_LOGIN_NAME >=", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameLessThan(String value) {
            addCriterion("VC_LOGIN_NAME <", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameLessThanOrEqualTo(String value) {
            addCriterion("VC_LOGIN_NAME <=", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameLike(String value) {
            addCriterion("VC_LOGIN_NAME like", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameNotLike(String value) {
            addCriterion("VC_LOGIN_NAME not like", value, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameIn(List<String> values) {
            addCriterion("VC_LOGIN_NAME in", values, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameNotIn(List<String> values) {
            addCriterion("VC_LOGIN_NAME not in", values, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameBetween(String value1, String value2) {
            addCriterion("VC_LOGIN_NAME between", value1, value2, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcLoginNameNotBetween(String value1, String value2) {
            addCriterion("VC_LOGIN_NAME not between", value1, value2, "vcLoginName");
            return (Criteria) this;
        }

        public Criteria andVcPasswordIsNull() {
            addCriterion("VC_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andVcPasswordIsNotNull() {
            addCriterion("VC_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andVcPasswordEqualTo(String value) {
            addCriterion("VC_PASSWORD =", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordNotEqualTo(String value) {
            addCriterion("VC_PASSWORD <>", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordGreaterThan(String value) {
            addCriterion("VC_PASSWORD >", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("VC_PASSWORD >=", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordLessThan(String value) {
            addCriterion("VC_PASSWORD <", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordLessThanOrEqualTo(String value) {
            addCriterion("VC_PASSWORD <=", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordLike(String value) {
            addCriterion("VC_PASSWORD like", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordNotLike(String value) {
            addCriterion("VC_PASSWORD not like", value, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordIn(List<String> values) {
            addCriterion("VC_PASSWORD in", values, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordNotIn(List<String> values) {
            addCriterion("VC_PASSWORD not in", values, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordBetween(String value1, String value2) {
            addCriterion("VC_PASSWORD between", value1, value2, "vcPassword");
            return (Criteria) this;
        }

        public Criteria andVcPasswordNotBetween(String value1, String value2) {
            addCriterion("VC_PASSWORD not between", value1, value2, "vcPassword");
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