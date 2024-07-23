package fr.lusuva.lusuvair.dtos.apiweatherdto;

/**
 * DTO representing a weather station with its name and associated city.
 */
public class StationDto {
    
    /** The name of the weather station */
    private String name;

    /** The city where the weather station is located */
    private String city;

    /**
     * Constructs a new StationDto with default values.
     */
    public StationDto() {
    }

    /**
     * Constructs a new StationDto with the specified name and city.
     * 
     * @param name the name of the weather station
     * @param city the city where the weather station is located
     */
    public StationDto(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /**
     * Returns the name of the weather station.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the weather station.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the city where the weather station is located.
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the weather station is located.
     * 
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
}
