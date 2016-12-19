package ru.kpfu.celect.dto;

import java.util.Objects;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:18.
 * celect
 */
public class InterviewDto implements Dto {
    private int id;
    private String info;

    public String getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }

    public InterviewDto() {
    }

    public InterviewDto(String info) {
        this.info = info;
    }

    public InterviewDto(String info, int id) {
        this.info = info;
        this.id = id;
    }

    public InterviewDto(Builder builder) {
        this.info = builder.info;
        this.id = builder.id;
    }

    public static class Builder {
        private int id;
        private String info;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }

        public Builder info(String arg){
            this.info = arg;
            return this;
        }
        public InterviewDto build(){
            return new InterviewDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewDto that = (InterviewDto) o;
        return Objects.equals(id, that.id) && Objects.equals(info, that.info);
    }
}
