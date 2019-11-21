package com.kencorp.databinding;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.kencorp.databinding.databinding.ActivityMainBinding;
import com.kencorp.databinding.util.TextWatcherAdapter;

import org.parceler.Parcels;


public class MainActivity extends AppCompatActivity {

    public static final String LOGIN_INFO = "loginInfo";

    private LoginInfo loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = (ActivityMainBinding)DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (savedInstanceState == null) {
            loginInfo = new LoginInfo();
        } else {
            loginInfo = Parcels.unwrap(savedInstanceState.getParcelable(LOGIN_INFO));
        }
        binding.setLoginInfo(loginInfo);

        TextWatcherAdapter watcher = new TextWatcherAdapter() {
            @Override public void afterTextChanged(Editable s) {
                loginInfo.validate(getResources());
            }
        };

        binding.email.addTextChangedListener(watcher);
        binding.password.addTextChangedListener(watcher);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                loginInfo.loginExecuted = true;
                if (loginInfo.validate(getResources())) {
                    Snackbar.make(binding.getRoot(), loginInfo.email.get() + " - " + loginInfo.password.get(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LOGIN_INFO, Parcels.wrap(loginInfo));
    }
}
