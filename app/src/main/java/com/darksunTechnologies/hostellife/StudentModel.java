package com.darksunTechnologies.hostellife;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Student_details")
public class StudentModel {
    @PrimaryKey (autoGenerate = true)
    public int studentId;

    @ColumnInfo(name = "full_name")
    public String fullname;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "contact_no")
    public String contactno;

    @ColumnInfo(name = "collage_name")
    public String collagename;

    public StudentModel(String fullname, String address, String email, String contactno) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.contactno = contactno;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getCollagename() {
        return collagename;
    }

    public void setCollagename(String collagename) {
        this.collagename = collagename;
    }
}
