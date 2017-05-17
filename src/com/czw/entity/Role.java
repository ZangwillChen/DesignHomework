package com.czw.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenzhaowen on 2017/5/16.
 */
public class Role {

    private long roleID;
    private String roleName;
    private int permission;
    private Set<User> users = new HashSet<>();

    public Role(){

    }

    public Role(long roleID,String roleName,int permission,Set<User> users){
        this.roleID = roleID;
        this.roleName = roleName;
        this.permission = permission;
        this.users = users;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
