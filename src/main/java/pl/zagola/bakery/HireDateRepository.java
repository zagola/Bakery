package pl.zagola.bakery;

import java.time.Instant;
import java.util.List;

public interface HireDateRepository {
    boolean addHireDate(Long personId, Instant hireDate);

    List<HireDate> findAll();

    List<HireDate> findNewHires(int daysBack);

    List<HireDate> findLongTermEmployees(int minYears);

    List<HireDate> findByHireYear(int year);

    List<HireDate> findHireDateBetween(Instant from, Instant to);

    boolean updateHireDate(Long personId, Instant newHireDate);
    
}