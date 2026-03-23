package pl.zagola.bakery;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

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
        return List.of();
    }

    @Override
    public List<HireDate> findByHireYear(int year) {
        return List.of();
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