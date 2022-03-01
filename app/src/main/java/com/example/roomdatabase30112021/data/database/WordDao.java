package com.example.roomdatabase30112021.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase30112021.data.model.entities.WorkEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface WordDao {

    @Query("Select * from work")
    Observable<List<WorkEntity>> getListWorks();

    @Insert
    Maybe<Long> insertWork(WorkEntity workEntity);
}
