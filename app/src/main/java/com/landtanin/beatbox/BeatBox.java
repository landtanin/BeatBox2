package com.landtanin.beatbox;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Created by Tanin on 14/11/2017.
 */

public class BeatBox {

    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
    }

}
