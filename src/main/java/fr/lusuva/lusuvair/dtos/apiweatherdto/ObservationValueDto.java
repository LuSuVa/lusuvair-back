package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO representing a single observation value with its unit.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationValueDto {

    /** The value of the observation */
    private String value;
    
    /** The unit of the observation value */
    private String unit;

    /**
     * Constructs a new ObservationValueDto with default values.
     */
    public ObservationValueDto() {
    }

    /**
     * Constructs a new ObservationValueDto with the specified values.
     * 
     * @param value the observation value
     * @param unit the unit of the observation value
     */
    public ObservationValueDto(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Returns the value of the observation.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the observation.
     * 
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the unit of the observation value.
     * 
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the unit of the observation value.
     * 
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
