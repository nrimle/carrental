package ch.juventus.rimle.carrental.enums;

/**
 * Defines all available transmissions
 */
public enum Transmission {

    MANUAL,
    AUTOMATIC;

    /**
     * Translates string to transmission to support case insensitivity
     * @param value transmission as string
     * @return transmission
     */
    public static Transmission fromString(String value) {
        for (Transmission transmission : Transmission.values()) {
            if (transmission.name().equalsIgnoreCase(value)) {
                return transmission;
            }
        }
        throw new IllegalArgumentException("Unknown Transmission: " + value);
    }
}
