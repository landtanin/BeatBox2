package com.landtanin.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Tanin on 15/11/2017.
 */
public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {

        mBeatBox = mock(BeatBox.class);

        mSound = new Sound("this could be anything");
        mSubject = new SoundViewModel(mBeatBox);

        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked(){

        mSubject.onButtonClicked();

        // verify() is Mockito's method.
        // This can be interpreted as - Verify that the play(...) method was called on mBeatBox with mSound as a parameter
        verify(mBeatBox).play(mSound);

    }


}