package com.example.bodytrack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class exercise extends AppCompatActivity {

    ListView list;
    String titles[]={"Arm","Armtriceps","Benchpress", "Arm","Bicep","Bicepcurls","Bicycle","Concentraioncurl","Legs"};
    int imgs[]={R.drawable.arm,R.drawable.armtriceps,R.drawable.benchpress,R.drawable.arm,R.drawable.bicep,R.drawable.bicepcurls,
            R.drawable.bicycle,R.drawable.concentrationcurl,R.drawable.leg,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        list = findViewById(R.id.list1);
        MyAdapter adapter=new MyAdapter(this, titles,imgs);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(exercise.this, "Item One Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(exercise.this, "Item Two Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item Three Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item four Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item five Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item six Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item seven Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item eight Clicked",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(exercise.this, "Item nine Clicked",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] myTitles;
        int[] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs){
            super(c,R.layout.exercie_row, R.id.text1, titles);
            this.context=c;
            this.imgs=imgs;
            this.myTitles=titles;
        }

        @NonNull
        @Override
        public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.exercie_row, parent, false);
            ImageView images=row.findViewById(R.id.logo);
            TextView myTitle= row.findViewById(R.id.text1);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);

            return row;
        }
    }
}