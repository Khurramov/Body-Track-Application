package com.example.bodytrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainArrayAdapter extends ArrayAdapter<point_value> {

    public MainArrayAdapter(@NonNull Context context, List<point_value> history) {
        super(context, 0, history);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        ViewHolder viewHolder;

        if (itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.row_history,parent,false);

            viewHolder=new ViewHolder(itemView);

            itemView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)itemView.getTag();
        }
        point_value history=getItem(position);
        Date currentDate=new Date();
        viewHolder.historytxt.setText("Weight: " + String.format("%s --  %s", history.getkgValue(),
                DateFormat.getDateInstance().format(history.getdateValue())));
        return itemView;

    }
    public class ViewHolder{
        TextView historytxt;
        public  ViewHolder (View itemView){
            historytxt=itemView.findViewById(R.id.historytxt);
        }

    }
}
