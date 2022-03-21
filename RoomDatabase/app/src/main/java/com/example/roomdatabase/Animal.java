package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ANIMAL")
public class Animal
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="TYPE")
    private String type;
    @ColumnInfo(name="NAME")
    private String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

//    public Animal(int id, String type, String name) {
//        this.id = id;
//        this.type = type;
//        this.name = name;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
