package pl.zagola.bakery.hiredate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.zagola.bakery.timeprovider.TimeProvider;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Instant threshold = TimeProvider.thresholdBeforeDays(daysBack);
        return hireDateList.stream()
                .filter(h -> h.getHireDate() != null && h.getHireDate().isAfter(threshold))
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findLongTermEmployees(int minYears) {
        Instant threshold = TimeProvider.thresholdBeforeYears(minYears);
        return hireDateList.stream()
                .filter(h -> h.getHireDate() != null && h.getHireDate().isBefore(threshold))
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findByHireYear(int year) {
        return hireDateList.stream()
                .filter(h -> TimeProvider.isYear(h.getHireDate(), year))
                .collect(Collectors.toList());
    }

    @Override
    public List<HireDate> findHireDateBetween(Instant from, Instant to) {
        if (from == null || to == null || from.isAfter(to)) {
            return List.of();
        }
        return hireDateList.stream()
                .filter(h -> TimeProvider.dateBetween(h.getHireDate(), from, to))
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