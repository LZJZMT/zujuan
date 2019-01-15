package com.zujuan.pojo;

import java.io.Serializable;

public class Examination implements Serializable {
    private Long eid;

    private String question;

    private String optionJson;

    private String answer;

    private String imgUrl;

    private Double degree;

    private Integer type;

    private Long knowId;

    private static final long serialVersionUID = 1L;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getOptionJson() {
        return optionJson;
    }

    public void setOptionJson(String optionJson) {
        this.optionJson = optionJson == null ? null : optionJson.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getKnowId() {
        return knowId;
    }

    public void setKnowId(Long knowId) {
        this.knowId = knowId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Examination other = (Examination) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getOptionJson() == null ? other.getOptionJson() == null : this.getOptionJson().equals(other.getOptionJson()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getKnowId() == null ? other.getKnowId() == null : this.getKnowId().equals(other.getKnowId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getOptionJson() == null) ? 0 : getOptionJson().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getKnowId() == null) ? 0 : getKnowId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", question=").append(question);
        sb.append(", optionJson=").append(optionJson);
        sb.append(", answer=").append(answer);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", degree=").append(degree);
        sb.append(", type=").append(type);
        sb.append(", knowId=").append(knowId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}