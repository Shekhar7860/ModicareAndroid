
package com.modicare;
public class Userdetails {

    public String name;
    public String email;
    public String address;
    public String image;


    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}