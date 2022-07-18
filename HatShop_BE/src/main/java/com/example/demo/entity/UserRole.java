package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "userRole")
public class UserRole {
    @EmbeddedId
    private RoleRatingKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name = "role_id")
    private Role roleId;

    public UserRole() {
    }

    public UserRole(RoleRatingKey roleRatingKey, User user, Role role) {
        this.id = roleRatingKey;
        this.userId = user;
        this.roleId = role;
    }

    public RoleRatingKey getId() {
        return id;
    }

}
