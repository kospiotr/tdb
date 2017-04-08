/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/config/CustomLocalDateTimeDeserializer.java.p.vm
 */
package pl.xperios.tdb.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private final int length = "yyyy-mm-ddThh:mm:ss".length();

    public LocalDateTime deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        if (parser.hasTokenId(JsonTokenId.ID_STRING)) {
            String date = parser.getText().trim();

            if (date.isEmpty()) {
                return null;
            }

            date = date.substring(0, length);
            return LocalDateTime.parse(date);
        }

        return null;
    }
}
