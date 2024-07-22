package fr.lusuva.lusuvair.dtos.apidto;

/**
 * Represents the Air Quality Index (IAQI) data for various pollutants and environmental factors.
 */
public class IaqiDto {

    /**
     * Dew point data.
     */
    private ParticleDto dew;

    /**
     * Humidity data.
     */
    private ParticleDto h;

    /**
     * Nitrogen dioxide data.
     */
    private ParticleDto no2;

    /**
     * Ozone data.
     */
    private ParticleDto o3;

    /**
     * Atmospheric pressure data.
     */
    private ParticleDto p;

    /**
     * Particulate matter (PM10) data.
     */
    private ParticleDto pm10;

    /**
     * Particulate matter (PM2.5) data.
     */
    private ParticleDto pm25;

    /**
     * Sulfur dioxide data.
     */
    private ParticleDto so2;

    
    private ParticleDto t;

    
    private ParticleDto w;

    
    private ParticleDto wg;

    /**
     * Default constructor for IaqiDto.
     */
    public IaqiDto() {
        super();
    }

    /**
     * Parameterized constructor for IaqiDto.
     *
     * @param dew the dew point data
     * @param h the humidity data
     * @param no2 the nitrogen dioxide data
     * @param o3 the ozone data
     * @param p the atmospheric pressure data
     * @param pm10 the particulate matter (PM10) data
     * @param pm25 the particulate matter (PM2.5) data
     * @param so2 the sulfur dioxide data
     * @param t the temperature data
     * @param w the wind data
     * @param wg the wind gust data
     */
    public IaqiDto(ParticleDto dew, ParticleDto h, ParticleDto no2, ParticleDto o3, ParticleDto p, ParticleDto pm10,
                   ParticleDto pm25, ParticleDto so2, ParticleDto t, ParticleDto w, ParticleDto wg) {
        super();
        this.dew = dew;
        this.h = h;
        this.no2 = no2;
        this.o3 = o3;
        this.p = p;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.so2 = so2;
        this.t = t;
        this.w = w;
        this.wg = wg;
    }

    /**
     * Gets the dew point data.
     *
     * @return the dew point data
     */
    public ParticleDto getDew() {
        return dew;
    }

    /**
     * Sets the dew point data.
     *
     * @param dew the dew point data to set
     */
    public void setDew(ParticleDto dew) {
        this.dew = dew;
    }

    /**
     * Gets the humidity data.
     *
     * @return the humidity data
     */
    public ParticleDto getH() {
        return h;
    }

    /**
     * Sets the humidity data.
     *
     * @param h the humidity data to set
     */
    public void setH(ParticleDto h) {
        this.h = h;
    }

    /**
     * Gets the nitrogen dioxide data.
     *
     * @return the nitrogen dioxide data
     */
    public ParticleDto getNo2() {
        return no2;
    }

    /**
     * Sets the nitrogen dioxide data.
     *
     * @param no2 the nitrogen dioxide data to set
     */
    public void setNo2(ParticleDto no2) {
        this.no2 = no2;
    }

    /**
     * Gets the ozone data.
     *
     * @return the ozone data
     */
    public ParticleDto getO3() {
        return o3;
    }

    /**
     * Sets the ozone data.
     *
     * @param o3 the ozone data to set
     */
    public void setO3(ParticleDto o3) {
        this.o3 = o3;
    }

    /**
     * Gets the atmospheric pressure data.
     *
     * @return the atmospheric pressure data
     */
    public ParticleDto getP() {
        return p;
    }

    /**
     * Sets the atmospheric pressure data.
     *
     * @param p the atmospheric pressure data to set
     */
    public void setP(ParticleDto p) {
        this.p = p;
    }

    /**
     * Gets the particulate matter (PM10) data.
     *
     * @return the PM10 data
     */
    public ParticleDto getPm10() {
        return pm10;
    }

    /**
     * Sets the particulate matter (PM10) data.
     *
     * @param pm10 the PM10 data to set
     */
    public void setPm10(ParticleDto pm10) {
        this.pm10 = pm10;
    }

    /**
     * Gets the particulate matter (PM2.5) data.
     *
     * @return the PM2.5 data
     */
    public ParticleDto getPm25() {
        return pm25;
    }

    /**
     * Sets the particulate matter (PM2.5) data.
     *
     * @param pm25 the PM2.5 data to set
     */
    public void setPm25(ParticleDto pm25) {
        this.pm25 = pm25;
    }

    /**
     * Gets the sulfur dioxide data.
     *
     * @return the sulfur dioxide data
     */
    public ParticleDto getSo2() {
        return so2;
    }

    /**
     * Sets the sulfur dioxide data.
     *
     * @param so2 the sulfur dioxide data to set
     */
    public void setSo2(ParticleDto so2) {
        this.so2 = so2;
    }

    /**
     * 
     */
    public ParticleDto getT() {
        return t;
    }

    /**
     * 
     */
    public void setT(ParticleDto t) {
        this.t = t;
    }

    /**
     * 
     */
    public ParticleDto getW() {
        return w;
    }

    /**
     * 
     */
    public void setW(ParticleDto w) {
        this.w = w;
    }

    /**
     * 
     */
    public ParticleDto getWg() {
        return wg;
    }

    /**
     * 
     *
     * @param 
     */
    public void setWg(ParticleDto wg) {
        this.wg = wg;
    }

    @Override
    public String toString() {
        return "IaqiDto [dew=" + dew + ", h=" + h + ", no2=" + no2 + ", o3=" + o3 + ", p=" + p + ", pm10=" + pm10
                + ", pm25=" + pm25 + ", so2=" + so2 + ", t=" + t + ", w=" + w + ", wg=" + wg + "]";
    }
}
