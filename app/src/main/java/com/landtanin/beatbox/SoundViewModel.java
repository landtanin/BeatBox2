package com.landtanin.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Tanin on 14/11/2017.
 */

public class SoundViewModel extends BaseObservable{
    private Sound mSound;
    private BeatBox mBeatBox;


    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        this.mSound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle(){
        return mSound.getName();
    }

    public void onButtonClicked() {

        mBeatBox.play(mSound);

    }
}
