package com.ahmadmuzaki.submission_github;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.ahmadmuzaki.submission_github.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<DataUser> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.itemList.setHasFixedSize(true);
        list.addAll(getListUser());
        binding.itemList.setLayoutManager(new LinearLayoutManager(this));
        ListUserAdapter listUserAdapter = new ListUserAdapter(this, list);
        binding.itemList.setAdapter(listUserAdapter);


    }

    public ArrayList<DataUser> getListUser() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataUsername = getResources().getStringArray(R.array.data_username);
        String[] dataFollower = getResources().getStringArray(R.array.data_follower);
        String[] dataFollowing = getResources().getStringArray(R.array.data_following);
        @SuppressLint("Recycle") TypedArray dataAvatar = getResources().obtainTypedArray(R.array.data_avatar);

        ArrayList<DataUser> listUser = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            DataUser data = new DataUser();
            data.setName(dataName[i]);
            data.setUsername(dataUsername[i]);
            data.setFollower(dataFollower[i]);
            data.setFollowing(dataFollowing[i]);
            data.setAvatar(dataAvatar.getResourceId(i, -1));

            listUser.add(data);

        }
        return listUser;
    }


}