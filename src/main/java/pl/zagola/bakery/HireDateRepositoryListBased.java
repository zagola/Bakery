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
import static java.time.temporal.ChronoUnit.YEARS;

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
        return List.of();
    }

    @Override
    public boolean updateHireDate(Long id, Instant newHireDate) {
        return false;
    }

}