package pl.xperios.tdb.web.locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class MyReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {
    public Map<Object, Object> getAllProperties(Locale locale) {
        clearCacheIncludingAncestors();
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        Properties properties = propertiesHolder.getProperties();
        return properties;
    }
}
