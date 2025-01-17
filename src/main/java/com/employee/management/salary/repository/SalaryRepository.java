package com.employee.management.salary.repository;

import com.employee.management.salary.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    // Custom queries can be added here if needed

    // query for highest paid salary
    @Query(value = "SELECT amount FROM (SELECT DISTINCT amount FROM Salary ORDER BY amount DESC) AS ranked LIMIT 1 OFFSET 0", nativeQuery = true)
    Double findHighestUniqueSalary();


//     query for highest paid by region
//    @Query("SELECT s FROM Salary s WHERE s.amount = (SELECT MAX(s2.amount) FROM Salary s2 WHERE s2.employee.region.id = :regionId)")
//    Salary findHighestPaidSalaryByRegion(@Param("regionId") Long regionId);

    @Query("SELECT s FROM Salary s WHERE s.amount = (SELECT MAX(s2.amount) FROM Salary s2 WHERE s2.employee.region.id = :regionId) AND s.employee.region.id = :regionId ORDER BY s.amount DESC")
    List<Salary> findHighestPaidSalaryByRegion(@Param("regionId") Long regionId);



//    @Query("SELECT e.region.id, MAX(s.amount) " +
//            "FROM Salary s " +
//            "JOIN s.employee e " +
//            "WHERE e.region.id = :regionId " +
//            "GROUP BY e.region.id")
//    Object[] findHighestSalaryByRegion(@Param("regionId") Long regionId);






    // query for third highest paid salary
    @Query(value = "SELECT amount FROM (SELECT amount, DENSE_RANK() OVER (ORDER BY amount DESC) as rnk FROM Salary) ranked WHERE rnk = 3 LIMIT 1", nativeQuery = true)
    Double findThirdHighestUniqueSalary();


    // query for second highest paid  salary
    @Query(value = "SELECT amount FROM (SELECT amount, DENSE_RANK() OVER (ORDER BY amount DESC) as rnk FROM Salary) ranked WHERE rnk = 2 LIMIT 1", nativeQuery = true)
    Double findSecondHighestUniqueSalary();

    // Query for lowest paid salary
    @Query(value = "SELECT MIN(amount) FROM salary LIMIT 1", nativeQuery = true)
    Double findLowestUniqueSalary();
}
