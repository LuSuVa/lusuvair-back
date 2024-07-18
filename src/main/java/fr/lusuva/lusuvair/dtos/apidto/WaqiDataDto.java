package fr.lusuva.lusuvair.dtos.apidto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WaqiDataDto {
    private String status;
    
    @JsonProperty("data")
    private DataDto dataDto;

    // Constructeur sans arguments
    public WaqiDataDto() {
        super();
    }

    // Constructeur avec arguments
    public WaqiDataDto(String status, DataDto dataDto) {
        super();
        this.status = status;
        this.dataDto = dataDto;
    }

    // Getters et Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataDto getDataDto() {
        return dataDto;
    }

    public void setDataDto(DataDto dataDto) {
        this.dataDto = dataDto;
    }

    @Override
    public String toString() {
        return "WaqiDataDto {status=" + status + ", data=" + dataDto + "}";
    }
}
