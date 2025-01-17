package com.employee.management.organization.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String orgName;
    public String orgAddress;
    public String website;

//    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
//    public List<Region> regions;

    // Getters and Setters
}
