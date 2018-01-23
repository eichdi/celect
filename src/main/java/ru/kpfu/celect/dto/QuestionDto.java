package ru.kpfu.celect.dto;

import java.util.List;

/**
 * Вопрос пользователя
 *
 *
 * @author Khairutdinov Samat
 * @since 23.01.2018
 */
public class QuestionDto {

    private Integer id;

    private String info;

    private List<CaseDto> caseDtoList;

    private TestDto testDto;

    public Integer getId() {
        return id;
    }

    public QuestionDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public QuestionDto setInfo(String info) {
        this.info = info;
        return this;
    }

    public List<CaseDto> getCaseDtoList() {
        return caseDtoList;
    }

    public QuestionDto setCaseDtoList(List<CaseDto> caseDtoList) {
        this.caseDtoList = caseDtoList;
        return this;
    }

    public TestDto getTestDto() {
        return testDto;
    }

    public QuestionDto setTestDto(TestDto testDto) {
        this.testDto = testDto;
        return this;
    }
}
