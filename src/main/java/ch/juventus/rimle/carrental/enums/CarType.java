package ch.juventus.rimle.carrental.enums;

/**
 * Defines all available car types
 */
public enum CarType {
    SUV,
    HATCHBACK,
    CONVERTIBLE,
    SEDAN,
    SPORTS_CAR,
    COUPE,
    MINIVAN,
    STATION_WAGON,
    PICKUP_TRUCK;

    /**
     * Translates string to car type to support case insensitivity
     * @param value car type as string
     * @return car type
     */
    public static CarType fromString(String value) {
        for (CarType carType : CarType.values()) {
            if (carType.name().equalsIgnoreCase(value)) {
                return carType;
            }
        }
        throw new IllegalArgumentException("Unknown CarType: " + value);
    }
}

