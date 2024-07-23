package fr.lusuva.lusuvair.dtos.municipality;

import fr.lusuva.lusuvair.entities.Municipality;

public class MunicipalityResponseDto {
    
    private int id;
    private String name;
    private int insee;
    private int code;
    
    /**
     * @param id
     * @param name
     * @param insee
     * @param code
     */
    public MunicipalityResponseDto(Municipality municipality) {
        this.id = municipality.getId();
        this.name = municipality.getName();
        this.insee = municipality.getInseeCode();
        this.code = municipality.getZipCode();
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the insee
     */
    public int getInsee() {
        return insee;
    }
    /**
     * @param insee the insee to set
     */
    public void setInsee(int insee) {
        this.insee = insee;
    }
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    
}
