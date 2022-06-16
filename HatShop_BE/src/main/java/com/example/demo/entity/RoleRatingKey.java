package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RoleRatingKey implements Serializable {
    @Column(name = "user_id")
    int userId;

    @Column(name = "role_id")
    int roleId;

    public RoleRatingKey(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public RoleRatingKey() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRatingKey that = (RoleRatingKey) o;
        return userId == that.userId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    @Override
    public String toString() {
        return "RoleRatingKey{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
