package pl.zagola.bakery.legacy.timeprovider;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimeProvider {
    public static OffsetDateTime now() {
        return Instant.now().atOffset(ZoneOffset.UTC); //return current time as OffsetDateTime in UTC
    }

    public static boolean dateBetween(Instant instant, Instant from, Instant to) {
        if (instant == null || from == null || to == null) {
            return false;
        }
        return !instant.isBefore(from) && !instant.isAfter(to); //from <= instant <= to
    }

    public static Instant thresholdBeforeYears(int years) {
        if (years <= 0) {
            return now().toInstant(); //all employees
        }
        return now().minusYears(years).toInstant(); //threshold: now - x years
    }

    public static Instant thresholdBeforeDays(int days) {
        if (days <= 0) {
            return now().toInstant();
        }
        return now().minusDays(days).toInstant(); //threshold: now - x days
    }

    public static boolean isYear(Instant instant, int year) {
        if (instant == null) {
            return false;
        }
        return instant.atOffset(ZoneOffset.UTC).getYear() == year; //check year form date
    }
}