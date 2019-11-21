package com.kencorp.databinding.echo2;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kencorp.databinding.R;
import com.kencorp.databinding.databinding.Echo2Binding;

public class EchoActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Echo2Binding binding = DataBindingUtil.setContentView(this, R.layout.echo_2);
        binding.setEcho(new Echo());
    }
}
