package com.example.bodytrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideplayerMainActivity2 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String url="", key="", flag = "";
    Button markAsComplete;
    TextView video_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videplayer_main2);

        markAsComplete = findViewById(R.id.markAsComplete);
        video_status = findViewById(R.id.video_status);

        // Get the Intent that started this activity and extract the string
        Bundle extras = getIntent().getExtras();
        url = extras.getString("url");
        key = extras.getString("key");
        flag = extras.getString("flag");

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("videos2");
        if(flag.equals("1")){
            markAsComplete.setVisibility(View.GONE);
            video_status.setText(R.string.video_status_msg);
        }else {
            video_status.setText(R.string.not_watched_message);
        }

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

//        if(!url.isEmpty()) {

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = url;
                youTubePlayer.loadVideo(videoId, 0);
            }


            @Override
            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
                super.onStateChange(youTubePlayer, state);

            }
        });


        markAsCompleteClickListener();
    }

    private void markAsCompleteClickListener(){
        DatabaseReference databaseRef = firebaseDatabase.getReference("videos2");
        markAsComplete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Update the video flag
                if(!key.isEmpty()) {
//                    HashMap<String, Object>  hashMap = new HashMap<>();
//                    hashMap.put("flag", "1");
//                    hashMap.put("url", url);
//                    new Video(key,url,Integer.parseInt(flag))
                    databaseRef.child(key).child("flag2").setValue(1); //updateChildren(hashMap);
                    finish();
                    Toast.makeText(getApplicationContext(),key + " marked as completed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}