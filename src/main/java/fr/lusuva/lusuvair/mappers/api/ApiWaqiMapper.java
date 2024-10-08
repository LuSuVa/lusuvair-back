package fr.lusuva.lusuvair.mappers.api;

import java.util.ArrayList;
import java.util.List;

import fr.lusuva.lusuvair.dtos.apidto.WaqiDataDto;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Particle;

/**
 * Utility class for mapping data transfer objects (DTOs) from the API to entity objects used in the application.
 */
public class ApiWaqiMapper {

    /**
     * Converts a {@link WaqiDataDto} object to an {@link AirQuality} entity.
     * 
     * <p>This method maps the relevant fields from the {@link WaqiDataDto} object to an instance of
     * {@link AirQuality}. Currently, it only sets the date field from the DTO to the entity.</p>
     * 
     * @param waqiDataDto the {@link WaqiDataDto} object containing air quality data
     * @return an {@link AirQuality} entity with the date field set from the DTO
     */
    public AirQuality convertToEntity(WaqiDataDto waqiDataDto) {
        AirQuality airQuality = new AirQuality();
        // Extract the date from the DTO
        String date = waqiDataDto.getDataDto().getTime().getS();
        airQuality.setDate(date);
        return airQuality;  
    }

    /**
     * Converts a {@link WaqiDataDto} object to a list of {@link Particle} entities.
     * 
     * @param waqiDataDto the {@link WaqiDataDto} object containing air quality index data
     * @return a list of {@link Particle} entities with names and quantities set from the DTO
     */
    public List<Particle> convertToParticleToEntity(WaqiDataDto waqiDataDto) {
        List<Particle> listParticule = new ArrayList<>();

        // Create and add Particle entities to the list
        Particle particleDew = new Particle();
        particleDew.setName("dew");
        particleDew.setQuantity(waqiDataDto.getDataDto().getIaqi().getDew().getV());
        particleDew.setUnit("°");
        listParticule.add(particleDew);

        Particle particleH = new Particle();
        particleH.setName("h");
        particleH.setQuantity(waqiDataDto.getDataDto().getIaqi().getH().getV());
        particleH.setUnit("%");
        listParticule.add(particleH);

        Particle particleNo2 = new Particle();
        particleNo2.setName("no2");
        particleNo2.setQuantity(waqiDataDto.getDataDto().getIaqi().getNo2().getV());
        particleNo2.setUnit("µg/m³");
        listParticule.add(particleNo2);

        Particle particleO3 = new Particle();
        particleO3.setName("o3");
        particleO3.setQuantity(waqiDataDto.getDataDto().getIaqi().getO3().getV());
        particleO3.setUnit("µg/m³");
        listParticule.add(particleO3);

        Particle particleP = new Particle();
        particleP.setName("p");
        particleP.setQuantity(waqiDataDto.getDataDto().getIaqi().getP().getV());
        particleP.setUnit("hpa");
        listParticule.add(particleP);

        Particle particlePm10 = new Particle();
        particlePm10.setName("pm10");
        particlePm10.setQuantity(waqiDataDto.getDataDto().getIaqi().getPm10().getV());
        particlePm10.setUnit("µg/m³");
        listParticule.add(particlePm10);

        Particle particlePm25 = new Particle();
        particlePm25.setName("pm25");
        particlePm25.setQuantity(waqiDataDto.getDataDto().getIaqi().getPm25().getV());
        particlePm25.setUnit("µg/m³");
        listParticule.add(particlePm25);

        Particle particleSo2 = new Particle();
        particleSo2.setName("so2");
        particleSo2.setQuantity(waqiDataDto.getDataDto().getIaqi().getSo2().getV());
        particleSo2.setUnit("µg/m³");
        listParticule.add(particleSo2);

        Particle particleT = new Particle();
        particleT.setName("t");
        particleT.setQuantity(waqiDataDto.getDataDto().getIaqi().getT().getV());
        particleT.setUnit("°");
        listParticule.add(particleT);

        Particle particleW = new Particle();
        particleW.setName("w");
        particleW.setQuantity(waqiDataDto.getDataDto().getIaqi().getW().getV());
        particleW.setUnit("km/h");
        listParticule.add(particleW);

        Particle particleWg = new Particle();
        particleWg.setName("wg");
        particleWg.setQuantity(waqiDataDto.getDataDto().getIaqi().getWg().getV());
        particleWg.setUnit("km/h");
        listParticule.add(particleWg);

        return listParticule;
    }
}
