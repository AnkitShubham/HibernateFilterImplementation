package dev.project.hibernateFilterImplementation.context;

public class CountryContext {
    private static final ThreadLocal<String> country = new ThreadLocal<>();

    public static void setCountry(String value) { country.set(value); }
    public static String getCountry() { return country.get(); }

    public static void clear() {
        country.remove();
    }
}
