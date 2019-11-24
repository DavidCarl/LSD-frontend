package com.zee.servlets.web.viewmodels;

public class UserVM {
    private int userId;
    private int agencyNumber;
    String userName;
    String password;

    public UserVM() {
    }

    public UserVM(int userId, int agencyNumber, String userName, String password) {
        this.userId = userId;
        this.agencyNumber = agencyNumber;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getAgencyNumber() {
        return agencyNumber;
    }
    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "userId=" + userId +
                ", agencyNumber=" + agencyNumber +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
