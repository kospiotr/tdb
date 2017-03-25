package pl.xperios.tdb.web.locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LocaleMessagesSerializer {

    @Autowired
    private MyReloadableResourceBundleMessageSource messageSource;

    public String getMessages() throws JsonProcessingException {
        Map<Object, Object> properties = messageSource.getAllProperties(LocaleContextHolder.getLocale());
        return new ObjectMapper().writeValueAsString(properties);
    }

}
