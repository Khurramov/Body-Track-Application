package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dailyexercises extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.bodytrack.MESSAGE";
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String url="";
    int flag;
    Button markAsComplete;
    ListView listView;
    List<Video> video = new ArrayList<>();
    VideoPlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyexercises);

        markAsComplete = findViewById(R.id.markAsComplete);
        listView = findViewById(R.id.videoList);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("videos");

        adapter = new VideoPlayerAdapter(this, video);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0)
                {
                    if (video.get(position-1).getFlag() == 0) {
                        listView.getChildAt(position).setEnabled(false);
                        Toast.makeText(getApplicationContext(), "You have to watch previous video first.",Toast.LENGTH_LONG).show();
                    }
                    else //video.get(position - 1).getFlag() == 1)
                         {
                            Intent intent = new Intent(getApplicationContext(), VideoplayerMainActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("key",video.get(position).getVideoTitle());
                            extras.putString("url",video.get(position).getUrl());
                            extras.putString("flag", String.valueOf(video.get(position).getFlag()));
                            extras.putString("option", "1");
                            intent.putExtras(extras);
                            startActivity(intent);
                        }
                    }
                else {
                        Intent intent = new Intent(getApplicationContext(), VideoplayerMainActivity.class);
                        Bundle extras = new Bundle();
                        extras.putString("key", video.get(position).getVideoTitle());
                        extras.putString("url", video.get(position).getUrl());
                        extras.putString("flag", String.valueOf(video.get(position).getFlag()));
                        extras.putString("option", "1");
                        intent.putExtras(extras);
                        startActivity(intent);
                    }

            }
        });



//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                   for(DataSnapshot myDataSnapshot : snapshot.getChildren()){
//                        Video video = myDataSnapshot.getValue(Video.class);
//
//                        assert video != null;
//                        flag = video.getFlag();
//                        if (flag == 0) {
//                            url = video.getUrl();
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Getting Post failed, log a message
//                Toast toast = Toast.makeText(getApplicationContext(), (CharSequence) error.toException(), Toast.LENGTH_LONG);
//                toast.show();
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        video.clear();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String itemKey;

                for (DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {

                    Video db_video = myDataSnapshot.getValue(Video.class);
                    System.out.println("Video url: " + db_video.getUrl());
                    itemKey = myDataSnapshot.getKey();
                    Video current_video = new Video(itemKey,db_video.getUrl(), db_video.getFlag());


                    video.add(current_video);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}