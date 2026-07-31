package feidiasantoniouacademy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public final class AppiumTestConfig {

    private AppiumTestConfig() {
    }

    public static String getAppiumHost() {
        return getOrDefault("appium.server.host", "127.0.0.1");
    }

    public static int getAppiumPort() {
        return Integer.parseInt(getOrDefault("appium.server.port", "4723"));
    }

    public static String getAppiumServerUrl() {
        return "http://" + getAppiumHost() + ":" + getAppiumPort();
    }

    public static String getAppiumJsPath() {
        return getOrDefault("appium.js.path", "");
    }

    public static String getAndroidDeviceName() {
        return getOrDefault("android.device.name", "Android Emulator");
    }

    public static String getAndroidAppPath() {
        return resolveExistingPath(getOrDefault("android.app.path", ""), "src/test/resources/apps/General-Store.apk");
    }

    public static String getChromedriverPath() {
        return getOrDefault("chromedriver.path", "");
    }

    public static String getIOSDeviceName() {
        return getOrDefault("ios.device.name", "iPhone 13 Pro");
    }

    public static String getIOSAppPath() {
        return resolveExistingPath(getOrDefault("ios.app.path", ""), "src/test/resources/apps/UIKitCatalog.app");
    }

    public static String getIOSPlatformVersion() {
        return getOrDefault("ios.platform.version", "15.5");
    }

    public static String getBrowserName() {
        return getOrDefault("browser.name", "Chrome");
    }

    private static String resolveExistingPath(String configuredPath, String fallbackRelativePath) {
        if (configuredPath != null && !configuredPath.isBlank()) {
            Path configured = Path.of(configuredPath);
            if (Files.exists(configured)) {
                return configured.toString();
            }
            return configuredPath;
        }

        Path fallback = Path.of(fallbackRelativePath);
        if (Files.exists(fallback)) {
            return fallback.toString();
        }

        return "";
    }

    private static String getOrDefault(String key, String defaultValue) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty.trim();
        }

        String envKey = key.toUpperCase(Locale.ROOT).replace('.', '_');
        String environmentValue = System.getenv(envKey);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue.trim();
        }

        return defaultValue;
    }
}
