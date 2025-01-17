package com.employee.management.empDetails.model;

import com.employee.management.employee.model.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String city;
    public String address;
    public String phoneNumber;
    public String gender;

//    @OneToOne
//    @JoinColumn(name = "employee_id")
//    public Employee employee;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee; // Reference to Employee

    public void setEmployee(Employee employee) {
        this.employee = employee;

        // Getters and Setters
    }
}

