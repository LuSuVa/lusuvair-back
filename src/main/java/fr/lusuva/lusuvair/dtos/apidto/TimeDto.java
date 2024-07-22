package fr.lusuva.lusuvair.dtos.apidto;

/**
 * Represents time-related information for the weather data.
 */
public class TimeDto {
    
    /**
     * The time in string format.
     */
    private String s;
    
    /**
     * The time zone of the time represented by this DTO.
     */
    private String tz;
    
    /**
     * The time value as an integer.
     */
    private int v;
    
    /**
     * The ISO 8601 representation of the time.
     */
    private String iso;

    /**
     * Default constructor for TimeDto.
     */
    public TimeDto() {
        super();
    }

    /**
     * Parameterized constructor for TimeDto.
     *
     * @param s   the time as a string
     * @param tz  the time zone
     * @param v   the time value as an integer
     * @param iso the ISO 8601 representation of the time
     */
    public TimeDto(String s, String tz, int v, String iso) {
        super();
        this.s = s;
        this.tz = tz;
        this.v = v;
        this.iso = iso;
    }

    /**
     * Gets the time as a string.
     *
     * @return the time string
     */
    public String getS() {
        return s;
    }

    /**
     * Sets the time as a string.
     *
     * @param s the time string to set
     */
    public void setS(String s) {
        this.s = s;
    }

    /**
     * Gets the time zone.
     *
     * @return the time zone
     */
    public String getTz() {
        return tz;
    }

    /**
     * Sets the time zone.
     *
     * @param tz the time zone to set
     */
    public void setTz(String tz) {
        this.tz = tz;
    }

    /**
     * Gets the time value as an integer.
     *
     * @return the time value
     */
    public int getV() {
        return v;
    }

    /**
     * Sets the time value as an integer.
     *
     * @param v the time value to set
     */
    public void setV(int v) {
        this.v = v;
    }

    /**
     * Gets the ISO 8601 representation of the time.
     *
     * @return the ISO 8601 representation of the time
     */
    public String getIso() {
        return iso;
    }

    /**
     * Sets the ISO 8601 representation of the time.
     *
     * @param iso the ISO 8601 representation to set
     */
    public void setIso(String iso) {
        this.iso = iso;
    }
}
