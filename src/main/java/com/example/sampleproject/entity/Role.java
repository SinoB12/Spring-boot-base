package com.example.sampleproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Role {
    Integer roleNo;
    String roleName;
    Boolean deleteYn;
}
