package com.example.roomdatabase30112021.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase30112021.data.database.AppDatabase;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;
import com.example.roomdatabase30112021.data.repositories.WorkRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<WorkEntity>> listWorks = new MutableLiveData<>();
    private MutableLiveData<Long> idInsert = new MutableLiveData<>();
    private WorkRepository workRepository;
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
        workRepository = new WorkRepository(context);
    }

    public LiveData<List<WorkEntity>> getListWorks() {
        return listWorks;
    }

    public LiveData<Long> getIdInsert() {
        return idInsert;
    }

    public void queryListWorks(){
        workRepository
                .getListWorks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<WorkEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<WorkEntity> workEntities) {
                        listWorks.setValue(workEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void insertWork(WorkEntity workEntity){
        workRepository
                .insertWork(workEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Long aLong) {
                        idInsert.setValue(aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
