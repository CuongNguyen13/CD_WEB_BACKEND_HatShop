package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleName")
    private String roleName;
    @JsonIgnore
    @ManyToMany(mappedBy = "listRole")
    private List<User> listUser = new ArrayList<>();
    public Role() {

    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", listUser=" + listUser +
                '}';
    }

}
