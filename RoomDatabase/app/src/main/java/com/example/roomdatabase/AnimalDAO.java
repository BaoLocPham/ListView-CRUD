package com.example.roomdatabase;

import androidx.room.*;
import java.util.List;

@Dao
public interface AnimalDAO {

    @Query("SELECT * FROM ANIMAL")
    List<Animal> getAll();

    @Insert
    void insertAll(Animal... animals);

    @Delete
    void delete(Animal animal);
}
