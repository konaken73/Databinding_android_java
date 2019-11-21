package com.kencorp.databinding.echo;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kencorp.databinding.R;
import com.kencorp.databinding.databinding.EchoBinding;

import org.parceler.Parcels;

public class EchoActivity extends AppCompatActivity {

    public static final String ECHO = "ECHO";

    private Echo echo;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EchoBinding binding = DataBindingUtil.setContentView(this, R.layout.echo);
        if (savedInstanceState == null) {
            echo = new Echo();
        } else {
            echo = Parcels.unwrap(savedInstanceState.getParcelable(ECHO));
        }
        binding.setEcho(echo);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ECHO, Parcels.wrap(echo));
    }
}
