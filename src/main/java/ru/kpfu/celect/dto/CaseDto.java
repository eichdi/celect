package ru.kpfu.celect.dto;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:46.
 * celect
 */
public class CaseDto implements Dto {
    private int id;
    private String main_info;
    private String full_info;

    public CaseDto(int id, String main_info, String full_info) {
        this.id = id;
        this.main_info = main_info;
        this.full_info = full_info;
    }

    public CaseDto() {
    }

    public CaseDto(Builder builder) {
        this.id = builder.id;
        this.main_info = builder.main_info;
        this.full_info = builder.full_info;
    }

    public int getId() {
        return id;
    }

    public String getMain_info() {
        return main_info;
    }

    public String getFull_info() {
        return full_info;
    }

    public static class Builder {
        private int id;
        private String main_info;
        private String full_info;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder main_info(String arg){
            this.main_info = arg;
            return this;
        }
        public Builder full_info(String arg){
            this.full_info = arg;
            return this;
        }
        public CaseDto build(){
            return new CaseDto(this);
        }
    }
}
