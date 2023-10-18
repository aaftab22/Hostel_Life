package com.darksunTechnologies.hostellife;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface staffDao {
    @Insert
    void insertAllStaff(StaffModel staff);

    @Query("SELECT * FROM Staff_details")
    List<StaffModel> getAllStaff();

    @Query("DELETE FROM Staff_details WHERE staffId = :id")
    void deleteById(int id);

    @Query("UPDATE Staff_details SET full_name = :fullname, address = :address, email = :email, contact_no = :mobileNo WHERE staffId= :id")
    void updateById(int id,String fullname,String address,String email,String mobileNo);

}
