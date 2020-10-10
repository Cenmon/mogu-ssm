package com.web.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class TScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TScoreExample() {
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

        public Criteria andNStudentIdIsNull() {
            addCriterion("N_STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNStudentIdIsNotNull() {
            addCriterion("N_STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNStudentIdEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID =", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID <>", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdGreaterThan(Integer value) {
            addCriterion("N_STUDENT_ID >", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID >=", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdLessThan(Integer value) {
            addCriterion("N_STUDENT_ID <", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID <=", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdIn(List<Integer> values) {
            addCriterion("N_STUDENT_ID in", values, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotIn(List<Integer> values) {
            addCriterion("N_STUDENT_ID not in", values, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("N_STUDENT_ID between", value1, value2, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("N_STUDENT_ID not between", value1, value2, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdIsNull() {
            addCriterion("N_COURSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNCourseIdIsNotNull() {
            addCriterion("N_COURSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNCourseIdEqualTo(Integer value) {
            addCriterion("N_COURSE_ID =", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdNotEqualTo(Integer value) {
            addCriterion("N_COURSE_ID <>", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdGreaterThan(Integer value) {
            addCriterion("N_COURSE_ID >", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_COURSE_ID >=", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdLessThan(Integer value) {
            addCriterion("N_COURSE_ID <", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("N_COURSE_ID <=", value, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdIn(List<Integer> values) {
            addCriterion("N_COURSE_ID in", values, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdNotIn(List<Integer> values) {
            addCriterion("N_COURSE_ID not in", values, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("N_COURSE_ID between", value1, value2, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andNCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("N_COURSE_ID not between", value1, value2, "nCourseId");
            return (Criteria) this;
        }

        public Criteria andFScoreIsNull() {
            addCriterion("F_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andFScoreIsNotNull() {
            addCriterion("F_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andFScoreEqualTo(Float value) {
            addCriterion("F_SCORE =", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreNotEqualTo(Float value) {
            addCriterion("F_SCORE <>", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreGreaterThan(Float value) {
            addCriterion("F_SCORE >", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("F_SCORE >=", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreLessThan(Float value) {
            addCriterion("F_SCORE <", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreLessThanOrEqualTo(Float value) {
            addCriterion("F_SCORE <=", value, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreIn(List<Float> values) {
            addCriterion("F_SCORE in", values, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreNotIn(List<Float> values) {
            addCriterion("F_SCORE not in", values, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreBetween(Float value1, Float value2) {
            addCriterion("F_SCORE between", value1, value2, "fScore");
            return (Criteria) this;
        }

        public Criteria andFScoreNotBetween(Float value1, Float value2) {
            addCriterion("F_SCORE not between", value1, value2, "fScore");
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