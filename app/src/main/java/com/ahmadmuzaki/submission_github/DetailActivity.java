package com.ahmadmuzaki.submission_github;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmadmuzaki.submission_github.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DataUser dataUser = getIntent().getParcelableExtra("DATA");

        binding.avatar.setImageResource(dataUser.getAvatar());
        binding.name.setText(dataUser.getName());
        binding.username.setText(dataUser.getUsername());
        binding.follower.setText(dataUser.getFollower());
        binding.following.setText(dataUser.getFollowing());
    }
}