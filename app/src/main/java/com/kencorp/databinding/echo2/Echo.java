package com.kencorp.databinding.echo2;


import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.ObservableField;

import com.kencorp.databinding.util.Objects;
import com.kencorp.databinding.util.TextWatcherAdapter;

public class Echo {
    public ObservableField<String> text = new ObservableField<>();

    public TextWatcher watcher = new TextWatcherAdapter() {
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(text.get(), s.toString())) {
                text.set(s.toString());
            }
        }
    };
}
