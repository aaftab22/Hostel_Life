package com.example.hostellife;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StudentModel.class , StaffModel.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract studentDao studentDao();
    public abstract staffDao staffDao();

}


//to create multiple table in single database
//@Database(entities = {StudentModel.class
//        , StaffModel.class}, version = 1)
//public abstract class AppDatabase extends RoomDatabase {
//    public abstract studentDao studentDao();
//    public abstract staffDao staffDao();
//
//}