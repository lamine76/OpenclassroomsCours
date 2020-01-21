package com.openclassrooms.magicgithub;

import android.app.Application;

import androidx.annotation.VisibleForTesting;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.repository.UserRepository;

public class MagicGithubApplication extends Application {

    private UserRepository userRepository;

    // ---

    public UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    @VisibleForTesting
    public void resetUserRepository() {
        userRepository = null;
    }
}
