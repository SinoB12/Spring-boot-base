package com.example.sampleproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    String empNo;
    String empName;
    String email;
    String phone1;
    String phone2;
    Boolean deleteYn;
}
