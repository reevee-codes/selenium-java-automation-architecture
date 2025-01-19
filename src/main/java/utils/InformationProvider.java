package utils;
import java.util.ResourceBundle;

public class InformationProvider {

    public static final String TESTING_BROWSER = "Testing.Browser";
    public static String getTestingBrowser() {
        return getRequiredData(TESTING_BROWSER);
    }

    public static String getRequiredData(final String key) {
        return ResourceBundle.getBundle("InformationProvider").getString(key);
    }
}
