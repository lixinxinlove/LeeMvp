package com.lee.leemvp.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by android on 2016/11/30.
 */
public class User extends BmobObject {

    private String userName;
    private int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public User(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

}
