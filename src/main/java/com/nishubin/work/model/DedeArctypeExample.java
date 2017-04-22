package com.nishubin.work.model;

import java.util.ArrayList;
import java.util.List;

public class DedeArctypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DedeArctypeExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTopidIsNull() {
            addCriterion("topid is null");
            return (Criteria) this;
        }

        public Criteria andTopidIsNotNull() {
            addCriterion("topid is not null");
            return (Criteria) this;
        }

        public Criteria andTopidEqualTo(Long value) {
            addCriterion("topid =", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidNotEqualTo(Long value) {
            addCriterion("topid <>", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidGreaterThan(Long value) {
            addCriterion("topid >", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidGreaterThanOrEqualTo(Long value) {
            addCriterion("topid >=", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidLessThan(Long value) {
            addCriterion("topid <", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidLessThanOrEqualTo(Long value) {
            addCriterion("topid <=", value, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidIn(List<Long> values) {
            addCriterion("topid in", values, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidNotIn(List<Long> values) {
            addCriterion("topid not in", values, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidBetween(Long value1, Long value2) {
            addCriterion("topid between", value1, value2, "topid");
            return (Criteria) this;
        }

        public Criteria andTopidNotBetween(Long value1, Long value2) {
            addCriterion("topid not between", value1, value2, "topid");
            return (Criteria) this;
        }

        public Criteria andSortrankIsNull() {
            addCriterion("sortrank is null");
            return (Criteria) this;
        }

        public Criteria andSortrankIsNotNull() {
            addCriterion("sortrank is not null");
            return (Criteria) this;
        }

        public Criteria andSortrankEqualTo(Short value) {
            addCriterion("sortrank =", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankNotEqualTo(Short value) {
            addCriterion("sortrank <>", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankGreaterThan(Short value) {
            addCriterion("sortrank >", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankGreaterThanOrEqualTo(Short value) {
            addCriterion("sortrank >=", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankLessThan(Short value) {
            addCriterion("sortrank <", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankLessThanOrEqualTo(Short value) {
            addCriterion("sortrank <=", value, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankIn(List<Short> values) {
            addCriterion("sortrank in", values, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankNotIn(List<Short> values) {
            addCriterion("sortrank not in", values, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankBetween(Short value1, Short value2) {
            addCriterion("sortrank between", value1, value2, "sortrank");
            return (Criteria) this;
        }

        public Criteria andSortrankNotBetween(Short value1, Short value2) {
            addCriterion("sortrank not between", value1, value2, "sortrank");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNull() {
            addCriterion("typename is null");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNotNull() {
            addCriterion("typename is not null");
            return (Criteria) this;
        }

        public Criteria andTypenameEqualTo(String value) {
            addCriterion("typename =", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotEqualTo(String value) {
            addCriterion("typename <>", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThan(String value) {
            addCriterion("typename >", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("typename >=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThan(String value) {
            addCriterion("typename <", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThanOrEqualTo(String value) {
            addCriterion("typename <=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLike(String value) {
            addCriterion("typename like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotLike(String value) {
            addCriterion("typename not like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameIn(List<String> values) {
            addCriterion("typename in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotIn(List<String> values) {
            addCriterion("typename not in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameBetween(String value1, String value2) {
            addCriterion("typename between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotBetween(String value1, String value2) {
            addCriterion("typename not between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypedirIsNull() {
            addCriterion("typedir is null");
            return (Criteria) this;
        }

        public Criteria andTypedirIsNotNull() {
            addCriterion("typedir is not null");
            return (Criteria) this;
        }

        public Criteria andTypedirEqualTo(String value) {
            addCriterion("typedir =", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirNotEqualTo(String value) {
            addCriterion("typedir <>", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirGreaterThan(String value) {
            addCriterion("typedir >", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirGreaterThanOrEqualTo(String value) {
            addCriterion("typedir >=", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirLessThan(String value) {
            addCriterion("typedir <", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirLessThanOrEqualTo(String value) {
            addCriterion("typedir <=", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirLike(String value) {
            addCriterion("typedir like", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirNotLike(String value) {
            addCriterion("typedir not like", value, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirIn(List<String> values) {
            addCriterion("typedir in", values, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirNotIn(List<String> values) {
            addCriterion("typedir not in", values, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirBetween(String value1, String value2) {
            addCriterion("typedir between", value1, value2, "typedir");
            return (Criteria) this;
        }

        public Criteria andTypedirNotBetween(String value1, String value2) {
            addCriterion("typedir not between", value1, value2, "typedir");
            return (Criteria) this;
        }

        public Criteria andIspartIsNull() {
            addCriterion("ispart is null");
            return (Criteria) this;
        }

        public Criteria andIspartIsNotNull() {
            addCriterion("ispart is not null");
            return (Criteria) this;
        }

        public Criteria andIspartEqualTo(Short value) {
            addCriterion("ispart =", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartNotEqualTo(Short value) {
            addCriterion("ispart <>", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartGreaterThan(Short value) {
            addCriterion("ispart >", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartGreaterThanOrEqualTo(Short value) {
            addCriterion("ispart >=", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartLessThan(Short value) {
            addCriterion("ispart <", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartLessThanOrEqualTo(Short value) {
            addCriterion("ispart <=", value, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartIn(List<Short> values) {
            addCriterion("ispart in", values, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartNotIn(List<Short> values) {
            addCriterion("ispart not in", values, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartBetween(Short value1, Short value2) {
            addCriterion("ispart between", value1, value2, "ispart");
            return (Criteria) this;
        }

        public Criteria andIspartNotBetween(Short value1, Short value2) {
            addCriterion("ispart not between", value1, value2, "ispart");
            return (Criteria) this;
        }

        public Criteria andSeotitleIsNull() {
            addCriterion("seotitle is null");
            return (Criteria) this;
        }

        public Criteria andSeotitleIsNotNull() {
            addCriterion("seotitle is not null");
            return (Criteria) this;
        }

        public Criteria andSeotitleEqualTo(String value) {
            addCriterion("seotitle =", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleNotEqualTo(String value) {
            addCriterion("seotitle <>", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleGreaterThan(String value) {
            addCriterion("seotitle >", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleGreaterThanOrEqualTo(String value) {
            addCriterion("seotitle >=", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleLessThan(String value) {
            addCriterion("seotitle <", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleLessThanOrEqualTo(String value) {
            addCriterion("seotitle <=", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleLike(String value) {
            addCriterion("seotitle like", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleNotLike(String value) {
            addCriterion("seotitle not like", value, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleIn(List<String> values) {
            addCriterion("seotitle in", values, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleNotIn(List<String> values) {
            addCriterion("seotitle not in", values, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleBetween(String value1, String value2) {
            addCriterion("seotitle between", value1, value2, "seotitle");
            return (Criteria) this;
        }

        public Criteria andSeotitleNotBetween(String value1, String value2) {
            addCriterion("seotitle not between", value1, value2, "seotitle");
            return (Criteria) this;
        }

        public Criteria andIshiddenIsNull() {
            addCriterion("ishidden is null");
            return (Criteria) this;
        }

        public Criteria andIshiddenIsNotNull() {
            addCriterion("ishidden is not null");
            return (Criteria) this;
        }

        public Criteria andIshiddenEqualTo(Short value) {
            addCriterion("ishidden =", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenNotEqualTo(Short value) {
            addCriterion("ishidden <>", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenGreaterThan(Short value) {
            addCriterion("ishidden >", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenGreaterThanOrEqualTo(Short value) {
            addCriterion("ishidden >=", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenLessThan(Short value) {
            addCriterion("ishidden <", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenLessThanOrEqualTo(Short value) {
            addCriterion("ishidden <=", value, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenIn(List<Short> values) {
            addCriterion("ishidden in", values, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenNotIn(List<Short> values) {
            addCriterion("ishidden not in", values, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenBetween(Short value1, Short value2) {
            addCriterion("ishidden between", value1, value2, "ishidden");
            return (Criteria) this;
        }

        public Criteria andIshiddenNotBetween(Short value1, Short value2) {
            addCriterion("ishidden not between", value1, value2, "ishidden");
            return (Criteria) this;
        }
    }

    /**
     */
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