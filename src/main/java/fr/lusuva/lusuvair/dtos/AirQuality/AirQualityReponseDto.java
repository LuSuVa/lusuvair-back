package fr.lusuva.lusuvair.dtos.AirQuality;

import java.util.List;

import fr.lusuva.lusuvair.dtos.Particle.ParticleResponseDto;
import fr.lusuva.lusuvair.dtos.municipality.MunicipalityResponseDto;
import fr.lusuva.lusuvair.entities.AirQuality;

/**
 * Data Transfer Object for AirQuality entity.
 * 
 * This class is used to transfer AirQuality data between layers of the application.
 */
public class AirQualityReponseDto {

    private String date;
    private MunicipalityResponseDto municipality;
    private List<ParticleResponseDto> particles;
    
    /** Air quality index */
    private int aqi;

    /**
     * Default constructor.
     */
    public AirQualityReponseDto() {
        super();
    }

    /**
     * Constructs an AirQualityReponseDto with the specified date, municipality, and particles.
     * 
     * @param date the date of the air quality measurement
     * @param municipality the municipality where the air quality measurement was taken
     * @param particles the list of particles measured
     */
    public AirQualityReponseDto(String date, MunicipalityResponseDto municipality, List<ParticleResponseDto> particles,int aqi) {
        super();
        this.date = date;
        this.municipality = municipality;
        this.particles = particles;
        this.aqi = aqi;
    }

    /**
     * Constructs an AirQualityReponseDto from an AirQuality entity.
     * 
     * @param airQuality the AirQuality entity
     */
    public AirQualityReponseDto(AirQuality airQuality) {
        this.date = airQuality.getDate();
        this.municipality = new MunicipalityResponseDto(airQuality.getMunicipality());
        this.particles = airQuality.getParticles().stream().map(ParticleResponseDto::new).toList();
        this.aqi = airQuality.getAqi();
    }

    /**
     * Gets the date of the air quality measurement.
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the municipality where the air quality measurement was taken.
     * 
     * @return the municipality
     */
    public MunicipalityResponseDto getMunicipality() {
        return municipality;
    }

    /**
     * Gets the list of particles measured.
     * 
     * @return the particles
     */
    public List<ParticleResponseDto> getParticles() {
        return particles;
    }

    /**
     * Sets the date of the air quality measurement.
     * 
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets the municipality where the air quality measurement was taken.
     * 
     * @param municipality the municipality to set
     */
    public void setMunicipality(MunicipalityResponseDto municipality) {
        this.municipality = municipality;
    }

    /**
     * Sets the list of particles measured.
     * 
     * @param particles the particles to set
     */
    public void setParticles(List<ParticleResponseDto> particles) {
        this.particles = particles;
    }

	/** Get the aqi
	 * @return the aqi
	 */
	public int getAqi() {
		return aqi;
	}

	/** Set the aqi
	 * @param aqi the aqi to set
	 */
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
    
    
    
    
}
