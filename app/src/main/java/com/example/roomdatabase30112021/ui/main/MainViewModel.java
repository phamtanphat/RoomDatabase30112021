package com.example.roomdatabase30112021.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase30112021.data.database.AppDatabase;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;
import com.example.roomdatabase30112021.data.repositories.WorkRepository;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<WorkEntity>> listWorks = new MutableLiveData<>();
    private WorkRepository workRepository;
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
        workRepository = new WorkRepository(context);
    }

    public LiveData<List<WorkEntity>> getListWorks() {
        return listWorks;
    }

    public void queryListWorks(){
        workRepository.getListWorks();
    }

}
