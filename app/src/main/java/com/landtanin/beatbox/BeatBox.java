package com.landtanin.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanin on 14/11/2017.
 */

public class BeatBox {

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        // SoundPool(maximum sounds to play at a given time, kind of audio stream, quality)
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds() {

        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assest", ioe);
            return;
        }

        for (String filename : soundNames) {

            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);

        }

    }

    private void load(Sound sound) throws IOException {

        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());

        // load file into SoundPool for playback
        int soundId = mSoundPool.load(afd, 1);

        sound.setSoundId(soundId);

    }

    public List<Sound> getSounds() {
        return mSounds;
    }

}
