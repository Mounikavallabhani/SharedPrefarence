package com.example.mansopresk14.sharedprefarence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by john on 12/18/2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    String flowerNames[] ={"wrose","rose","pink","pink","yellowrose","rose","pink"} ;
    Integer images[] = {R.drawable.image1,

            R.drawable.image2,R.drawable.image3,

            R.drawable.image2,R.drawable.image1,

            R.drawable.image3,R.drawable.image2,

            R.drawable.image1};



    public CustomAdapter(AppleFragment appleFragment) {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, final int position) {

        holder.name.setText(flowerNames[position]);
        holder.image.setBackgroundResource(images[position]);




    }

    @Override
    public int getItemCount() {
        return flowerNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name ;

        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.text1);
            image = (ImageView) itemView.findViewById(R.id.image1);

        }
    }

}

