package com.example.watch.ui.popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class popularViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public popularViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is popular fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}