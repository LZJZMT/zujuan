package com.zujuan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamPaperExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andNjzyIsNull() {
            addCriterion("njzy is null");
            return (Criteria) this;
        }

        public Criteria andNjzyIsNotNull() {
            addCriterion("njzy is not null");
            return (Criteria) this;
        }

        public Criteria andNjzyEqualTo(String value) {
            addCriterion("njzy =", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyNotEqualTo(String value) {
            addCriterion("njzy <>", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyGreaterThan(String value) {
            addCriterion("njzy >", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyGreaterThanOrEqualTo(String value) {
            addCriterion("njzy >=", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyLessThan(String value) {
            addCriterion("njzy <", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyLessThanOrEqualTo(String value) {
            addCriterion("njzy <=", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyLike(String value) {
            addCriterion("njzy like", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyNotLike(String value) {
            addCriterion("njzy not like", value, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyIn(List<String> values) {
            addCriterion("njzy in", values, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyNotIn(List<String> values) {
            addCriterion("njzy not in", values, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyBetween(String value1, String value2) {
            addCriterion("njzy between", value1, value2, "njzy");
            return (Criteria) this;
        }

        public Criteria andNjzyNotBetween(String value1, String value2) {
            addCriterion("njzy not between", value1, value2, "njzy");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("exam_time is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("exam_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(Date value) {
            addCriterion("exam_time =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(Date value) {
            addCriterion("exam_time <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(Date value) {
            addCriterion("exam_time >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exam_time >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(Date value) {
            addCriterion("exam_time <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(Date value) {
            addCriterion("exam_time <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<Date> values) {
            addCriterion("exam_time in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<Date> values) {
            addCriterion("exam_time not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(Date value1, Date value2) {
            addCriterion("exam_time between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(Date value1, Date value2) {
            addCriterion("exam_time not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeIsNull() {
            addCriterion("revise_time is null");
            return (Criteria) this;
        }

        public Criteria andReviseTimeIsNotNull() {
            addCriterion("revise_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviseTimeEqualTo(Date value) {
            addCriterion("revise_time =", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeNotEqualTo(Date value) {
            addCriterion("revise_time <>", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeGreaterThan(Date value) {
            addCriterion("revise_time >", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("revise_time >=", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeLessThan(Date value) {
            addCriterion("revise_time <", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeLessThanOrEqualTo(Date value) {
            addCriterion("revise_time <=", value, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeIn(List<Date> values) {
            addCriterion("revise_time in", values, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeNotIn(List<Date> values) {
            addCriterion("revise_time not in", values, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeBetween(Date value1, Date value2) {
            addCriterion("revise_time between", value1, value2, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andReviseTimeNotBetween(Date value1, Date value2) {
            addCriterion("revise_time not between", value1, value2, "reviseTime");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNull() {
            addCriterion("degree is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("degree is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(Double value) {
            addCriterion("degree =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(Double value) {
            addCriterion("degree <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(Double value) {
            addCriterion("degree >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(Double value) {
            addCriterion("degree >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(Double value) {
            addCriterion("degree <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(Double value) {
            addCriterion("degree <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<Double> values) {
            addCriterion("degree in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<Double> values) {
            addCriterion("degree not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(Double value1, Double value2) {
            addCriterion("degree between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(Double value1, Double value2) {
            addCriterion("degree not between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andXzScoreIsNull() {
            addCriterion("xz_score is null");
            return (Criteria) this;
        }

        public Criteria andXzScoreIsNotNull() {
            addCriterion("xz_score is not null");
            return (Criteria) this;
        }

        public Criteria andXzScoreEqualTo(Integer value) {
            addCriterion("xz_score =", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreNotEqualTo(Integer value) {
            addCriterion("xz_score <>", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreGreaterThan(Integer value) {
            addCriterion("xz_score >", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("xz_score >=", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreLessThan(Integer value) {
            addCriterion("xz_score <", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreLessThanOrEqualTo(Integer value) {
            addCriterion("xz_score <=", value, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreIn(List<Integer> values) {
            addCriterion("xz_score in", values, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreNotIn(List<Integer> values) {
            addCriterion("xz_score not in", values, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreBetween(Integer value1, Integer value2) {
            addCriterion("xz_score between", value1, value2, "xzScore");
            return (Criteria) this;
        }

        public Criteria andXzScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("xz_score not between", value1, value2, "xzScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreIsNull() {
            addCriterion("tk_score is null");
            return (Criteria) this;
        }

        public Criteria andTkScoreIsNotNull() {
            addCriterion("tk_score is not null");
            return (Criteria) this;
        }

        public Criteria andTkScoreEqualTo(Integer value) {
            addCriterion("tk_score =", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreNotEqualTo(Integer value) {
            addCriterion("tk_score <>", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreGreaterThan(Integer value) {
            addCriterion("tk_score >", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("tk_score >=", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreLessThan(Integer value) {
            addCriterion("tk_score <", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreLessThanOrEqualTo(Integer value) {
            addCriterion("tk_score <=", value, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreIn(List<Integer> values) {
            addCriterion("tk_score in", values, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreNotIn(List<Integer> values) {
            addCriterion("tk_score not in", values, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreBetween(Integer value1, Integer value2) {
            addCriterion("tk_score between", value1, value2, "tkScore");
            return (Criteria) this;
        }

        public Criteria andTkScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("tk_score not between", value1, value2, "tkScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreIsNull() {
            addCriterion("pd_score is null");
            return (Criteria) this;
        }

        public Criteria andPdScoreIsNotNull() {
            addCriterion("pd_score is not null");
            return (Criteria) this;
        }

        public Criteria andPdScoreEqualTo(Integer value) {
            addCriterion("pd_score =", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreNotEqualTo(Integer value) {
            addCriterion("pd_score <>", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreGreaterThan(Integer value) {
            addCriterion("pd_score >", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_score >=", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreLessThan(Integer value) {
            addCriterion("pd_score <", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreLessThanOrEqualTo(Integer value) {
            addCriterion("pd_score <=", value, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreIn(List<Integer> values) {
            addCriterion("pd_score in", values, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreNotIn(List<Integer> values) {
            addCriterion("pd_score not in", values, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreBetween(Integer value1, Integer value2) {
            addCriterion("pd_score between", value1, value2, "pdScore");
            return (Criteria) this;
        }

        public Criteria andPdScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_score not between", value1, value2, "pdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreIsNull() {
            addCriterion("wd_score is null");
            return (Criteria) this;
        }

        public Criteria andWdScoreIsNotNull() {
            addCriterion("wd_score is not null");
            return (Criteria) this;
        }

        public Criteria andWdScoreEqualTo(Integer value) {
            addCriterion("wd_score =", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreNotEqualTo(Integer value) {
            addCriterion("wd_score <>", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreGreaterThan(Integer value) {
            addCriterion("wd_score >", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("wd_score >=", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreLessThan(Integer value) {
            addCriterion("wd_score <", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreLessThanOrEqualTo(Integer value) {
            addCriterion("wd_score <=", value, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreIn(List<Integer> values) {
            addCriterion("wd_score in", values, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreNotIn(List<Integer> values) {
            addCriterion("wd_score not in", values, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreBetween(Integer value1, Integer value2) {
            addCriterion("wd_score between", value1, value2, "wdScore");
            return (Criteria) this;
        }

        public Criteria andWdScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("wd_score not between", value1, value2, "wdScore");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
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