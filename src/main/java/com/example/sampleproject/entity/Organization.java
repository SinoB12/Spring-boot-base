package com.example.sampleproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Organization {
    Long orgNo;
    String orgName;
    Long upperOrgNo;

}
