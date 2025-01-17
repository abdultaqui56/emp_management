package com.employee.management.region.model;

import com.employee.management.organization.model.Organization;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String city;
    public String state;
    public String country;
    public Long pincode;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    public Organization organization;

//    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public List<Employee> employees;

    // Getters and Setters

    // Getters and Setters for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

