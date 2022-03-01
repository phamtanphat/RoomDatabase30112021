package com.example.roomdatabase30112021.classes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase30112021.R;
import com.example.roomdatabase30112021.data.model.entities.WorkEntity;
import com.example.roomdatabase30112021.databinding.ItemWorkBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {
    private List<WorkEntity> lstWorks;
    private LayoutInflater layoutInflater;
    private Context context;

    public WorkAdapter() {
        lstWorks = new ArrayList<>();

    }

    public void updateList(List<WorkEntity> workEntities) {
        if (lstWorks != null && lstWorks.size() > 0) {
            lstWorks.clear();
        }
        lstWorks.addAll(workEntities);
        notifyDataSetChanged();
    }

    public List<WorkEntity> getList(){
        return lstWorks;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        this.context = parent.getContext();
        ItemWorkBinding itemWorkBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_work, parent, false);
        return new WorkViewHolder(itemWorkBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkViewHolder holder, int position) {
        holder.bind(lstWorks.get(position));
    }

    @Override
    public int getItemCount() {
        return lstWorks != null && lstWorks.size() > 0 ? lstWorks.size() : 0;
    }

    class WorkViewHolder extends RecyclerView.ViewHolder {

        ItemWorkBinding binding;

        public WorkViewHolder(@NonNull ItemWorkBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
        }

        void bind(WorkEntity workEntity){
            binding.setWork(workEntity);
        }
    }
}
