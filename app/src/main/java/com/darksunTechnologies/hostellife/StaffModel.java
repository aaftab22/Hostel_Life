package com.darksunTechnologies.hostellife;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Staff_details")
public class StaffModel {
    @PrimaryKey(autoGenerate = true)
    public int staffId;

    @ColumnInfo(name = "full_name")
    public String fullname;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "contact_no")
    public String contactno;

    @ColumnInfo(name = "post_name")
    public String postname;

    public StaffModel(String fullname, String address, String email, String contactno) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.contactno = contactno;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }
}
