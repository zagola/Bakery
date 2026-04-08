package pl.zagola.bakery;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimeProvider {
    public static OffsetDateTime now() {
        return Instant.now().atOffset(ZoneOffset.UTC); //return current time as OffsetDateTime in UTC
    }
}