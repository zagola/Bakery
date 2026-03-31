package pl.zagola.bakery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Repository
public class HireDateRepositoryListBased implements HireDateRepository {

    private List<HireDate> hireDateList = new ArrayList<>();

    @Override
    public boolean addHireDate(Long personId, Instant hireDate) {
        return hireDateList.add(new HireDate(personId, hireDate));
    }

    @Override
    public List<HireDate> findAll() {
        return new ArrayList<>(hireDateList);
    }

    @Override
    public List<HireDate> findNewHires(int daysBack) {
        Instant threshold = Instant.now().minus(daysBack, DAYS);
        return hireDateList.stream()
                .filter(h -> h.getHireDate().isAfter(threshold))
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findLongTermEmployees(int minYears) {
        OffsetDateTime now = Instant.now().atOffset(ZoneOffset.UTC); //add time-zone, convert to instant
        OffsetDateTime threshold = now.minusYears(minYears);
        Instant thresholdInstant = threshold.toInstant();
        return hireDateList.stream()
                .filter(h -> h.getHireDate().isBefore(thresholdInstant))
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findByHireYear(int year) {
        return hireDateList.stream()
                .filter(h -> h.getHireDate() != null)
                .filter(h -> {
                    OffsetDateTime hireDate = h.getHireDate().atOffset(ZoneOffset.UTC); //convert instant - offsetDateTime(add UTC offset)
                    return hireDate.getYear() == year;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findHireDateBetween(Instant from, Instant to) {
        if (from == null || to == null || from.isAfter(to)) {
            return List.of();
        }
        return hireDateList.stream()
                .filter(h -> h.getHireDate() != null)
                .filter(h -> !h.getHireDate().isBefore(from) && !h.getHireDate().isAfter(to))  //from <= hireDate <= to
                .collect(Collectors.toList());

    }

    @Override
    public boolean updateHireDate(Long personId, Instant newHireDate) {
        if (personId == null || newHireDate == null) {
            return false;
        }
        return hireDateList.stream()
                .filter(h -> h.getPersonId().equals(personId))
                .findFirst()
                .map(h -> {
                    hireDateList.removeIf(existing -> existing.getPersonId().equals(personId));
                    hireDateList.add(new HireDate(personId, newHireDate));
                    return true;
                })
                .orElse(false);
    }

}