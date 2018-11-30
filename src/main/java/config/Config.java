package config;

public final class Config {
    public static String DATA_PATH = getEvn("DATA_PATH", "./");
    public static int THREAD_NUM = getEvn("THREAD_NUM", 10);

    private static String getEvn(String evnName, String defaultValue) {
        String value = System.getenv(evnName);
        return value != null ? value : defaultValue;
    }

    private static int getEvn(String evnName, int defaultValue) {
        String value = System.getenv(evnName);
        return value != null ? Integer.valueOf(value) : defaultValue;
    }
}
