package com.web.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCourseExample() {
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

        public Criteria andVcCourseNameIsNull() {
            addCriterion("VC_COURSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameIsNotNull() {
            addCriterion("VC_COURSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameEqualTo(String value) {
            addCriterion("VC_COURSE_NAME =", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameNotEqualTo(String value) {
            addCriterion("VC_COURSE_NAME <>", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameGreaterThan(String value) {
            addCriterion("VC_COURSE_NAME >", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("VC_COURSE_NAME >=", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameLessThan(String value) {
            addCriterion("VC_COURSE_NAME <", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameLessThanOrEqualTo(String value) {
            addCriterion("VC_COURSE_NAME <=", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameLike(String value) {
            addCriterion("VC_COURSE_NAME like", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameNotLike(String value) {
            addCriterion("VC_COURSE_NAME not like", value, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameIn(List<String> values) {
            addCriterion("VC_COURSE_NAME in", values, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameNotIn(List<String> values) {
            addCriterion("VC_COURSE_NAME not in", values, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameBetween(String value1, String value2) {
            addCriterion("VC_COURSE_NAME between", value1, value2, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andVcCourseNameNotBetween(String value1, String value2) {
            addCriterion("VC_COURSE_NAME not between", value1, value2, "vcCourseName");
            return (Criteria) this;
        }

        public Criteria andNTypeIsNull() {
            addCriterion("N_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNTypeIsNotNull() {
            addCriterion("N_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNTypeEqualTo(Integer value) {
            addCriterion("N_TYPE =", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeNotEqualTo(Integer value) {
            addCriterion("N_TYPE <>", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeGreaterThan(Integer value) {
            addCriterion("N_TYPE >", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_TYPE >=", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeLessThan(Integer value) {
            addCriterion("N_TYPE <", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeLessThanOrEqualTo(Integer value) {
            addCriterion("N_TYPE <=", value, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeIn(List<Integer> values) {
            addCriterion("N_TYPE in", values, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeNotIn(List<Integer> values) {
            addCriterion("N_TYPE not in", values, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeBetween(Integer value1, Integer value2) {
            addCriterion("N_TYPE between", value1, value2, "nType");
            return (Criteria) this;
        }

        public Criteria andNTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("N_TYPE not between", value1, value2, "nType");
            return (Criteria) this;
        }

        public Criteria andFCreditIsNull() {
            addCriterion("F_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andFCreditIsNotNull() {
            addCriterion("F_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andFCreditEqualTo(Float value) {
            addCriterion("F_CREDIT =", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditNotEqualTo(Float value) {
            addCriterion("F_CREDIT <>", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditGreaterThan(Float value) {
            addCriterion("F_CREDIT >", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditGreaterThanOrEqualTo(Float value) {
            addCriterion("F_CREDIT >=", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditLessThan(Float value) {
            addCriterion("F_CREDIT <", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditLessThanOrEqualTo(Float value) {
            addCriterion("F_CREDIT <=", value, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditIn(List<Float> values) {
            addCriterion("F_CREDIT in", values, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditNotIn(List<Float> values) {
            addCriterion("F_CREDIT not in", values, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditBetween(Float value1, Float value2) {
            addCriterion("F_CREDIT between", value1, value2, "fCredit");
            return (Criteria) this;
        }

        public Criteria andFCreditNotBetween(Float value1, Float value2) {
            addCriterion("F_CREDIT not between", value1, value2, "fCredit");
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