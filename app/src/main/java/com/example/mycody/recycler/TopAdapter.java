package com.example.mycody.recycler;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycody.R;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolder> {
    private ArrayList<Dictionary> mList;

    public class TopViewHolder extends RecyclerView.ViewHolder{
        protected ImageView top_image;
        protected TextView top_name;
        public TopViewHolder(View view){
            super(view);
            this.top_image = (ImageView)view.findViewById(R.id.top_image);
            this.top_name = (TextView)view.findViewById(R.id.top_name);
        }
    }

    public TopAdapter(ArrayList<Dictionary> list){
        this.mList = list;
    }

    @Override
    public TopViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.top_item_list, viewGroup, false);

        TopViewHolder viewHolder = new TopViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder viewholder, int position) {
        viewholder.top_image.setImageResource(R.color.colorAccent);
        viewholder.top_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.top_name.setGravity(Gravity.CENTER);

        viewholder.top_name.setText(mList.get(position).getTopName());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }


}
