package com.example.bodytrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.Date;
import java.util.List;

public class VideoPlayerAdapter extends ArrayAdapter<Video> {
    public VideoPlayerAdapter(@NonNull Context context, @NonNull List<Video> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        VideoViewHolder viewHolder;

        if (itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.row_video,parent,false);

            viewHolder= new VideoViewHolder(itemView);

            itemView.setTag(viewHolder);
        }else {
            viewHolder = (VideoViewHolder)itemView.getTag();
        }
        Video video = getItem(position);
        Date currentDate=new Date();
        viewHolder.videoTxt.setText("Video Title: " + video.getVideoTitle());
        if (video.getFlag() == 0) {
            viewHolder.videoTxt.setTextColor(ContextCompat.getColor(getContext(), R.color.teal_200));
        }else{
            viewHolder.videoTxt.setTextColor(ContextCompat.getColor(getContext(), R.color.btnColor));
        }
        return itemView;

    }
    public class VideoViewHolder{
        TextView videoTxt;
        public  VideoViewHolder (View itemView){
            videoTxt=itemView.findViewById(R.id.videoTxt);
        }

    }
}
