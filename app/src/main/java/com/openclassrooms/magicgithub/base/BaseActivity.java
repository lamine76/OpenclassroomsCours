package com.openclassrooms.magicgithub.base;

import androidx.appcompat.app.AppCompatActivity;

import com.openclassrooms.magicgithub.MagicGithubApplication;
import com.openclassrooms.magicgithub.repository.UserRepository;

public abstract class BaseActivity extends AppCompatActivity {

    public UserRepository getUserRepository() {
        return ((MagicGithubApplication) getApplication()).getUserRepository();
    }
}
