package pl.zagola.bakery;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HireDateRepositoryListBased implements HireDateRepository {
    private HireDate hireDate;
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
        return List.of();
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
    public boolean updateHireDate(Long id, Instant hireDate) {
        return false;
    }

    @Override
    public boolean deleteHireDate(Long id) {
        return false;
    }
}