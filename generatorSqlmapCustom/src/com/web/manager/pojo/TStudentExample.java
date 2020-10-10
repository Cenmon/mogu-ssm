package com.web.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class TStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStudentExample() {
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

        public Criteria andVcStudentCodeIsNull() {
            addCriterion("VC_STUDENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeIsNotNull() {
            addCriterion("VC_STUDENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeEqualTo(String value) {
            addCriterion("VC_STUDENT_CODE =", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeNotEqualTo(String value) {
            addCriterion("VC_STUDENT_CODE <>", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeGreaterThan(String value) {
            addCriterion("VC_STUDENT_CODE >", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("VC_STUDENT_CODE >=", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeLessThan(String value) {
            addCriterion("VC_STUDENT_CODE <", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeLessThanOrEqualTo(String value) {
            addCriterion("VC_STUDENT_CODE <=", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeLike(String value) {
            addCriterion("VC_STUDENT_CODE like", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeNotLike(String value) {
            addCriterion("VC_STUDENT_CODE not like", value, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeIn(List<String> values) {
            addCriterion("VC_STUDENT_CODE in", values, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeNotIn(List<String> values) {
            addCriterion("VC_STUDENT_CODE not in", values, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeBetween(String value1, String value2) {
            addCriterion("VC_STUDENT_CODE between", value1, value2, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentCodeNotBetween(String value1, String value2) {
            addCriterion("VC_STUDENT_CODE not between", value1, value2, "vcStudentCode");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameIsNull() {
            addCriterion("VC_STUDENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameIsNotNull() {
            addCriterion("VC_STUDENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameEqualTo(String value) {
            addCriterion("VC_STUDENT_NAME =", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameNotEqualTo(String value) {
            addCriterion("VC_STUDENT_NAME <>", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameGreaterThan(String value) {
            addCriterion("VC_STUDENT_NAME >", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("VC_STUDENT_NAME >=", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameLessThan(String value) {
            addCriterion("VC_STUDENT_NAME <", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameLessThanOrEqualTo(String value) {
            addCriterion("VC_STUDENT_NAME <=", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameLike(String value) {
            addCriterion("VC_STUDENT_NAME like", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameNotLike(String value) {
            addCriterion("VC_STUDENT_NAME not like", value, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameIn(List<String> values) {
            addCriterion("VC_STUDENT_NAME in", values, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameNotIn(List<String> values) {
            addCriterion("VC_STUDENT_NAME not in", values, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameBetween(String value1, String value2) {
            addCriterion("VC_STUDENT_NAME between", value1, value2, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andVcStudentNameNotBetween(String value1, String value2) {
            addCriterion("VC_STUDENT_NAME not between", value1, value2, "vcStudentName");
            return (Criteria) this;
        }

        public Criteria andNSexIsNull() {
            addCriterion("N_SEX is null");
            return (Criteria) this;
        }

        public Criteria andNSexIsNotNull() {
            addCriterion("N_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andNSexEqualTo(Integer value) {
            addCriterion("N_SEX =", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexNotEqualTo(Integer value) {
            addCriterion("N_SEX <>", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexGreaterThan(Integer value) {
            addCriterion("N_SEX >", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_SEX >=", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexLessThan(Integer value) {
            addCriterion("N_SEX <", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexLessThanOrEqualTo(Integer value) {
            addCriterion("N_SEX <=", value, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexIn(List<Integer> values) {
            addCriterion("N_SEX in", values, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexNotIn(List<Integer> values) {
            addCriterion("N_SEX not in", values, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexBetween(Integer value1, Integer value2) {
            addCriterion("N_SEX between", value1, value2, "nSex");
            return (Criteria) this;
        }

        public Criteria andNSexNotBetween(Integer value1, Integer value2) {
            addCriterion("N_SEX not between", value1, value2, "nSex");
            return (Criteria) this;
        }

        public Criteria andNGradeIsNull() {
            addCriterion("N_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andNGradeIsNotNull() {
            addCriterion("N_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andNGradeEqualTo(Integer value) {
            addCriterion("N_GRADE =", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeNotEqualTo(Integer value) {
            addCriterion("N_GRADE <>", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeGreaterThan(Integer value) {
            addCriterion("N_GRADE >", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_GRADE >=", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeLessThan(Integer value) {
            addCriterion("N_GRADE <", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeLessThanOrEqualTo(Integer value) {
            addCriterion("N_GRADE <=", value, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeIn(List<Integer> values) {
            addCriterion("N_GRADE in", values, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeNotIn(List<Integer> values) {
            addCriterion("N_GRADE not in", values, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeBetween(Integer value1, Integer value2) {
            addCriterion("N_GRADE between", value1, value2, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("N_GRADE not between", value1, value2, "nGrade");
            return (Criteria) this;
        }

        public Criteria andNMajorIsNull() {
            addCriterion("N_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andNMajorIsNotNull() {
            addCriterion("N_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andNMajorEqualTo(Integer value) {
            addCriterion("N_MAJOR =", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorNotEqualTo(Integer value) {
            addCriterion("N_MAJOR <>", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorGreaterThan(Integer value) {
            addCriterion("N_MAJOR >", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_MAJOR >=", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorLessThan(Integer value) {
            addCriterion("N_MAJOR <", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorLessThanOrEqualTo(Integer value) {
            addCriterion("N_MAJOR <=", value, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorIn(List<Integer> values) {
            addCriterion("N_MAJOR in", values, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorNotIn(List<Integer> values) {
            addCriterion("N_MAJOR not in", values, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorBetween(Integer value1, Integer value2) {
            addCriterion("N_MAJOR between", value1, value2, "nMajor");
            return (Criteria) this;
        }

        public Criteria andNMajorNotBetween(Integer value1, Integer value2) {
            addCriterion("N_MAJOR not between", value1, value2, "nMajor");
            return (Criteria) this;
        }

        public Criteria andVcDetailIsNull() {
            addCriterion("VC_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andVcDetailIsNotNull() {
            addCriterion("VC_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andVcDetailEqualTo(String value) {
            addCriterion("VC_DETAIL =", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailNotEqualTo(String value) {
            addCriterion("VC_DETAIL <>", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailGreaterThan(String value) {
            addCriterion("VC_DETAIL >", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailGreaterThanOrEqualTo(String value) {
            addCriterion("VC_DETAIL >=", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailLessThan(String value) {
            addCriterion("VC_DETAIL <", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailLessThanOrEqualTo(String value) {
            addCriterion("VC_DETAIL <=", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailLike(String value) {
            addCriterion("VC_DETAIL like", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailNotLike(String value) {
            addCriterion("VC_DETAIL not like", value, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailIn(List<String> values) {
            addCriterion("VC_DETAIL in", values, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailNotIn(List<String> values) {
            addCriterion("VC_DETAIL not in", values, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailBetween(String value1, String value2) {
            addCriterion("VC_DETAIL between", value1, value2, "vcDetail");
            return (Criteria) this;
        }

        public Criteria andVcDetailNotBetween(String value1, String value2) {
            addCriterion("VC_DETAIL not between", value1, value2, "vcDetail");
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