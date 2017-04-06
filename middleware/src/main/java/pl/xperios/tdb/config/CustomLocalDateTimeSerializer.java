/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/config/CustomLocalDateTimeSerializer.java.p.vm
 */
package pl.xperios.tdb.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(date != null ? ISO_LOCAL_DATE_TIME.format(date) + ".000Z" : null);
    }
}
