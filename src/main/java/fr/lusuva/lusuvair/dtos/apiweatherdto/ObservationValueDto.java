package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationValueDto {

    private String value;
    private String unit;

    public ObservationValueDto() {
    }

    /**
     * @param value
     * @param unit
     */
    public ObservationValueDto(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
