package fr.lusuva.lusuvair.dtos.apidto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the data received from the WAQI (World Air Quality Index) API.
 */
public class WaqiDataDto {
    
    /**
     * The status of the API response.
     */
    private String status;
    
    /**
     * The data object containing air quality information.
     */
    @JsonProperty("data")
    private DataDto dataDto;

    /**
     * Default constructor for WaqiDataDto.
     * Initializes a new instance with default values.
     */
    public WaqiDataDto() {
        super();
    }

    /**
     * Parameterized constructor for WaqiDataDto.
     *
     * @param status   the status of the API response
     * @param dataDto  the data object containing air quality information
     */
    public WaqiDataDto(String status, DataDto dataDto) {
        super();
        this.status = status;
        this.dataDto = dataDto;
    }

    /**
     * Gets the status of the API response.
     *
     * @return the status of the API response
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the API response.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the data object containing air quality information.
     *
     * @return the data object
     */
    public DataDto getDataDto() {
        return dataDto;
    }

    /**
     * Sets the data object containing air quality information.
     *
     * @param dataDto the data object to set
     */
    public void setDataDto(DataDto dataDto) {
        this.dataDto = dataDto;
    }

    /**
     * Returns a string representation of the WaqiDataDto object.
     * 
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "WaqiDataDto {status=" + status + ", data=" + dataDto + "}";
    }
}
