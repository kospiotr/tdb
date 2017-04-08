/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/config/CustomLocalDateDeserializer.java.p.vm
 */
package pl.xperios.tdb.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {

        if (parser.hasTokenId(JsonTokenId.ID_STRING)) {
            String date = parser.getText().trim();
            if (date.isEmpty()) {
                return null;
            }
            date = date.substring(0, 10); // yyyy-mm-dd
            return LocalDate.parse(date);
        }

        return null;
    }
}
