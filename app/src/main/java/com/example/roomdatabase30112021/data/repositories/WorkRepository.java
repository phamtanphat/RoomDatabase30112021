package com.example.roomdatabase30112021.data.repositories;

import android.content.Context;

import com.example.roomdatabase30112021.data.database.AppDatabase;
import com.example.roomdatabase30112021.data.database.WordDao;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

public class WorkRepository {
    private WordDao wordDao;

    public WorkRepository(Context context) {
        wordDao = AppDatabase.getInstance(context).wordDao();

    }

    public Observable<List<WorkEntity>> getListWorks() {
        return wordDao.getListWorks();
    }

    public Maybe<Long> insertWork(WorkEntity workEntity) {
        return wordDao.insertWork(workEntity);
    }
}
