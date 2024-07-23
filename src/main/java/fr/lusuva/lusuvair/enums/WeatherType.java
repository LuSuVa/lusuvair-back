package fr.lusuva.lusuvair.enums;

/**
 * Enum representing various types of weather conditions.
 */
public enum WeatherType {
    SUNNY(0, "Sunny"),
    PARTLY_CLOUDY(1, "Partly Cloudy"),
    CLOUDY_SKY(2, "Cloudy Sky"),
    CLOUDY(3, "Cloudy"),
    VERY_CLOUDY(4, "Very Cloudy"),
    OVERCAST(5, "Overcast"),
    FOG(6, "Fog"),
    FREEZING_FOG(7, "Freezing Fog"),
    LIGHT_RAIN(10, "Light Rain"),
    MODERATE_RAIN(11, "Moderate Rain"),
    HEAVY_RAIN(12, "Heavy Rain"),
    LIGHT_FREEZING_RAIN(13, "Light Freezing Rain"),
    MODERATE_FREEZING_RAIN(14, "Moderate Freezing Rain"),
    HEAVY_FREEZING_RAIN(15, "Heavy Freezing Rain"),
    DRIZZLE(16, "Drizzle"),
    LIGHT_SNOW(20, "Light Snow"),
    MODERATE_SNOW(21, "Moderate Snow"),
    HEAVY_SNOW(22, "Heavy Snow"),
    LIGHT_RAIN_AND_SNOW(30, "Light Rain and Snow"),
    MODERATE_RAIN_AND_SNOW(31, "Moderate Rain and Snow"),
    HEAVY_RAIN_AND_SNOW(32, "Heavy Rain and Snow"),
    LOCAL_LIGHT_RAIN_SHOWERS(40, "Local Light Rain Showers"),
    LOCAL_RAIN_SHOWERS(41, "Local Rain Showers"),
    LOCAL_HEAVY_RAIN_SHOWERS(42, "Local Heavy Rain Showers"),
    LIGHT_RAIN_SHOWERS(43, "Light Rain Showers"),
    RAIN_SHOWERS(44, "Rain Showers"),
    HEAVY_RAIN_SHOWERS(45, "Heavy Rain Showers"),
    FREQUENT_LIGHT_RAIN_SHOWERS(46, "Frequent Light Rain Showers"),
    FREQUENT_RAIN_SHOWERS(47, "Frequent Rain Showers"),
    FREQUENT_HEAVY_RAIN_SHOWERS(48, "Frequent Heavy Rain Showers"),
    LOCAL_LIGHT_SNOW_SHOWERS(60, "Local Light Snow Showers"),
    LOCAL_SNOW_SHOWERS(61, "Local Snow Showers"),
    LOCAL_HEAVY_SNOW_SHOWERS(62, "Local Heavy Snow Showers"),
    LIGHT_SNOW_SHOWERS(63, "Light Snow Showers"),
    SNOW_SHOWERS(64, "Snow Showers"),
    HEAVY_SNOW_SHOWERS(65, "Heavy Snow Showers"),
    FREQUENT_LIGHT_SNOW_SHOWERS(66, "Frequent Light Snow Showers"),
    FREQUENT_SNOW_SHOWERS(67, "Frequent Snow Showers"),
    FREQUENT_HEAVY_SNOW_SHOWERS(68, "Frequent Heavy Snow Showers"),
    LOCAL_LIGHT_RAIN_AND_SNOW_SHOWERS(70, "Local Light Rain and Snow Showers"),
    LOCAL_RAIN_AND_SNOW_SHOWERS(71, "Local Rain and Snow Showers"),
    LOCAL_HEAVY_RAIN_AND_SNOW_SHOWERS(72, "Local Heavy Rain and Snow Showers"),
    LIGHT_RAIN_AND_SNOW_SHOWERS(73, "Light Rain and Snow Showers"),
    RAIN_AND_SNOW_SHOWERS(74, "Rain and Snow Showers"),
    HEAVY_RAIN_AND_SNOW_SHOWERS(75, "Heavy Rain and Snow Showers"),
    FREQUENT_LIGHT_RAIN_AND_SNOW_SHOWERS(76, "Frequent Light Rain and Snow Showers"),
    FREQUENT_RAIN_AND_SNOW_SHOWERS(77, "Frequent Rain and Snow Showers"),
    FREQUENT_HEAVY_RAIN_AND_SNOW_SHOWERS(78, "Frequent Heavy Rain and Snow Showers"),
    LOCAL_LIGHT_THUNDERSTORMS(100, "Local Light Thunderstorms"),
    LOCAL_THUNDERSTORMS(101, "Local Thunderstorms"),
    LOCAL_HEAVY_THUNDERSTORMS(102, "Local Heavy Thunderstorms"),
    LIGHT_THUNDERSTORMS(103, "Light Thunderstorms"),
    THUNDERSTORMS(104, "Thunderstorms"),
    HEAVY_THUNDERSTORMS(105, "Heavy Thunderstorms"),
    FREQUENT_LIGHT_THUNDERSTORMS(106, "Frequent Light Thunderstorms"),
    FREQUENT_THUNDERSTORMS(107, "Frequent Thunderstorms"),
    FREQUENT_HEAVY_THUNDERSTORMS(108, "Frequent Heavy Thunderstorms"),
    LOCAL_LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(120, "Local Light Snow or Sleet Thunderstorms"),
    LOCAL_SNOW_OR_SLEET_THUNDERSTORMS(121, "Local Snow or Sleet Thunderstorms"),
    LOCAL_HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(122, "Local Heavy Snow or Sleet Thunderstorms"),
    LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(123, "Light Snow or Sleet Thunderstorms"),
    SNOW_OR_SLEET_THUNDERSTORMS(124, "Snow or Sleet Thunderstorms"),
    HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(125, "Heavy Snow or Sleet Thunderstorms"),
    FREQUENT_LIGHT_SNOW_OR_SLEET_THUNDERSTORMS(126, "Frequent Light Snow or Sleet Thunderstorms"),
    FREQUENT_SNOW_OR_SLEET_THUNDERSTORMS(127, "Frequent Snow or Sleet Thunderstorms"),
    FREQUENT_HEAVY_SNOW_OR_SLEET_THUNDERSTORMS(128, "Frequent Heavy Snow or Sleet Thunderstorms"),
    LOCAL_LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(130, "Local Light Rain and Snow or Sleet Thunderstorms"),
    LOCAL_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(131, "Local Rain and Snow or Sleet Thunderstorms"),
    LOCAL_HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(132, "Local Heavy Rain and Snow or Sleet Thunderstorms"),
    LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(133, "Light Rain and Snow or Sleet Thunderstorms"),
    RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(134, "Rain and Snow or Sleet Thunderstorms"),
    HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(135, "Heavy Rain and Snow or Sleet Thunderstorms"),
    FREQUENT_LIGHT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(136, "Frequent Light Rain and Snow or Sleet Thunderstorms"),
    FREQUENT_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(137, "Frequent Rain and Snow or Sleet Thunderstorms"),
    FREQUENT_HEAVY_RAIN_AND_SNOW_OR_SLEET_THUNDERSTORMS(138, "Frequent Heavy Rain and Snow or Sleet Thunderstorms"),
    THUNDERY_RAIN(140, "Thundery Rain"),
    THUNDERY_RAIN_AND_SNOW(141, "Thundery Rain and Snow"),
    THUNDERY_SNOW(142, "Thundery Snow"),
    LIGHT_INTERMITTENT_RAIN(210, "Light Intermittent Rain"),
    MODERATE_INTERMITTENT_RAIN(211, "Moderate Intermittent Rain"),
    HEAVY_INTERMITTENT_RAIN(212, "Heavy Intermittent Rain"),
    LIGHT_INTERMITTENT_SNOW(220, "Light Intermittent Snow"),
    MODERATE_INTERMITTENT_SNOW(221, "Moderate Intermittent Snow"),
    HEAVY_INTERMITTENT_SNOW(222, "Heavy Intermittent Snow"),
    RAIN_AND_SNOW(230, "Rain and Snow"),
    RAIN_AND_SNOW_AGAIN(231, "Rain and Snow"),
    RAIN_AND_SNOW_ONCE_MORE(232, "Rain and Snow"),
    HAIL_SHOWERS(235, "Hail Showers");

    private final int code;
    private final String description;

    /**
     * Constructs a WeatherType enum with the specified code and description.
     * 
     * @param code the unique code representing the weather type
     * @param description the description of the weather type
     */
    WeatherType(int code, String description) {
        this.code = code;
        this.description = description;
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