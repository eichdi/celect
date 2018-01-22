package ru.kpfu.celect.dto;

import java.util.Objects;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:46.
 * celect
 */
public class CaseDto implements Dto {
    private int id;
    private String mainInfo;
    private String fullInfo;
    private Integer questionId;

    public CaseDto(int id, String mainInfo, String fullInfo) {
        this.id = id;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public CaseDto() {
    }

    public CaseDto(Builder builder) {
        this.id = builder.id;
        this.mainInfo = builder.mainInfo;
        this.fullInfo = builder.fullInfo;
    }

    public int getId() {
        return id;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public CaseDto setId(int id) {
        this.id = id;
        return this;
    }

    public CaseDto setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
        return this;
    }

    public CaseDto setFullInfo(String fullInfo) {
        this.fullInfo = fullInfo;
        return this;
    }

    public CaseDto setQuestionId(Integer questionId) {
        this.questionId = questionId;
        return this;
    }

    public static class Builder {
        private int id;
        private String mainInfo;
        private String fullInfo;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder mainInfo(String arg){
            this.mainInfo = arg;
            return this;
        }
        public Builder fullInfo(String arg){
            this.fullInfo = arg;
            return this;
        }
        public CaseDto build(){
            return new CaseDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseDto that = (CaseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(mainInfo, that.mainInfo) && Objects.equals(fullInfo, that.fullInfo);
    }
}
