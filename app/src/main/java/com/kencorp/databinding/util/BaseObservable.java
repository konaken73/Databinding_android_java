package com.kencorp.databinding.util;


import androidx.databinding.PropertyChangeRegistry;

import org.parceler.Parcel;
import org.parceler.Transient;

import java.util.Observable;

@Parcel
public class BaseObservable extends Observable {
    @Transient
    private PropertyChangeRegistry mCallbacks;

    public synchronized void addOnPropertyChangedCallback(androidx.databinding.Observable.OnPropertyChangedCallback listener) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new PropertyChangeRegistry();
        }

        this.mCallbacks.add(listener);
    }

    public synchronized void removeOnPropertyChangedCallback(androidx.databinding.Observable.OnPropertyChangedCallback listener) {
        if (this.mCallbacks != null) {
            this.mCallbacks.remove(listener);
        }
    }

    public synchronized void notifyChange() {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks((androidx.databinding.Observable) this, 0, null);
        }
    }

    public void notifyPropertyChanged(int fieldId) {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks((androidx.databinding.Observable) this, fieldId, null);
        }
    }
}
