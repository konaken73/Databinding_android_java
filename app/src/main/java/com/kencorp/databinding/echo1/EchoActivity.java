package com.kencorp.databinding.echo1;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kencorp.databinding.R;
import com.kencorp.databinding.databinding.Echo1Binding;

public class EchoActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Echo1Binding binding = DataBindingUtil.setContentView(this, R.layout.echo_1);
        binding.setEcho(new Echo());
    }
}
