package com.ahmadmuzaki.submission_github;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadmuzaki.submission_github.databinding.ItemBinding;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserViewHolder> {

    Context context;
    private final ArrayList<DataUser> listDataUser;

    public ListUserAdapter(Context context, ArrayList<DataUser> listDataUser) {
        this.context = context;
        this.listDataUser = listDataUser;
    }


    @NonNull
    @Override
    public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemBinding binding = ItemBinding.inflate(inflater, parent, false);
        return new ListUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {
        DataUser dataUser = listDataUser.get(position);
        holder.binding.username.setText(dataUser.getUsername());
        holder.binding.avatar.setImageResource(dataUser.getAvatar());
        holder.binding.itemNama.setText(dataUser.getName());
        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("DATA", dataUser);
            holder.binding.getRoot().getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listDataUser.size();
    }

    public static class ListUserViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;
        public ListUserViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
