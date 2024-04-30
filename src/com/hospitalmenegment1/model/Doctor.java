package com.hospitalmenegment1.model;

public class Doctor {
    private  int D_id;
    private  String name;
    private String email;

    private String designation;

    private int pid;

    public Doctor() {
    }
    public Doctor(int D_id,String name,String email,String designation,int pid) {
        this.D_id = D_id;
        this.name=name;
        this.email=email;
        this.designation=designation;

        this.pid=pid;

    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "D_id=" + D_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", pid=" + pid +
                '}';
    }
}
