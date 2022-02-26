package com.example.roomdatabase30112021.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase30112021.R;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

        mViewModel.getListWorks().observe(this, new Observer<List<WorkEntity>>() {
            @Override
            public void onChanged(List<WorkEntity> workEntities) {
                Log.d("BBB",workEntities.size() + "");
            }
        });

        mViewModel.queryListWorks();
    }
}