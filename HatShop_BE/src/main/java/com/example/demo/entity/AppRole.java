package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appRole")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleName")
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "appRoleId")
    private List<UserRole> appRoleList = new ArrayList<>();

    public AppRole() {
    }

    public int getRoleId() {
        return id;
    }

    public void setRoleId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
