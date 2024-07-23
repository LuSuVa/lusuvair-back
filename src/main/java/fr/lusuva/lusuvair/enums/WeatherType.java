package fr.lusuva.lusuvair.enums;

/**
 * Enum representing various types of weather conditions.
 */
public enum WeatherType {
    SUNNY(0, "Sunny", "Ensoleillé"),
    PARTLY_CLOUDY(1, "Partly Cloudy", "Partiellement nuageux"),
    CLOUDY_SKY(2, "Cloudy Sky", "Ciel nuageux"),
    CLOUDY(3, "Cloudy", "Nuageux"),
    VERY_CLOUDY(4, "Very Cloudy", "Très nuageux"),
    OVERCAST(5, "Overcast", "Ciel couvert"),
    FOG(6, "Fog", "Brouillard"),
    FREEZING_FOG(7, "Freezing Fog", "Brouillard givrant"),
    LIGHT_RAIN(10, "Light Rain", "Pluie légère"),
    MODERATE_RAIN(11, "Moderate Rain", "Pluie modérée"),
    HEAVY_RAIN(12, "Heavy Rain", "Pluie forte"),
    LIGHT_FREEZING_RAIN(13, "Light Freezing Rain", "Pluie verglaçante légère"),
    MODERATE_FREEZING_RAIN(14, "Moderate Freezing Rain", "Pluie verglaçante modérée"),
    HEAVY_FREEZING_RAIN(15, "Heavy Freezing Rain", "Pluie verglaçante forte"),
    DRIZZLE(16, "Drizzle", "Bruine"),
    LIGHT_SNOW(20, "Light Snow", "Légère neige"),
    MODERATE_SNOW(21, "Moderate Snow", "Neige modérée"),
    HEAVY_SNOW(22, "Heavy Snow", "Forte neige"),
    LIGHT_RAIN_AND_SNOW(30, "Light Rain and Snow", "Légère pluie et neige"),
    MODERATE_RAIN_AND_SNOW(31, "Moderate Rain and Snow", "Pluie et neige modérées"),
    HEAVY_RAIN_AND_SNOW(32, "Heavy Rain and Snow", "Forte pluie et neige"),
    LOCAL_LIGHT_RAIN_SHOWERS(40, "Local Light Rain Showers", "Averses de pluie légères locales"),
    LOCAL_RAIN_SHOWERS(41, "Local Rain Showers", "Averses de pluie locales"),
    LOCAL_HEAVY_RAIN_SHOWERS(42, "Local Heavy Rain Showers", "Averses de pluie fortes locales"),
    LIGHT_RAIN_SHOWERS(43, "Light Rain Showers", "Averses de pluie légères"),
    RAIN_SHOWERS(44, "Rain Showers", "Averses de pluie"),
    HEAVY_RAIN_SHOWERS(45, "Heavy Rain Showers", "Averses de pluie fortes"),
    FREQUENT_LIGHT_RAIN_SHOWERS(46, "Frequent Light Rain Showers", "Fréquentes averses de pluie légères"),
    FREQUENT_RAIN_SHOWERS(47, "Frequent Rain Showers", "Fréquentes averses de pluie"),
    FREQUENT_HEAVY_RAIN_SHOWERS(48, "Frequent Heavy Rain Showers", "Fréquentes averses de pluie fortes"),
    LOCAL_LIGHT_SNOW_SHOWERS(60, "Local Light Snow Showers", "Averses de neige légères locales"),
    LOCAL_SNOW_SHOWERS(61, "Local Snow Showers", "Averses de neige locales"),
    LOCAL_HEAVY_SNOW_SHOWERS(62, "Local Heavy Snow Showers", "Averses de neige fortes locales"),
    LIGHT_SNOW_SHOWERS(63, "Light Snow Showers", "Averses de neige légères"),
    SNOW_SHOWERS(64, "Snow Showers", "Averses de neige"),
    HEAVY_SNOW_SHOWERS(65, "Heavy Snow Showers", "Averses de neige fortes"),
    FREQUENT_LIGHT_SNOW_SHOWERS(66, "Frequent Light Snow Showers", "Fréquentes averses de neige légères"),
    FREQUENT_SNOW_SHOWERS(67, "Frequent Snow Showers", "Fréquentes averses de neige"),
    FREQUENT_HEAVY_SNOW_SHOWERS(68, "Frequent Heavy Snow Showers", "Fréquentes averses de neige fortes"),
    LOCAL_LIGHT_RAIN_AND_SNOW_SHOWERS(70, "Local Light Rain and Snow Showers",
            "Averses de pluie et neige légères locales"),
    LOCAL_RAIN_AND_SNOW_SHOWERS(71, "Local Rain and Snow Showers", "Averses de pluie et neige locales"),
    LOCAL_HEAVY_RAIN_AND_SNOW_SHOWERS(72, "Local Heavy Rain and Snow Showers",
            "Averses de pluie et neige fortes locales"),
    LIGHT_RAIN_AND_SNOW_SHOWERS(73, "Light Rain and Snow Showers", "Averses de pluie et neige légères"),
    RAIN_AND_SNOW_SHOWERS(74, "Rain and Snow Showers", "Averses de pluie et neige"),
    HEAVY_RAIN_AND_SNOW_SHOWERS(75, "Heavy Rain and Snow Showers", "Averses de pluie et neige fortes"),
    FREQUENT_LIGHT_RAIN_AND_SNOW_SHOWERS(76, "Frequent Light Rain and Snow Showers",
            "Fréquentes averses de pluie et neige légères"),
    FREQUENT_RAIN_AND_SNOW_SHOWERS(77, "Frequent Rain and Snow Showers", "Fréquentes averses de pluie et neige"),
    FREQUENT_HEAVY_RAIN_AND_SNOW_SHOWERS(78, "Frequent Heavy Rain and Snow Showers",
            "Fréquentes averses de pluie et neige fortes"),
    LOCAL_LIGHT_THUNDERSTORMS(100, "Local Light Thunderstorms", "Orages légers locaux"),
    LOCAL_THUNDERSTORMS(101, "Local Thunderstorms", "Orages locaux"),
    LOCAL_HEAVY_THUNDERSTORMS(102, "Local Heavy Thunderstorms", "Orages forts locaux"),
    LIGHT_THUNDERSTORMS(103, "Light Thunderstorms", "Orages légers"),
    THUNDERSTORMS(104, "Thunderstorms", "Orages"),
    HEAVY_THUNDERSTORMS(105, "Heavy Thunderstorms", "Orages forts"),
    FREQUENT_LIGHT_THUNDERSTORMS(106, "Frequent Light Thunderstorms", "Fréquents orages légers"),
    FREQUENT_THUNDERSTORMS(107, "Frequent Thunderstorms", "Fréquents orages"),
    FREQUENT_HEAVY_THUNDERSTORMS(108, "Frequent Heavy Thunderstorms", "Fréquents orages forts"),
    LOCAL_LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(120, "Local Light Snow or Sleet Thunderstorms",
            "Orages de neige ou de grêle légers locaux"),
    LOCAL_SNOW_OR_SLEET_THUNDERSTORMS(121, "Local Snow or Sleet Thunderstorms", "Orages de neige ou de grêle locaux"),
    LOCAL_HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(122, "Local Heavy Snow or Sleet Thunderstorms",
            "Orages de neige ou de grêle forts locaux"),
    LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(123, "Light Snow or Sleet Thunderstorms", "Orages de neige ou de grêle légers"),
    SNOW_OR_SLEET_THUNDERSTORMS(124, "Snow or Sleet Thunderstorms", "Orages de neige ou de grêle"),
    HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(125, "Heavy Snow or Sleet Thunderstorms", "Orages de neige ou de grêle forts"),
    FREQUENT_LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(126, "Frequent Light Snow or Sleet Thunderstorms",
            "Fréquents orages de neige ou de grêle légers"),
    FREQUENT_SNOW_OR_SLEET_THUNDERSTORMS(127, "Frequent Snow or Sleet Thunderstorms",
            "Fréquents orages de neige ou de grêle"),
    FREQUENT_HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(128, "Frequent Heavy Snow or Sleet Thunderstorms",
            "Fréquents orages de neige ou de grêle forts"),
    LOCAL_LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(130, "Local Light Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle légers locaux"),
    LOCAL_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(131, "Local Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle locaux"),
    LOCAL_HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(132, "Local Heavy Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle forts locaux"),
    LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(133, "Light Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle légers"),
    RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(134, "Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle"),
    HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(135, "Heavy Rain and Snow or Sleet Thunderstorms",
            "Orages de pluie et neige ou grêle forts"),
    FREQUENT_LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(136, "Frequent Light Rain and Snow or Sleet Thunderstorms",
            "Fréquents orages de pluie et neige ou grêle légers"),
    FREQUENT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(137, "Frequent Rain and Snow or Sleet Thunderstorms",
            "Fréquents orages de pluie et neige ou grêle"),
    FREQUENT_HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(138, "Frequent Heavy Rain and Snow or Sleet Thunderstorms",
            "Fréquents orages de pluie et neige ou grêle forts"),
    THUNDERY_RAIN(140, "Thundery Rain", "Pluie orageuse"),
    THUNDERY_RAIN_AND_SNOW(141, "Thundery Rain and Snow", "Pluie et neige orageuses"),
    THUNDERY_SNOW(142, "Thundery Snow", "Neige orageuse"),
    LIGHT_INTERMITTENT_RAIN(210, "Light Intermittent Rain", "Pluie intermittente légère"),
    MODERATE_INTERMITTENT_RAIN(211, "Moderate Intermittent Rain", "Pluie intermittente modérée"),
    HEAVY_INTERMITTENT_RAIN(212, "Heavy Intermittent Rain", "Pluie intermittente forte"),
    LIGHT_INTERMITTENT_SNOW(220, "Light Intermittent Snow", "Neige intermittente légère"),
    MODERATE_INTERMITTENT_SNOW(221, "Moderate Intermittent Snow", "Neige intermittente modérée"),
    HEAVY_INTERMITTENT_SNOW(222, "Heavy Intermittent Snow", "Neige intermittente forte"),
    RAIN_AND_SNOW(230, "Rain and Snow", "Pluie et neige"),
    RAIN_AND_SNOW_AGAIN(231, "Rain and Snow Again", "Pluie et neige à nouveau"),
    RAIN_AND_SNOW_ONCE_MORE(232, "Rain and Snow Once More", "Pluie et neige encore une fois"),
    HAIL_SHOWERS(235, "Hail Showers", "Averses de grêle");

    private final int code;
    private final String description;
    private final String frenchDescription;

    /**
     * Constructs a WeatherType enum with the specified code and description.
     * 
     * @param code the unique code representing the weather type
     * @param description the description of the weather type
     * @param frenchDescription the description of the weather type in french
     */
    private WeatherType(int code, String description, String frenchDescription) {
		this.code = code;
		this.description = description;
		this.frenchDescription = frenchDescription;
	}

    /**
     * Gets the code representing the weather type.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }
	

	/**
     * Gets the description of the weather type.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
	 * @return the frenchDescription
	 */
	public String getFrenchDescription() {
		return frenchDescription;
	}

	/**
     * Returns the WeatherType enum constant corresponding to the specified code.
     * 
     * @param weatherCode the code representing the weather type
     * @return the corresponding WeatherType enum constant, or null if no match is found
     */
    public static WeatherType getWeatherType(int weatherCode) {
        for (WeatherType type : WeatherType.values()) {
            if (type.getCode() == weatherCode) {
                return type;
            }
        }
        return null;
    }
    
    
}