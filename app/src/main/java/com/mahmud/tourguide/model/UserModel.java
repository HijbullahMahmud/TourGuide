package com.mahmud.tourguide.model;

public class UserModel {
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
     private int id;


    public UserModel(String userName,String email, String phoneNumber,  String address) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

   /* public UserModel(String userName, String email, String phoneNumber, String address, String password, int id) {

        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.id = id;

    }*/
    public UserModel(String userName,   String email,String phoneNumber, String address,String password ) {
         this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}

