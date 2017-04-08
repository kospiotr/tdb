/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/config/CustomLocalDateSerializer.java.p.vm
 */
package pl.xperios.tdb.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class CustomLocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(date != null ? ISO_LOCAL_DATE.format(date) + "T00:00:00.000Z" : null);
    }
}
