package com.employee.management.empProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeProjectDto {
    private Long id;
    private Long projectId;
    private Date startDate;
    private Date endDate;
}
