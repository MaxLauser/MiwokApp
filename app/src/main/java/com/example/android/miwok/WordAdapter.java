package com.example.android.miwok;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Error404 on 3/24/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    private Context context;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        this.context = context;
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        // Get the {@link Word} word object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Find the TextView in the list_item.xml layout with the ID miwak_text_view
        TextView miwakTextView = (TextView) listItemView.findViewById(R.id.miwak_text_view);

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){

            // set the image associated to the current word
            image.setImageResource(currentWord.getImageResourceId());

            // set visibility of the image
            image.setVisibility(View.VISIBLE);
        }
        else image.setVisibility(View.GONE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Set the theme color for audio container in the list item
        View audioContainer = listItemView.findViewById(R.id.audio_Container);

        // Set the background color of the text container View
        audioContainer.setBackgroundColor(color);

        // Get the english translation from the current word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // get the miwak translation for the current word object and
        // set this text on the miwak TextView
        miwakTextView.setText(currentWord.getMiwakTranslation());

        // connect to the ImageButton to play audio
        ImageButton playAudio = (ImageButton) listItemView.findViewById(R.id.playAudio);

        // play Miwak audio for the current word
        playAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final MediaPlayer miwakAudio = MediaPlayer.create(context,currentWord.getMiwakAudioResourceId());
                miwakAudio.start();
                miwakAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        miwakAudio.release();
                    }
                });
            }
        });


        return listItemView;
    }
}
