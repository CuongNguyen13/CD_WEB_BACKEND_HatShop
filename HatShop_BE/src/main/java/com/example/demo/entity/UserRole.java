package com.example.demo.entity;

import javax.persistence.*;

@Entity
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

    public void setId(RoleRatingKey id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
