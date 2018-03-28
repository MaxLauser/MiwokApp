package com.example.android.miwok;

/**
 * Created by Error404 on 3/19/2018.
 */

public class Word {

    /** Default Translation for the word */
    private String mDefaultTranslation;


    /** Miwak Translation for the word */
    private String mMiwakTranslation;

    /** Miwak audio file for the word */
    private int mMiwakAudioResourceId;


    /** image that represent the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** create new word object
     *
     * @param defaultTranslation    the english word
     * @param miwakTranslation      the miwak translation of the english word
     * @param imageResourceId      the image represent the word
     */
    public Word(String defaultTranslation, String miwakTranslation, int imageResourceId, int miwakAudioResourceId){

        mMiwakTranslation = miwakTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mMiwakAudioResourceId = miwakAudioResourceId;
    }

    /** creat new word object
     *
     * @param defaultTranslation    the english word
     * @param miwakTranslation      the miwak translation of the english word
     */
    public Word(String defaultTranslation, String miwakTranslation, int miwakAudioResourceId){

        mMiwakTranslation = miwakTranslation;
        mDefaultTranslation = defaultTranslation;
        mMiwakAudioResourceId = miwakAudioResourceId;
    }

    /**
     * get the default translation of the word
     */

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * get the Miwak translation of the word
     */
    public String getMiwakTranslation(){
        return mMiwakTranslation;
    }

    /**
     * get the image that represent the word
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * get the miwak audio associated to the word
     */
    public int getMiwakAudioResourceId(){
        return mMiwakAudioResourceId;
    }

    /**
     * check if the word has an image
     * @return true if the word has image, false otherwise
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
