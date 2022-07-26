package org.example.homework2;

import java.util.ArrayList;
import java.util.List;

public class MyUser {

    private Integer userID;

    private List<Integer> userList = new ArrayList<>();

    public Integer getUserID() {
        return userID;
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public MyUser(Integer userID, List<Integer> userList) {
        this.userID = userID;
        this.userList = userList;
    }
}
