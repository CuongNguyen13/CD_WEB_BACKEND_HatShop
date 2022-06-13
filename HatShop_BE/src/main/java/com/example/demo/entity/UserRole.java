package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appRole_id")
    private AppRole appRoleId;

    public UserRole() {
    }

    public int getUserRoleId() {
        return id;
    }

    public void setUserRoleId(int userRoleId) {
        this.id = userRoleId;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public AppRole getRoleId() {
        return appRoleId;
    }

    public void setRoleId(AppRole appRoleId) {
        this.appRoleId = appRoleId;
    }
}
