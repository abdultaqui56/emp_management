package com.employee.management.employee.model;

import com.employee.management.bandAndRole.model.BandAndRole;
import com.employee.management.empDetails.model.EmpDetails;
import com.employee.management.empProject.model.EmployeeProject;
import com.employee.management.region.model.Region;
import com.employee.management.salary.model.Salary;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Data
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;  // ensure ID is string for random ID


    public String firstName;
    public String lastName;
    public String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Date dob;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Date joiningDate;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonBackReference
    public Region region;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_details_id")
    public EmpDetails empDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "empProject_id")
    public List<EmployeeProject> empProjects;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "empBand_id")
//    public List<BandAndRole> bandAndRoles;



//    public Employee() {
//        this.id = generateRandomId();
//    }

//    private String generateRandomId() {
//        Random random = new Random();
//        int randomId = 100000 + random.nextInt(900000);
//        return String.valueOf(randomId);
//    }

    public EmpDetails getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(EmpDetails empDetails) {
        this.empDetails = empDetails;
    }


    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<EmployeeProject> getEmpProjects() {
        return empProjects;
    }

    public void setEmpProjects(List<EmployeeProject> empProjects) {
        this.empProjects = empProjects;
    }

    // Getters and Setters for region
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}

