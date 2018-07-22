package com.yyc.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Short value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Short value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Short value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Short value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Short value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Short> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Short> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Short value1, Short value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Short value1, Short value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andMenuSrcIsNull() {
            addCriterion("MENU_SRC is null");
            return (Criteria) this;
        }

        public Criteria andMenuSrcIsNotNull() {
            addCriterion("MENU_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSrcEqualTo(String value) {
            addCriterion("MENU_SRC =", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcNotEqualTo(String value) {
            addCriterion("MENU_SRC <>", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcGreaterThan(String value) {
            addCriterion("MENU_SRC >", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_SRC >=", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcLessThan(String value) {
            addCriterion("MENU_SRC <", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcLessThanOrEqualTo(String value) {
            addCriterion("MENU_SRC <=", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcLike(String value) {
            addCriterion("MENU_SRC like", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcNotLike(String value) {
            addCriterion("MENU_SRC not like", value, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcIn(List<String> values) {
            addCriterion("MENU_SRC in", values, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcNotIn(List<String> values) {
            addCriterion("MENU_SRC not in", values, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcBetween(String value1, String value2) {
            addCriterion("MENU_SRC between", value1, value2, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuSrcNotBetween(String value1, String value2) {
            addCriterion("MENU_SRC not between", value1, value2, "menuSrc");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdIsNull() {
            addCriterion("MENU_PARMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdIsNotNull() {
            addCriterion("MENU_PARMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdEqualTo(String value) {
            addCriterion("MENU_PARMENT_ID =", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdNotEqualTo(String value) {
            addCriterion("MENU_PARMENT_ID <>", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdGreaterThan(String value) {
            addCriterion("MENU_PARMENT_ID >", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_PARMENT_ID >=", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdLessThan(String value) {
            addCriterion("MENU_PARMENT_ID <", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdLessThanOrEqualTo(String value) {
            addCriterion("MENU_PARMENT_ID <=", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdLike(String value) {
            addCriterion("MENU_PARMENT_ID like", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdNotLike(String value) {
            addCriterion("MENU_PARMENT_ID not like", value, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdIn(List<String> values) {
            addCriterion("MENU_PARMENT_ID in", values, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdNotIn(List<String> values) {
            addCriterion("MENU_PARMENT_ID not in", values, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdBetween(String value1, String value2) {
            addCriterion("MENU_PARMENT_ID between", value1, value2, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuParmentIdNotBetween(String value1, String value2) {
            addCriterion("MENU_PARMENT_ID not between", value1, value2, "menuParmentId");
            return (Criteria) this;
        }

        public Criteria andMenuIndexIsNull() {
            addCriterion("MENU_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andMenuIndexIsNotNull() {
            addCriterion("MENU_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIndexEqualTo(String value) {
            addCriterion("MENU_INDEX =", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexNotEqualTo(String value) {
            addCriterion("MENU_INDEX <>", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexGreaterThan(String value) {
            addCriterion("MENU_INDEX >", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_INDEX >=", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexLessThan(String value) {
            addCriterion("MENU_INDEX <", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexLessThanOrEqualTo(String value) {
            addCriterion("MENU_INDEX <=", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexLike(String value) {
            addCriterion("MENU_INDEX like", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexNotLike(String value) {
            addCriterion("MENU_INDEX not like", value, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexIn(List<String> values) {
            addCriterion("MENU_INDEX in", values, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexNotIn(List<String> values) {
            addCriterion("MENU_INDEX not in", values, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexBetween(String value1, String value2) {
            addCriterion("MENU_INDEX between", value1, value2, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuIndexNotBetween(String value1, String value2) {
            addCriterion("MENU_INDEX not between", value1, value2, "menuIndex");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIsNull() {
            addCriterion("MENU_MARK is null");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIsNotNull() {
            addCriterion("MENU_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andMenuMarkEqualTo(String value) {
            addCriterion("MENU_MARK =", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotEqualTo(String value) {
            addCriterion("MENU_MARK <>", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkGreaterThan(String value) {
            addCriterion("MENU_MARK >", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_MARK >=", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkLessThan(String value) {
            addCriterion("MENU_MARK <", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkLessThanOrEqualTo(String value) {
            addCriterion("MENU_MARK <=", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkLike(String value) {
            addCriterion("MENU_MARK like", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotLike(String value) {
            addCriterion("MENU_MARK not like", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIn(List<String> values) {
            addCriterion("MENU_MARK in", values, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotIn(List<String> values) {
            addCriterion("MENU_MARK not in", values, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkBetween(String value1, String value2) {
            addCriterion("MENU_MARK between", value1, value2, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotBetween(String value1, String value2) {
            addCriterion("MENU_MARK not between", value1, value2, "menuMark");
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