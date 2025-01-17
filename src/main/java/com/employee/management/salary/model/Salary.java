package com.employee.management.salary.model;

import com.employee.management.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long salaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;  // Link to the Employee model

    private Double amount;
    private String currency;
    private String role;

    @Column(name = "salary_start_date")
    private LocalDate salaryStartDate;

    @Column(name = "salary_end_date")
    private LocalDate salaryEndDate;

    // New attributes added
    private Double bonus; // Bonus attribute
    private String salaryType;  // Salary type (e.g., "Monthly", "Hourly")

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getSalaryStartDate() {
        return salaryStartDate;
    }

    public void setSalaryStartDate(LocalDate salaryStartDate) {
        this.salaryStartDate = salaryStartDate;
    }

    public LocalDate getSalaryEndDate() {
        return salaryEndDate;
    }

    public void setSalaryEndDate(LocalDate salaryEndDate) {
        this.salaryEndDate = salaryEndDate;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

// Getters and setters for new fields (Lombok will generate them automatically)
}
