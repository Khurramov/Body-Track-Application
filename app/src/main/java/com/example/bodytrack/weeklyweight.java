package com.example.bodytrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class weeklyweight extends AppCompatActivity {

    EditText kgValue;
    Button insertbtn,button;
    TextView historyTxt;
    ListView listView;


    FirebaseDatabase database;
    DatabaseReference reference, databaseReference;
    LineGraphSeries<DataPoint> series;
    GraphView graphView;

    List<point_value> pt = new ArrayList<>();
    MainArrayAdapter adapter;

    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate=new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeklyweight);


        listView=findViewById(R.id.history);

        insertbtn=(Button) findViewById(R.id.insertbtn);
        graphView=(GraphView) findViewById(R.id.graphView);
        kgValue = findViewById(R.id.KG);
        series=new LineGraphSeries<>();
        graphView.addSeries(series);


        database=FirebaseDatabase.getInstance();
        reference=database.getReference("chartTable");
        databaseReference = database.getReference().child("chartTable");



        setListener();
        graphView.getGridLabelRenderer().setNumHorizontalLabels(7);
//        graphView.getViewport().setScalable(true); // enables horizontal zooming and scrolling
//        graphView.getViewport().setScalableY(true); // enables vertical zooming and scrolling

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return sdf.format(new Date((long)value));
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = pt.get(position).getKey();
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context,key, Toast.LENGTH_LONG);
                toast.show();
                databaseReference.child(key).removeValue();
                adapter.notifyDataSetChanged();

            }
        });


        //Button for moving to diet page//
        //Button for moving to diet page//
        button=(Button) findViewById(R.id.dietBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiet();
            }
        });

        adapter=new MainArrayAdapter(this, pt);
        listView.setAdapter(adapter);
    }

    private void opendiet() {
        Intent intent = new Intent(this, bmi.class);
        startActivity(intent);
    }
    //-----//



    private void setListener() {
        Date currentDate=new Date();
        insertbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!kgValue.getText().toString().isEmpty()){
                    String id=reference.push().getKey();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currentDate);
                    calendar.add(Calendar.DATE, -2);
                    Date d = calendar.getTime();

                    String y = kgValue.getText().toString();
    //                long =new Date().getTime();

                    point_value point_value=new point_value(y, d);

    //                Context context = getApplicationContext();
    //                Toast toast = Toast.makeText(context,"Try to save data", Toast.LENGTH_LONG);
    //                toast.show();
                    pt.clear();

                    reference.child(id).setValue(point_value);
                    kgValue.setText("");
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please provide your weight in the Input text first!! ", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Date currentDate=new Date();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                String key = snapshot.getKey();

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context,key, Toast.LENGTH_LONG);
                toast.show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataPoint[] dp=new DataPoint[(int) dataSnapshot.getChildrenCount()];
                int index=0;
                String itemKey;

                for (DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {

                    point_value point_value=myDataSnapshot.getValue(point_value.class);
                    itemKey = myDataSnapshot.getKey();
                    dp[index]=new DataPoint(point_value.getdateValue(), Float.parseFloat(point_value.getkgValue()));
                    point_value current_pt = new point_value(point_value.getkgValue(),point_value.getdateValue(), itemKey);

                    pt.add(current_pt);
                    adapter.notifyDataSetChanged();
                    index++;
                }
                try {
                    series.resetData(dp);
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error "+ e, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}