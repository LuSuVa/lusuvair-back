package fr.lusuva.lusuvair.dtos.municipality;

import fr.lusuva.lusuvair.entities.Municipality;

/**
 * Data Transfer Object for Municipality responses.
 */
public class MunicipalityResponseDto {
    
    /**
     * The unique identifier of the municipality.
     */
    private int id;

    /**
     * The name of the municipality.
     */
    private String name;

    /**
     * The INSEE code of the municipality.
     */
    private int insee;

    /**
     * The ZIP code of the municipality.
     */
    private int code;

    /**
     * Constructs a MunicipalityResponseDto from a Municipality entity.
     *
     * @param municipality the Municipality entity to convert to a DTO
     */
    public MunicipalityResponseDto(Municipality municipality) {
        this.id = municipality.getId();
        this.name = municipality.getName();
        this.insee = municipality.getInseeCode();
        this.code = municipality.getZipCode();
    }

    /**
     * Gets the unique identifier of the municipality.
     *
     * @return the id of the municipality
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the municipality.
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the municipality.
     *
     * @return the name of the municipality
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the municipality.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the INSEE code of the municipality.
     *
     * @return the INSEE code of the municipality
     */
    public int getInsee() {
        return insee;
    }

    /**
     * Sets the INSEE code of the municipality.
     *
     * @param insee the INSEE code to set
     */
    public void setInsee(int insee) {
        this.insee = insee;
    }

    /**
     * Gets the ZIP code of the municipality.
     *
     * @return the ZIP code of the municipality
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the ZIP code of the municipality.
     *
     * @param code the ZIP code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
