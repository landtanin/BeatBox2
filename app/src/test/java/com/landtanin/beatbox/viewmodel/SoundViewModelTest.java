package com.landtanin.beatbox.viewmodel;

import com.landtanin.beatbox.model.BeatBox;
import com.landtanin.beatbox.model.Sound;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

/**
 * Created by Tanin on 15/11/2017.
 */
public class SoundViewModelTest {

    @Mock
    private BeatBox mBeatBox;

    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {

//        mBeatBox = mock(BeatBox.class);
        MockitoAnnotations.initMocks(this);

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