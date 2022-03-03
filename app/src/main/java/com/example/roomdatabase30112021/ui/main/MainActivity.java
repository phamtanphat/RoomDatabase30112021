package com.example.roomdatabase30112021.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.roomdatabase30112021.R;
import com.example.roomdatabase30112021.classes.adapter.WorkAdapter;
import com.example.roomdatabase30112021.classes.dialog.AppDialog;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;
import com.example.roomdatabase30112021.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mViewModel;
    WorkAdapter mWorkAdapter;
    ActivityMainBinding mMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);


        mWorkAdapter = new WorkAdapter();
        mMainBinding.recyclerViewWorks.setAdapter(mWorkAdapter);

        mViewModel.getListWorks().observe(this, new Observer<List<WorkEntity>>() {
            @Override
            public void onChanged(List<WorkEntity> workEntities) {
                if (workEntities != null && workEntities.size() > 0){
                    mWorkAdapter.updateList(workEntities);
                }
            }
        });
//        mViewModel.getIdInsert().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Log.d("BBB","Row " + aLong + "");
//            }
//        });
//
        mViewModel.queryListWorks();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_plus:
                AppDialog.createDialog(this, new AppDialog.OnListenClickDialog() {
                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onSave(String title, String message) {
                        if (title.isEmpty() && message.isEmpty()){
                            Toast.makeText(MainActivity.this, "Empty value", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mViewModel.insertWork(new WorkEntity(title,message));
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}